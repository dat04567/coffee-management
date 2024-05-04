/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.Dao.conn;
import entity.ChiTietHoaDon;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mac
 */
public class ChiTietHoaDonDao implements Dao<ChiTietHoaDon> {

    @Override
    public ArrayList<ChiTietHoaDon> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ChiTietHoaDon get(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int save(ChiTietHoaDon t) throws SQLException {
        if (t == null) {
            throw new SQLException("Chi tiết hoá đơn rỗng");
        }
        String query = "SELECT * FROM ChiTietHoaDon WHERE maHoaDon = ? AND maThucUong = ?";
        PreparedStatement checkStmt = conn.prepareStatement(query);
        checkStmt.setInt(1, t.getHoaDon().getMaHoaDon());
        checkStmt.setString(2, t.getThucUong().getMaNuoc());
         
         ResultSet rs = checkStmt.executeQuery();

         if(rs.next())
         {
             String queryUpdateCount = "UPDATE ChiTietHoaDon SET soLuong = soLuong + ? WHERE maHoaDon = ? AND maThucUong = ?";
             PreparedStatement updateStmt = conn.prepareStatement(queryUpdateCount);
             updateStmt.setInt(1, 1);
             updateStmt.setInt(2, t.getHoaDon().getMaHoaDon());
             updateStmt.setNString(3, t.getThucUong().getMaNuoc());
             updateStmt.executeUpdate();
             return 1;
         } else 
         {
            String queryInsert = "INSERT INTO ChiTietHoaDon (maHoaDon, maThucUong, soLuong, ghiChu ) VALUES (?, ?, ?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(queryInsert);
            insertStmt.setInt(1, t.getHoaDon().getMaHoaDon());
            insertStmt.setString(2, t.getThucUong().getMaNuoc());
            insertStmt.setInt(3, t.getSoLuong());
            insertStmt.setNString(4, t.getGhiChu());
            insertStmt.executeUpdate();
            return 1;
         }
    }
    
    public  ArrayList<ChiTietHoaDon> getAllByMaHoaDon(int maHoaDon) throws SQLException
    {
        ArrayList<ChiTietHoaDon> chiTietHoaDons = new ArrayList<>();
        String query = "SELECT ThucUong.maThucUong, ThucUong.tenNuoc, ChiTietHoaDon.soLuong, ChiTietHoaDon.soLuong * ThucUong.giaBan AS giaTien, ChiTietHoaDon.ghiChu " + 
                       "FROM ChiTietHoaDon JOIN  ThucUong ON ChiTietHoaDon.maThucUong = ThucUong.maThucUong " +
                        "WHERE ChiTietHoaDon.maHoaDon = ? ";  
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, maHoaDon);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
              ChiTietHoaDon chiTietHoaDon = ChiTietHoaDon.getFromResultSetByMaHoaDon(rs);
            
              chiTietHoaDons.add(chiTietHoaDon);
        }

      
        return chiTietHoaDons;
    }
 
   

    @Override
    public void update(ChiTietHoaDon t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(ChiTietHoaDon t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
