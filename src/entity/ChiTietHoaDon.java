/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author mac
 */
public class ChiTietHoaDon {
    private HoaDon hoaDon;
    private ThucUong thucUong;
    private int soLuong;
    private String ghiChu;
    private double giaTien;

    public ChiTietHoaDon(HoaDon hoaDon, ThucUong thucUong, int soLuong, String ghiChu) {
        this.hoaDon = hoaDon;
        this.thucUong = thucUong;
        this.soLuong = soLuong;
        this.ghiChu = ghiChu;
    }

    public ChiTietHoaDon(HoaDon hoaDon, ThucUong thucUong) {
        this.hoaDon = hoaDon;
        this.thucUong = thucUong;
    }

    public ChiTietHoaDon(ThucUong thucUong,  String ghiChu, double giaTien, int soLuong) {
        this.thucUong = thucUong;
        this.ghiChu = ghiChu;
        this.giaTien = giaTien;
        this.soLuong = soLuong;
    }
    
    
    
    

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    public double getGiaTien()
    {
        return giaTien;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public ThucUong getThucUong() {
        return thucUong;
    }

    public void setThucUong(ThucUong thucUong) {
        this.thucUong = thucUong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    
    public static ChiTietHoaDon getFromResultSetByMaHoaDon(ResultSet rs)  throws  SQLException {
        String maNuoc = rs.getNString("maThucUong");
        String tenNuoc = rs.getNString("tenNuoc");
        double giaTien = rs.getDouble("giaTien");
        int soLuong = rs.getInt("soLuong");
        String ghiChu = rs.getNString("ghiChu");
        ThucUong thucUong = new ThucUong(maNuoc, tenNuoc);
        ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(thucUong, ghiChu, giaTien, soLuong);
   
        
        return chiTietHoaDon;
    }
    
    
    
  
    
    
}
