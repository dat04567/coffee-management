/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author mac
 */
public class KhachHang {
    private int maKhachHang;
    private String tenKhachHang;
    private String soDienThoai;

    public KhachHang() {
        
    }

    public KhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }
    
    

    public KhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public KhachHang(String tenKhachHang, String soDienThoai) {
        this.tenKhachHang = tenKhachHang;
        this.soDienThoai = soDienThoai;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    
    
    
       
    
    
    
}
