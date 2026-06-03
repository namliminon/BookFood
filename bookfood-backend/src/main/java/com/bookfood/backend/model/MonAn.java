package com.bookfood.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name="mon_an")
public class MonAn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMon")
    private int idMon;

    @Column(name = "tenMon",nullable = false)
    private String tenMon;

    @Column(name = "giaTien")
    private double giaTien;

    @Column(name = "hinhAnh")
    private String hinhAnh;

    public MonAn(String tenMon, double giaTien, String hinhAnh) {
        this.tenMon = tenMon;
        this.giaTien = giaTien;
        this.hinhAnh = hinhAnh;
    }

    //Setter và getter
    public String getTenMon() {
        return tenMon;
    }
    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
            this.giaTien = giaTien;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }
    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
