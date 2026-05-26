package com.bookfood.backend.model;

public class MonAn {
    private String tenMon;
    private double giaTien;
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
