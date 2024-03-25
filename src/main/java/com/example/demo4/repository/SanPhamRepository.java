package com.example.demo4.repository;

import com.example.demo4.connect.HibernateUtils;
import com.example.demo4.model.DanhMuc;
import com.example.demo4.model.SanPham;
import org.hibernate.Session;

import java.util.ArrayList;

public class SanPhamRepository {
    Session session;
    public ArrayList<SanPham> getList(){
        session = HibernateUtils.getFACTORY().openSession();
        ArrayList<SanPham> list = (ArrayList<SanPham>) session.createQuery("FROM SanPham ").list();
        session.close();
        return list;
    }
}
