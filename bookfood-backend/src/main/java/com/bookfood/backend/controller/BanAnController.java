package com.bookfood.backend.controller;

import com.bookfood.backend.dto.DatBanResponse;
import com.bookfood.backend.model.BanAn;
import com.bookfood.backend.service.QuetDonHangService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @PostMapping("/chon-ban/{idBan}")
    public ResponseEntity<DatBanResponse> xuLyChonBan(@PathVariable int idBan, HttpSession session){
        Object userLoggedIn = session.getAttribute("currentUser");
        if (userLoggedIn == null){
            DatBanResponse response = new DatBanResponse(false,false, "Hãy đăng nhập để đặt bàn!",null);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        //Nếu đăng nhập thành công
        List<Object> danhSachMonAnGiaLap = new ArrayList<>();
        DatBanResponse response = new DatBanResponse(true, true,"Xin mời chọn món",danhSachMonAnGiaLap);
        return ResponseEntity.ok(response);
    }
}
