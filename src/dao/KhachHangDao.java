/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.Dao.conn;
import entity.KhachHang;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author mac
 */
public class KhachHangDao implements Dao<KhachHang>{

    @Override
    public ArrayList<KhachHang> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KhachHang get(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    @Override
    public int save(KhachHang t) throws SQLException {
         if (t == null) {
            throw new SQLException("Hoá đơn rỗng");
        }
        String query = "INSERT INTO `KhachHang` (`tenKhachHang`, `soDienThoai`) VALUES (?, ?)";

        PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        stmt.setNString(1, t.getTenKhachHang());
        stmt.setNString(2, t.getSoDienThoai()); 
        stmt.executeUpdate();
        
        ResultSet rs = stmt.getGeneratedKeys();
        
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            throw new SQLException("Không thể  thêm khách hàng");
        }
        
    }

    @Override
    public void update(KhachHang t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(KhachHang t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
