package com.example.demo8.service;

import com.example.demo8.entity.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienService {
    private List<SinhVien> listSinhVien = new ArrayList<>();

    public SinhVienService() {
        // fake 5 data
        listSinhVien.add(new SinhVien("SV01","Thuy","Ha Noi",16,true));
        listSinhVien.add(new SinhVien("SV02","Le","Ha nam",16,false));
        listSinhVien.add(new SinhVien("SV03","Quang","Nam Dinh",15,false));
        listSinhVien.add(new SinhVien("SV04","Thuy1","Hai Phong",14,true));
        listSinhVien.add(new SinhVien("SV05","Quang1","Dep Trai",12,false));

    }
    public List<SinhVien> getAll(){
        return listSinhVien;

    }
    public void addSinhVien(SinhVien sv){
        listSinhVien.add(sv);
    }
    public void xoaSinhVien(int index){
        listSinhVien.remove(index);
    }
    public SinhVien deitalSinhVien(int index){
        return listSinhVien.get(index);
    }
    public  SinhVien updateSinhVien(int index ,SinhVien sv){
        return listSinhVien.set(index,sv);
    }


}
