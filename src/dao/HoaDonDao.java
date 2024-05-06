/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.Dao.conn;
import entity.Ban;
import entity.HinhThucThanhToan;
import entity.HoaDon;
import entity.KhachHang;
import entity.ThucUong;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author mac
 */
public class HoaDonDao implements Dao<HoaDon> {
    
    KhachHangDao khachHangDao  = new KhachHangDao();

    public HoaDonDao() {
        
    }

    @Override
    public ArrayList<HoaDon> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public HoaDon get(String id) throws SQLException {
        int maHoaDon = Integer.parseInt(id);
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `HoaDon` WHERE maHoaDon = " + id;
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
             HoaDon hoaDon = HoaDon.getFromResultSet(rs);
          
            return hoaDon;
        }
        return null;
       
    }
    
    
   
    
   
    public int save(HoaDon hoaDon) throws SQLException {
         if (hoaDon == null) {
            throw new SQLException("Hoá đơn rỗng");
        }
        String query = "INSERT INTO `HoaDon` (`maKhachHang`,  `ngayVao`, `trangThai`, `hinhThucThanhToan`, `tienKhachHang`, `maBan` ) VALUES (?, ?, ?, ?, ?, ?) ";
        PreparedStatement stmt = conn.prepareStatement(query,  Statement.RETURN_GENERATED_KEYS);
  
        stmt.setInt(1, hoaDon.getKhachHang().getMaKhachHang());
        stmt.setTimestamp(2, hoaDon.getNgayVao());
        stmt.setNString(3, hoaDon.getOrderStatus().getName());
        stmt.setNString(4, hoaDon.getHinhThucThanhToan().toString());
        stmt.setDouble(5, hoaDon.getTienKhachHang());

        stmt.setInt(6, hoaDon.getBan().getMaBan());

        int row = stmt.executeUpdate();
        
        ResultSet rs = stmt.getGeneratedKeys();

        if (rs.next()) {
            return rs.getInt(1);
        } else {
            throw new SQLException("Không thể  thêm hoá đơn");
        }
        
        
    }
    

    
    
    public HoaDon createNewHoaDon(Ban ban) throws SQLException
    {
    //                tạo hoá đơn
            KhachHang khachHang = new KhachHang();
            
            int maKhachHang = khachHangDao.save(khachHang);
            khachHang.setMaKhachHang(maKhachHang);

            HoaDon hoaDon = new HoaDon(khachHang, ban);
           
            
            int maHoaDon = save(hoaDon);
            hoaDon.setMaHoaDon(maHoaDon);
           
            return hoaDon;
    }
    
    public HoaDon getByMaBan(int maBan) throws SQLException
    {
       String query = "SELECT * FROM `HoaDon` WHERE maBan = ? AND trangThai = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, maBan);
        stmt.setString(2, "Chưa thanh toán");

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            HoaDon hoaDon = HoaDon.getFromResultSet(rs);
            hoaDon.setBan(new Ban(maBan));
            return hoaDon;
        }
        return new HoaDon();
    }
    
    
    
   
    
    @Override
    public void update(HoaDon t) throws SQLException {
        String sql = "UPDATE HoaDon  SET ngayVao = ?, trangThai = ?, hinhThucThanhToan = ? , tienKhachHang = ? WHERE maHoaDon = ? ";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setTimestamp(1, t.getNgayVao());
        stmt.setNString(2, t.getOrderStatus().getName());
        stmt.setNString(3, t.getHinhThucThanhToan().getLabel());
        stmt.setDouble(4, t.getTienKhachHang());
        stmt.setInt(5, t.getMaHoaDon());
         
        int row = stmt.executeUpdate();

    }
    
   

    @Override
    public void delete(HoaDon t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
