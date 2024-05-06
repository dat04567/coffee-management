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
    private String maBan;
    private int soLuongBan;
    private  KhachHang khachHang;
    private String ghiChu;

    public DatBan(String maBan, int soLuongBan, KhachHang khachHang, String ghiChu) {
        this.maBan = maBan;
        this.soLuongBan = soLuongBan;
        this.khachHang = khachHang;
        this.ghiChu = ghiChu;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    

    public String getMaBan() {
        return maBan;
    }

    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    
    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

   

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    
    
    
}
