package com.example.demo8.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder // taoj ctr tuy y

public class SinhVien {
    private String maSV;
    private String ten;
    private String diaChi;
    private int tuoi;
    private boolean gioiTinh;

}
