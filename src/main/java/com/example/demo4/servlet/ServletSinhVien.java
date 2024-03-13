package com.example.demo4.servlet;

import com.example.demo4.model.NhanVien;
import com.example.demo4.model.SinhVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

    @WebServlet(name = "ServletSinhVien", value = {"/sinh-vien/trang-chu",
        "/sinh-vien/add"
    })
public class ServletSinhVien extends HttpServlet {
        ArrayList<SinhVien> listSinhVien;
        ArrayList<String> listTenLop;


        public ServletSinhVien() {

            listSinhVien = new ArrayList<>();
            listTenLop = new ArrayList<>();
            listTenLop.add("SD123");
            listTenLop.add("SD321");
            listTenLop.add("SD234");
            listSinhVien.add(new SinhVien("123","sda","đas","ssads"));
            listSinhVien.add(new SinhVien("123","sda","đas","ssads"));
        }

        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listSinhVien",listSinhVien);
        request.getRequestDispatcher("/trang-chu.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maSinhVien = request.getParameter("maSinhVien");
        String hoTen = request.getParameter("tenSinhVien");
        String diaChi = request.getParameter("diaChi");
        String tuoi = request.getParameter("tuoi");
        String tenLop = request.getParameter("tenLop");
        SinhVien sinhvien = new SinhVien(maSinhVien,hoTen,tuoi,diaChi);
        System.out.println();
        listSinhVien.add(sinhvien);
        response.sendRedirect("/sinh-vien/trang-chu");

    }
}
