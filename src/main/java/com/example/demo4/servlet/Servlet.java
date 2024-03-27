package com.example.demo4.servlet;

import com.example.demo4.model.MauSac;
import com.example.demo4.repository.MauSacRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Servlet", value = "/mau-sac/hien-thi")
public class Servlet extends HttpServlet {
    MauSacRepository mauSacRepository = new MauSacRepository();
    ArrayList<MauSac> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            list = mauSacRepository.getList();
            request.setAttribute("list",list);
            request.getRequestDispatcher("/mau-sac.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
