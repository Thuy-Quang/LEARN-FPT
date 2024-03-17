package com.example.demo4.servlet;

import com.example.demo4.model.NhanVien;
import com.example.demo4.model.SinhVien;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletSinhVien", value = {"/sinh-vien/trang-chu",
        "/sinh-vien/add", "/sinh-vien/delete","/sinh-vien/update","/sinh-vien/detail"
})
public class ServletSinhVien extends HttpServlet {
    ArrayList<SinhVien> listSinhVien = new ArrayList<>();
    ArrayList<String> listTenLop;


        public ServletSinhVien() {

            listSinhVien = new ArrayList<>();
            listTenLop = new ArrayList<>();
            listTenLop.add("SD123");
            listTenLop.add("SD321");
            listTenLop.add("SD234");
            listSinhVien.add(new SinhVien("1", "sda", "đas", "ssads"));
            listSinhVien.add(new SinhVien("2", "sda", "đas", "ssads"));
            listSinhVien.add(new SinhVien("3", "sda", "đas", "ssads"));
            listSinhVien.add(new SinhVien("4", "sda", "đas", "ssads"));
        }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();


        if (uri.contains("trang-chu")) {
            // hien thi danh sach sinh vien
            request.setAttribute("listSinhVien", listSinhVien);
            request.getRequestDispatcher("/trang-chu.jsp").forward(request, response);

        } else if (uri.contains("delete")) {
            this.deleteSinhVien(request,response);
        }else if(uri.contains("detail")){
            String maSV = request.getParameter("id");
            SinhVien sinhVienDetail = new SinhVien();

            for (SinhVien sinhVien : listSinhVien){
                if(sinhVien.getMaSV().equals(maSV)){
                    sinhVienDetail = sinhVien;
                }
            }
            request.setAttribute("sinhVienDetail",sinhVienDetail);
            request.getRequestDispatcher("/chi-tiet.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();


        if (uri.contains("add")) {
            // hien thi danh sach sinh vien
            this.addSinhVien(request, response);
            request.setAttribute("listSinhVien", listSinhVien);
            request.getRequestDispatcher("/trang-chu.jsp").forward(request, response);

        } else   {
            String maSinhVien = request.getParameter("maSV");
            String tenSV = request.getParameter("tenSV");
            String diaChi = request.getParameter("diaChi");
            String tuoi = request.getParameter("tuoi");
            for(SinhVien sinhVien : listSinhVien){
                if(sinhVien.getMaSV().equals(maSinhVien)){
                    sinhVien.setTenSV(tenSV);
                    sinhVien.setTuoi(tuoi);
                    sinhVien.setDiaChi(diaChi);
                }
            }
            response.sendRedirect("/sinh-vien/trang-chu");
        }


    }

    private void deleteSinhVien(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String maSinhVien = request.getParameter("id");
        for(SinhVien sinhVien : listSinhVien){
            if(sinhVien.getMaSV().equals(maSinhVien)){
                listSinhVien.remove(sinhVien);
            }
        }
        response.sendRedirect("/sinh-vien/trang-chu");
    }

    private void addSinhVien(HttpServletRequest request, HttpServletResponse response) {
//            String maSinhVien = request.getParameter("maSinhVien");
//            String hoTen = request.getParameter("tenSinhVien");
//            String diaChi = request.getParameter("diaChi");
//            String tuoi = request.getParameter("tuoi");
//            String tenLop = request.getParameter("tenLop");
//            SinhVien sinhvien = new SinhVien(maSinhVien,hoTen,tuoi,diaChi);
//            System.out.println();
//            listSinhVien.add(sinhvien);
//            response.sendRedirect("/sinh-vien/trang-chu");



        SinhVien sinhVien = new SinhVien();
        try {
            BeanUtils.populate(sinhVien, request.getParameterMap());
            listSinhVien.add(sinhVien);
            response.sendRedirect("/sinh-vien/trang-chu");
        } catch (IllegalAccessException | IOException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}

