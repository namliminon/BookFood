package com.bookfood.backend.service;

import com.bookfood.backend.model.BanAn;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service // Đánh dấu tầng xử lí nghiệp vụ
public class QuetDonHangService {

    private final List<BanAn> danhSachBanAn = new ArrayList<>();

    public QuetDonHangService(){
        for(int i = 1; i <= 15; i ++){
            danhSachBanAn.add(new BanAn(i));

        }
        datBanThuNghiem(5, 850, 350000.0);
        datBanThuNghiem(3, 870, 120000.0);
    }

    private void datBanThuNghiem(int idBan, long soGiayTruoc, double tien){
        for (BanAn banAn: danhSachBanAn){
            if(banAn.getIdBan() == idBan){
                banAn.setOrdered(true);
                banAn.setThoiGianDatMon(LocalDateTime.now().minusSeconds(soGiayTruoc));
                banAn.setTongTienHienTai(tien);
                break;
            }
        }
    }


    @Scheduled(fixedRate = 1000)
    public void tuDongQuet() {
        System.out.println("\n=======================================================");
        System.out.println("[LUỒNG NGẦM] Đang tuần tra hệ thống 15 bàn ăn...");

        for (BanAn banAn : danhSachBanAn) {
            synchronized (banAn) {
                banAn.kiemtraDaHuy();

            }
        }
        inTrangThaiHeThong();
    }

    private void inTrangThaiHeThong() {
        System.out.println("--- BẢN ĐỒ TRẠNG THÁI 15 BÀN ĂN REAL-TIME ---");
        for (BanAn banAn : danhSachBanAn) {
            String trangThai = banAn.isOrdered() ? "ĐANG ĐỢI THANH TOÁN" : "TRỐNG";
            System.out.print("[" + banAn.getIdBan() + ": " + trangThai + "]   ");

            // Cứ in được 5 bàn thì xuống dòng cho đẹp mắt
            if (banAn.getIdBan() % 5 == 0) {
                System.out.println();
            }
        }
        System.out.println("=======================================================");
    }

    public List<BanAn> getDanhSachBanAn() {
        return danhSachBanAn;
    }
}
