package com.example.demo4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "san_pham")
@Entity
public class SanPham {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ma-san-pham")
    private int maSanPham;
    @Column(name = "ten_san_pham")

    private int tenSanPham;
    @Column(name = "trang_thai")
    private int trangThai;
    @Column(name = "ngay_tao")
    private int ngayTao;
    @Column(name = "ngay_sua")
    private int ngaySua;
    @ManyToOne
    @JoinColumn(name = "id_danh_muc")
    private DanhMuc danhMuc;
}
