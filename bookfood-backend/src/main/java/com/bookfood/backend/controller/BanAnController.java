package com.bookfood.backend.controller;

import com.bookfood.backend.model.BanAn;
import com.bookfood.backend.service.QuetDonHangService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Cổng tiếp đón API RESTful
@RequestMapping("api/ban-an") // Định vị địa chỉ request cho API này
@CrossOrigin(origins = "*") // Cho phép tất cả fontend đều gọi được gọi API này

public class BanAnController {
    private final QuetDonHangService quetDonHangService; // Dùng để phối hợp làm việc

    public BanAnController(QuetDonHangService q){
        this.quetDonHangService = q;
    }

    @GetMapping // ĐÓn tiếp khi FONTEND truy cập ( tự chạy)
    public List<BanAn> layTatCaDanhSachBanAn(){
        return quetDonHangService.getDanhSachBanAn();
    }

}
