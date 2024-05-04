/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author mac
 */
public class ThucUong extends Model{
    private String maNuoc, tenNuoc;
    private LoaiNuoc loaiNuoc;
    private DonViNuoc donViNuoc;
    private int soLuongNuoc;
    private double giaBan;
   

    public ThucUong(String maNuoc, String tenNuoc, LoaiNuoc loaiNuoc, DonViNuoc donViNuoc,  int soLuongNuoc, double giaBan) {
        this.maNuoc = maNuoc;
        this.tenNuoc = tenNuoc;
        this.loaiNuoc = loaiNuoc;
        this.donViNuoc = donViNuoc;
        this.soLuongNuoc = soLuongNuoc;
        this.giaBan = giaBan;

    }

    public ThucUong(String maNuoc, String tenNuoc) {
        this.maNuoc = maNuoc;
        this.tenNuoc = tenNuoc;
    }

    
    public ThucUong(String maNuoc) {
        this.maNuoc = maNuoc;
    }
    
    

    
   
    public String getMaNuoc() {
        return maNuoc;
    }

    public void setMaNuoc(String maNuoc) {
        this.maNuoc = maNuoc;
    }

    public String getTenNuoc() {
        return tenNuoc;
    }

    public void setTenNuoc(String tenNuoc) {
        this.tenNuoc = tenNuoc;
    }

    public LoaiNuoc getLoaiNuoc() {
        return loaiNuoc;
    }

    public void setLoaiNuoc(LoaiNuoc loaiNuoc) {
        this.loaiNuoc = loaiNuoc;
    }

    public DonViNuoc getDonViNuoc() {
        return donViNuoc;
    }

    public void setDonViNuoc(DonViNuoc donViNuoc) {
        this.donViNuoc = donViNuoc;
    }

    public int getSoLuongNuoc() {
        return soLuongNuoc;
    }

    public void setSoLuongNuoc(int soLuongNuoc) {
        this.soLuongNuoc = soLuongNuoc;
    }

    public double getGiaBan() {
        return giaBan;
    }

    @Override
    public boolean equals(Object obj) {
       if (obj == null) {
            return false;
        }
        if (obj instanceof ThucUong) {
            ThucUong other = (ThucUong) obj;
            return this.maNuoc.equals(other.maNuoc);
        }
        return false;
    }
    

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }
    
    public static ThucUong getFromResultSet(ResultSet rs) throws SQLException  {
        String maNuoc = rs.getNString("maThucUong");
        String loaiNuoc = rs.getNString("loaiNuoc");
        String tenNuoc = rs.getNString("tenNuoc");
        String donVi = rs.getNString("donVi");
        int soLuong = rs.getInt("soLuong");
        double giaBan = rs.getDouble("giaBan");
        DonViNuoc dv = donVi.equals("Chai") ? DonViNuoc.Chai : DonViNuoc.Ly;
        ThucUong thucUong = new ThucUong(maNuoc, tenNuoc, LoaiNuoc.getByName(loaiNuoc), dv, soLuong, giaBan);
 
        return thucUong;
    }
    

    
    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String formatVND()
    {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(localeVN);
        return currencyFormatter.format(this.giaBan);
    }
    @Override
    public Object[] toRowTable() {
    
          return new Object[]{
            this.maNuoc, this.loaiNuoc.getLabel(), this.tenNuoc, this.donViNuoc, this.soLuongNuoc,this.formatVND()
        };
    }
    
    public  Object[] toRowTableOrder(){
         return new Object[]{
            this.maNuoc, this.tenNuoc, this.formatVND() , this.soLuongNuoc,
        };
    }
    
    public  Object[] toRowTablePopUp()
    {
        return new Object[]{
            this.maNuoc, this.tenNuoc,this.formatVND() , this.soLuongNuoc,
        };
    }

   
    
}
