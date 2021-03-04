package com.example.Assignment_ADNC.model;

import java.util.Date;

public class Khoahoc {
    public String maKhoahoc;
    public String tenKhoahoc;
    public String soBuoihoc;
    public String tenGiaovien;
    public Date ngayBatdau;
    public Date ngayKetthuc;
    public Date ngaythi;

    public Khoahoc(String tenKhoahoc, String soBuoihoc, String tenGiaovien, Date ngayBatdau, Date ngayKetthuc, Date ngaythi) {
        this.tenKhoahoc = tenKhoahoc;
        this.soBuoihoc = soBuoihoc;
        this.tenGiaovien = tenGiaovien;
        this.ngayBatdau = ngayBatdau;
        this.ngayKetthuc = ngayKetthuc;
        this.ngaythi = ngaythi;
    }

    public Khoahoc(String maKhoahoc,String tenKhoahoc, String tenGiaovien) {
        this.maKhoahoc = maKhoahoc;
        this.tenKhoahoc = tenKhoahoc;
        this.tenGiaovien = tenGiaovien;
    }

    public Khoahoc(String maKhoahoc, String tenKhoahoc, String soBuoihoc, String tenGiaovien, Date ngayBatdau, Date ngayKetthuc, Date ngaythi) {
        this.maKhoahoc = maKhoahoc;
        this.tenKhoahoc = tenKhoahoc;
        this.soBuoihoc = soBuoihoc;
        this.tenGiaovien = tenGiaovien;
        this.ngayBatdau = ngayBatdau;
        this.ngayKetthuc = ngayKetthuc;
        this.ngaythi = ngaythi;
    }

    public Khoahoc() {
    }
}
