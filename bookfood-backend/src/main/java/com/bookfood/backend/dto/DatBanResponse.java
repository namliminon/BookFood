package com.bookfood.backend.dto;

import java.util.List;

public class DatBanResponse {
    private boolean loggedIn;
    private boolean success;
    private String message;
    private List<Object> danhSachMonAn;

    public DatBanResponse(boolean loggedIn, boolean success, String message,List<Object> danhSachMonAn){
        this.loggedIn = loggedIn;
        this.success = success;
        this.message = message;
        this.danhSachMonAn = danhSachMonAn;
    }

    public boolean isLoggedIn() { return loggedIn; }
    public void setLoggedIn(boolean loggedIn) { this.loggedIn = loggedIn; }

    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public List<Object> getDanhSachMonAn() { return danhSachMonAn; }
    public void setDanhSachMonAn(List<Object> danhSachMonAn) { this.danhSachMonAn = danhSachMonAn; }
}

