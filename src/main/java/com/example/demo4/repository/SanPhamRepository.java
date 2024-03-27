package com.example.demo4.repository;

import com.example.demo4.connect.HibernateUtils;
import com.example.demo4.model.SanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class SanPhamRepository {
    Session session;

    public ArrayList<SanPham> getList() {
        session = HibernateUtils.getFACTORY().openSession();
        ArrayList<SanPham> list = (ArrayList<SanPham>) session.createQuery("FROM SanPham ").list();
        session.close();
        return list;
    }

    public void add(SanPham sanPham) {
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(sanPham);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }

    public void delete(SanPham sanPham) {
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(sanPham);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }

    public SanPham getDetail(Integer idSanPham) {
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();

        SanPham sanPham = (SanPham) session.createQuery("FROM SanPham where id = :id_1").setParameter("id_1", idSanPham).getSingleResult();

        session.close();
        return sanPham;
    }
}
