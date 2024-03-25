package com.example.demo4.servlet;

import com.example.demo4.model.SanPham;
import com.example.demo4.repository.SanPhamRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

@WebServlet(name = "ServletSanPham", value = "/san-pham/hien-thi")
public class ServletSanPham extends HttpServlet {
    ArrayList<SanPham> listSp = new ArrayList<>();
    SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String uri =  request.getRequestURI();
            if(uri.contains("hien-thi")){
                listSp = sanPhamRepository.getList();
                request.setAttribute("listSp",listSp);
                request.getRequestDispatcher("san-pham.jsp").forward(request,response);

            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
