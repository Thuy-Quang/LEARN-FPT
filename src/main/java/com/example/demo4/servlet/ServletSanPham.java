package com.example.demo4.servlet;

import com.example.demo4.model.DanhMuc;
import com.example.demo4.model.SanPham;
import com.example.demo4.repository.DanhMucRepository;
import com.example.demo4.repository.SanPhamRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "ServletSanPham", value = {"/san-pham/hien-thi","/san-pham/add","/san-pham/delete"})
public class ServletSanPham extends HttpServlet {
    ArrayList<SanPham> listSp = new ArrayList<>();
    ArrayList<DanhMuc> listDm = new ArrayList<>();
    SanPhamRepository sanPhamRepository = new SanPhamRepository();
    DanhMucRepository danhMucRepository = new DanhMucRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String uri =  request.getRequestURI();
            if(uri.contains("hien-thi")){
                listSp = sanPhamRepository.getList();
                listDm = danhMucRepository.getList();
                request.setAttribute("listDM",listDm);
                request.setAttribute("listSp",listSp);
                request.getRequestDispatcher("/san-pham.jsp").forward(request,response);

            }else if(uri.contains("delete")){
                Integer id = Integer.parseInt(request.getParameter("id"));
                SanPham sanPham = sanPhamRepository.getDetail(id);
                sanPhamRepository.delete(sanPham);
                response.sendRedirect("/san-pham/hien-thi");
            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")){
            String ma = request.getParameter("maSanPham");
            String ten = request.getParameter("tenSanPham");
            String trangThai = request.getParameter("trangThai");
            String danhMuc = request.getParameter("danhMuc");
            SanPham sanPham = new SanPham();
            sanPham.setMaSanPham(ma);
            sanPham.setTenSanPham(ten);
            sanPham.setTrangThai(trangThai);
            sanPham.setNgaySua(new Date());
            sanPham.setNgayTao(new Date());
            DanhMuc danhMuc1 = new DanhMuc();
            danhMuc1.setId(Integer.parseInt(danhMuc));
            sanPham.setDanhMuc(danhMuc1);
            sanPhamRepository.add(sanPham);
            response.sendRedirect("/san-pham/hien-thi");



        }
    }
}
