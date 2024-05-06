/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import utils.OrderStatus;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mac
 */
public class HoaDon {
    private int maHoaDon;
    private KhachHang khachHang;
    private Timestamp ngayVao;
    private OrderStatus orderStatus;
    private HinhThucThanhToan hinhThucThanhToan;
    private double tienKhachHang;
    private ArrayList<ChiTietHoaDon> chiTietHoaDons;
    private ArrayList<ChiTietDatBan> chiTietDatBans;
    private Ban ban;




    public HoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }
    
    public HoaDon(KhachHang khachHang, Ban ban) {
        this.khachHang = khachHang;
        this.ban = ban;
        orderStatus = OrderStatus.UNPAID;
        hinhThucThanhToan = hinhThucThanhToan.PAYMENT;
        tienKhachHang = 0;
        chiTietHoaDons = new ArrayList<ChiTietHoaDon>();
        chiTietDatBans = new ArrayList<ChiTietDatBan>();
    }
    
    
    public HoaDon() {
        khachHang = new KhachHang();
        orderStatus = OrderStatus.UNPAID;
        hinhThucThanhToan = hinhThucThanhToan.PAYMENT;
        tienKhachHang = 0;
        chiTietHoaDons = new ArrayList<ChiTietHoaDon>();
        chiTietDatBans = new ArrayList<ChiTietDatBan>();
    }

    public HoaDon(int maHoaDon, KhachHang khachHang, Timestamp ngayVao, OrderStatus orderStatus, HinhThucThanhToan hinhThucThanhToan, double tienKhachHang, Ban ban) {
        this.maHoaDon = maHoaDon;
        this.khachHang = khachHang;
        this.ngayVao = ngayVao;
        this.orderStatus = orderStatus;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.tienKhachHang = tienKhachHang;
        this.ban = ban;
    }
    
    
    
    
    
    public void addChiTietHoaDon(ChiTietHoaDon chiTietHoaDon)
    {
        chiTietHoaDons.add(chiTietHoaDon);
    }

    public Ban getBan() {
        return ban;
    }

    public void setBan(Ban ban) {
        this.ban = ban;
    }

    
    
    
   
    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public Timestamp getNgayVao() {
        return ngayVao;
    }

    public void setNgayVao(Timestamp ngayVao) {
        this.ngayVao = ngayVao;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public HinhThucThanhToan getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(HinhThucThanhToan hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public double getTienKhachHang() {
        return tienKhachHang;
    }

    public void setTienKhachHang(double tienKhachHang) {
        this.tienKhachHang = tienKhachHang;
    }

    public ArrayList<ChiTietHoaDon> getChiTietHoaDons() {
        return chiTietHoaDons;
    }

    public void setChiTietHoaDons(ArrayList<ChiTietHoaDon> chiTietHoaDons) {
        this.chiTietHoaDons = chiTietHoaDons;
    }

    public ArrayList<ChiTietDatBan> getChiTietDatBans() {
        return chiTietDatBans;
    }

    public void setChiTietDatBans(ArrayList<ChiTietDatBan> chiTietDatBans) {
        this.chiTietDatBans = chiTietDatBans;
    }
    

    
    
    
    
    
    public static HoaDon getFromResultSet(ResultSet rs) throws SQLException  {
        int maHoaDon = rs.getInt("maHoaDon");
        int maKhachHang = rs.getInt("maKhachHang");
        Timestamp thoiGianVao = rs.getTimestamp("ngayVao");
        OrderStatus status = OrderStatus.getByName(rs.getNString("trangThai"));
        HinhThucThanhToan hinhThucThanhToan = HinhThucThanhToan.getByName(rs.getNString("hinhThucThanhToan"));
        double tienKhachHang = rs.getDouble("tienKhachHang");
        
        Ban ban = new Ban();
        HoaDon hoaDon = new HoaDon(maHoaDon, new KhachHang(maKhachHang), thoiGianVao, status, hinhThucThanhToan, tienKhachHang, ban);
        hoaDon.setChiTietHoaDons(new ArrayList<ChiTietHoaDon>());
 
        return hoaDon;
    }
    
    
    
    
     
    
    
    
    
    
    
    
}
