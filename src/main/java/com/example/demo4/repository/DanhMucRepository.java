package com.example.demo4.repository;

import com.example.demo4.connect.HibernateUtils;
import com.example.demo4.model.DanhMuc;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class DanhMucRepository {
    Session session;
    public ArrayList<DanhMuc> getList(){
        session = HibernateUtils.getFACTORY().openSession();
        ArrayList<DanhMuc> list = (ArrayList<DanhMuc>) session.createQuery("FROM DanhMuc ").list();
        session.close();
        return list;
    }
    public void add(DanhMuc danhMuc){
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(danhMuc);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }

}
