package com.example.demo4.repository;

import com.example.demo4.connect.HibernateUtils;
import com.example.demo4.model.MauSac;
import org.hibernate.Session;

import java.util.ArrayList;

public class MauSacRepository {
    Session session;
    public ArrayList<MauSac> getList(){
        session = HibernateUtils.getFACTORY().openSession();
        ArrayList<MauSac> líst = (ArrayList<MauSac>) session.createQuery("FROM MauSac").list();
        session.close();
        return líst;
    }
}
