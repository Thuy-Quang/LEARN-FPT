package com.example.demo4.servlet;

import com.example.demo4.model.DanhMuc;
import com.example.demo4.model.SinhVien;

import com.example.demo4.repository.DanhMucRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "ServletSinhVien", value = {"/sinh-vien/trang-chu",
        "/sinh-vien/add", "/sinh-vien/delete","/sinh-vien/update","/sinh-vien/detail"
})
public class ServletSinhVien extends HttpServlet {
    DanhMucRepository danhMucRepository = new DanhMucRepository();
    ArrayList<SinhVien> listSinhVien = new ArrayList<>();
    ArrayList<String> listTenLop;
    ArrayList<DanhMuc> listDanhMuc = new ArrayList<>();



        public ServletSinhVien() {

            listSinhVien = new ArrayList<>();
            listTenLop = new ArrayList<>();


            listTenLop.add("SD121");
            listTenLop.add("SD122");
            listTenLop.add("SD123");
            listTenLop.add("SD124");
            listSinhVien.add(new SinhVien("1", "sda", "đas", "ssads","S121","Nam"));
            listSinhVien.add(new SinhVien("2", "sda", "đas", "ssads","S122","Nu"));
            listSinhVien.add(new SinhVien("3", "sda", "đas", "ssads","S123","Nam"));
            listSinhVien.add(new SinhVien("4", "sda", "đas", "ssads","S124","Nu"));
        }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();


        if (uri.contains("trang-chu")) {

            // hien thi danh sach sinh vien

            listDanhMuc = danhMucRepository.getList();
            request.setAttribute("listDanhMuc", listDanhMuc);
//            request.setAttribute("tenLop",listTenLop);
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
            request.setAttribute("tenLop",listTenLop);
            request.getRequestDispatcher("/chi-tiet.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();


        if (uri.contains("add")) {
            // hien thi danh sach sinh vien
            this.addSinhVien(request, response);
//            request.setAttribute("listSinhVien", listSinhVien);
//            request.getRequestDispatcher("/trang-chu.jsp").forward(request, response);

        } else   {
            String maSinhVien = request.getParameter("maSV");
            String tenSV = request.getParameter("tenSV");
            String diaChi = request.getParameter("diaChi");
            String tuoi = request.getParameter("tuoi");
            String gioiTinh = request.getParameter("gioiTinh");
            String lop = request.getParameter("lop");
            for(SinhVien sinhVien : listSinhVien){
                if(sinhVien.getMaSV().equals(maSinhVien)){
                    sinhVien.setTenSV(tenSV);
                    sinhVien.setTuoi(tuoi);
                    sinhVien.setDiaChi(diaChi);
                    sinhVien.setGioiTinh(gioiTinh);
                    sinhVien.setTenLop(lop);
                    sinhVien.setGioiTinh(gioiTinh);
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
                break;
            }
        }
        response.sendRedirect("/sinh-vien/trang-chu");
    }

    private void addSinhVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String ma = request.getParameter("maDanhMuc");
            String ten = request.getParameter("tenDanhMuc");
            String trangThai = request.getParameter("trangThai");

            DanhMuc danhMuc = new DanhMuc();
            danhMuc.setMaDanhMuc(ma);
            danhMuc.setTenDanhMuc(ten);
            danhMuc.setTrangThai(trangThai);
            danhMuc.setNgayTao(new Date());
            danhMuc.setNgaySua(new Date());
            danhMucRepository.add(danhMuc);


            response.sendRedirect("/sinh-vien/trang-chu");



//        SinhVien sinhVien = new SinhVien();
//        try {
//            BeanUtils.populate(sinhVien, request.getParameterMap());
//            listSinhVien.add(sinhVien);
//            response.sendRedirect("/sinh-vien/trang-chu");
//        } catch (IllegalAccessException | IOException e) {
//            throw new RuntimeException(e);
//        } catch (InvocationTargetException e) {
//            throw new RuntimeException(e);
//        }
    }
}

