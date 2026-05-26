package com.bookfood.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Duration;
import java.time.LocalDateTime;

public class BanAn {

    private int idBan;
    private boolean ordered;
    private LocalDateTime thoiGianDatMon;
    private double tongTien;
    private boolean paid;

    public BanAn(int idBan){
        this.idBan = idBan;
        this.ordered = false;
        this.thoiGianDatMon = null;
        this.tongTien = 0;
        this.paid = false;

    }

    public boolean kiemtraDaHuy(){
        if(ordered == false || thoiGianDatMon == null){ return  false;}

        LocalDateTime now = LocalDateTime.now();
        long khoangTg = Duration.between(thoiGianDatMon,now).toSeconds();
        if (khoangTg >= 900){
            this.ordered = false;
            this.tongTien = 0;
            return true;
        }
        return false;

    }
    @JsonProperty
    public String getThoiGianDemNguoc(){
        if(ordered == false || thoiGianDatMon == null){return "00:00";}
        LocalDateTime now = LocalDateTime.now();
        long khoangTg = Duration.between(thoiGianDatMon, now).toSeconds();
        long soGiayconLai = 900 - khoangTg;
        if (soGiayconLai <= 0) {
            return "00:00";
        }
        long SoPhut = soGiayconLai / 60;
        long SoGiay = soGiayconLai % 60;

        return String.format("%02d:%02d",SoPhut, SoGiay);
    }

    public int getIdBan() { return idBan; }
    public void setIdBan(int idBan) { this.idBan = idBan; }

    public boolean isOrdered() { return ordered; }
    public void setOrdered(boolean ordered) { this.ordered = ordered; }

    public LocalDateTime getThoiGianDatMon() { return thoiGianDatMon; }
    public void setThoiGianDatMon(LocalDateTime thoiGianDatMon) { this.thoiGianDatMon = thoiGianDatMon; }

    public double getTongTienHienTai() { return tongTien; }
    public void setTongTienHienTai(double tongTien) { this.tongTien = tongTien; }
}
