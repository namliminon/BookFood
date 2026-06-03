package com.bookfood.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Spring Boot tự động sinh chuỗi ngẫu nhiên duy nhất (UUID)
    @Column(name = "idKhachHang", length = 36)
    private String idUser;

    @Column(name = "ho")
    private String ho;

    @Column(name = "ten")
    private String ten;

    @Column(name = "soDienThoai", nullable = false, unique = true) // Bắt buộc nhập và không được trùng
    private String soDienThoai;

    @Column(name = "rank")
    private String rank;

    public User() {}

    public User(String ho, String ten, String soDienThoai) {
        this.ho = ho;
        this.ten = ten;
        this.soDienThoai = soDienThoai;
        this.rank = "Đồng"; // Mặc định đăng ký mới là hạng Đồng
    }

    public String getIdUser(){return idUser;}
    public String getTen(){return ten;}
    public String getHo(){return ho;}
    public String getSoDienThoai(){return soDienThoai;}
    public String getRank(){return rank;}

    public void setTen(String ten){this.ten = ten;}
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    public void setRank(String rank) {
        this.rank = rank;
    }
}
