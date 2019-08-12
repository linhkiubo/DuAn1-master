package com.example.qlks.model;

public class PhieuDangKi {
    String MaPDK;
    String MaKH;
    String MaNV;
    String NgayDen;
    String GioDen;
    String NgayDi;
    String GioDi;
    String NguoiLon;
    String TreEm;
    String SoPhong;
    String TraTruoc;

    public PhieuDangKi(String maPDK, String maKH, String maNV, String ngayDen, String gioDen, String ngayDi, String gioDi, String nguoiLon, String treEm, String soPhong, String traTruoc) {
        MaPDK = maPDK;
        MaKH = maKH;
        MaNV = maNV;
        NgayDen = ngayDen;
        GioDen = gioDen;
        NgayDi = ngayDi;
        GioDi = gioDi;
        NguoiLon = nguoiLon;
        TreEm = treEm;
        SoPhong = soPhong;
        TraTruoc = traTruoc;
    }

    public PhieuDangKi() {

    }

    public String getMaPDK() {
        return MaPDK;
    }

    public void setMaPDK(String maPDK) {
        MaPDK = maPDK;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String maKH) {
        MaKH = maKH;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String maNV) {
        MaNV = maNV;
    }

    public String getNgayDen() {
        return NgayDen;
    }

    public void setNgayDen(String ngayDen) {
        NgayDen = ngayDen;
    }

    public String getGioDen() {
        return GioDen;
    }

    public void setGioDen(String gioDen) {
        GioDen = gioDen;
    }

    public String getNgayDi() {
        return NgayDi;
    }

    public void setNgayDi(String ngayDi) {
        NgayDi = ngayDi;
    }

    public String getGioDi() {
        return GioDi;
    }

    public void setGioDi(String gioDi) {
        GioDi = gioDi;
    }

    public String getNguoiLon() {
        return NguoiLon;
    }

    public void setNguoiLon(String nguoiLon) {
        NguoiLon = nguoiLon;
    }

    public String getTreEm() {
        return TreEm;
    }

    public void setTreEm(String treEm) {
        TreEm = treEm;
    }

    public String getSoPhong() {
        return SoPhong;
    }

    public void setSoPhong(String soPhong) {
        SoPhong = soPhong;
    }

    public String getTraTruoc() {
        return TraTruoc;
    }

    public void setTraTruoc(String traTruoc) {
        TraTruoc = traTruoc;
    }
}
