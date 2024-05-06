/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.Dao.conn;
import entity.DatBan;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mac
 */
public class DatBanDao implements Dao<DatBan> {

    @Override
    public ArrayList<DatBan> getAll() throws SQLException {
        return null;
    }


    @Override
    public DatBan get(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int save(DatBan t) throws SQLException {
         if (t == null) {
            throw new SQLException("Đặt bàn rỗng");
        }
        String query = "INSERT INTO `DatBan` (`maDatBan`, `maKhachHang`,  `soLuongBan`, `ghiChu`) VALUES (?, ?, ?, ? )";

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setNString(1, t.getMaBan());
        stmt.setInt(2, t.getKhachHang().getMaKhachHang());
        stmt.setInt(3, t.getSoLuongBan());
        stmt.setNString(4, t.getGhiChu());

    
        int row = stmt.executeUpdate();
        
        return row;
    }

    @Override
    public void update(DatBan t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(DatBan t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
