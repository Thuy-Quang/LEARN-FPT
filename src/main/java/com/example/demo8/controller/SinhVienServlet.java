package com.example.demo8.controller;

import com.example.demo8.entity.SinhVien;
import com.example.demo8.service.SinhVienService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi",
        "/sinh-vien/search",
        "/sinh-vien/remove",
        "/sinh-vien/detail",
        "/sinh-vien/view-update",
        "/dinh-vien/update",
        "/sinh-vien/view-add",
        "/sinh-vien/add"
})
public class SinhVienServlet extends HttpServlet {
    private SinhVienService service = new SinhVienService();
    private List<SinhVien> lists = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // b1 : lay uri tu duong dan

        String uri = request.getRequestURI();
        // b2 check uri thuoc loai nao
        if (uri.contains("hien-thi")) {
            // hien thi danh sach sinh vien
            this.hienthi(request,response);

        } else if (uri.contains("search")) {
            this.searchSV(request,response);
        }
        else if (uri.contains("remove")) {
            this.removeSV(request,response);
        }
        else if (uri.contains("detail")) {
            this.detailSV(request,response);
        }
        else if (uri.contains("view-update")) {
            this.viewUpdate(request,response);
        }
        else {
            this.viewAdd(request,response);
        }

    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/buoi5/add-sinh-vien.jsp").forward(request,response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String index = request.getParameter("viTri");
        SinhVien sv = service.deitalSinhVien(Integer.valueOf(index));
        request.setAttribute("sinhVien",sv);
        request.getRequestDispatcher("/buoi5/update-sinh-vien.jsp").forward(request,response);
    }

    private void detailSV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String index = request.getParameter("viTri");
        SinhVien sv = service.deitalSinhVien(Integer.valueOf(index));
        request.setAttribute("sinhVien",sv);
        request.getRequestDispatcher("/buoi5/detail-sinh-vien.jsp").forward(request,response);
    }

    private void removeSV(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // lay vi tri url
        String index = request.getParameter("viTri");
        service.xoaSinhVien(Integer.valueOf(index));
        response.sendRedirect("/sinh-vien/hien-thi");

    }

    private void searchSV(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienthi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = service.getAll();
        request.setAttribute("abc",lists);
        request.getRequestDispatcher("/buoi5/sinhviens.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
            try {
                this.update(request,response);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            try {
                this.add(request,response);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        SinhVien sinhVien = new SinhVien();
        Integer index = Integer.parseInt(request.getParameter("viTri"));
        BeanUtils.populate(sinhVien,request.getParameterMap());
        service.updateSinhVien(Integer.valueOf(index),sinhVien);
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, InvocationTargetException, IllegalAccessException {
//        String maSV = request.getParameter("maSV");
//        String ten = request.getParameter("ten");
//        String diaChi = request.getParameter("diaChi");
//        Integer tuoi = Integer.parseInt(request.getParameter("tuoi"));
//        String gioiTinh = request.getParameter("gioiTinh");
//        SinhVien sinhVien = new SinhVien(maSV,ten,diaChi,tuoi,Boolean.valueOf(gioiTinh));
//        service.addSinhVien(sinhVien);
////        lists = service.getAll();
////        request.setAttribute("abc",lists);
////        request.getRequestDispatcher("/buoi5/sinhviens.jsp").forward(request,response);
//        response.sendRedirect("/sinh-vien/hien-thi");
        // cach 2 :
        SinhVien sinhVien = new SinhVien();
        BeanUtils.populate(sinhVien,request.getParameterMap());
        service.addSinhVien(sinhVien);
        response.sendRedirect("/sinh-vien/hien-thi");

    }
}
