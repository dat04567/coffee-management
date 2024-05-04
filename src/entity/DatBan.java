/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author mac
 */
public class DatBan {
    private String maBan, soDienThoai;
    private int soLuongBan;
    private HinhThucThanhToan hinhThucThanhToan;
    private String ghiChu;

    public DatBan(String maBan, String soDienThoai, int soLuongBan, HinhThucThanhToan hinhThucThanhToan, String ghiChu) {
        this.maBan = maBan;
        this.soDienThoai = soDienThoai;
        this.soLuongBan = soLuongBan;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.ghiChu = ghiChu;
    }

    public String getMaBan() {
        return maBan;
    }

    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public HinhThucThanhToan getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(HinhThucThanhToan hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    
    
    
}
