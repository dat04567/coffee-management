/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author mac
 */
public class ThucUong extends Model{
    private String maNuoc, tenNuoc;
    private int soLuongNuoc;
    private double giaBan;

    public ThucUong(String maNuoc, String tenNuoc, int soLuongNuoc, double giaBan) {
        this.maNuoc = maNuoc;
        this.tenNuoc = tenNuoc;
        this.soLuongNuoc = soLuongNuoc;
        this.giaBan = giaBan;
    }

    public ThucUong() {
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

    public int getSoLuongNuoc() {
        return soLuongNuoc;
    }

    public void setSoLuongNuoc(int soLuongNuoc) {
        this.soLuongNuoc = soLuongNuoc;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object[] toRowTable() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
