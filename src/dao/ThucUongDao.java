/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.ThucUong;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author mac
 */
public class ThucUongDao implements Dao<ThucUong>{

    @Override
    public ArrayList<ThucUong> getAll() throws SQLException {
        ArrayList<ThucUong> thucUongs = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `ThucUong`";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            ThucUong thucUong = ThucUong.getFromResultSet(rs);
            thucUongs.add(thucUong);
        }
        return thucUongs;
    }

    @Override
    public ThucUong get(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void save(ThucUong t) throws SQLException {
        if (t == null) {
            throw new SQLException("Thức uống rỗng");
        }
        String query = "INSERT INTO `ThucUong` (`maThucUong`, `loaiNuoc`, `tenNuoc`, `donVi`, `soLuong`, `giaBan`) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setNString(1, t.getMaNuoc());
        stmt.setNString(2, t.getLoaiNuoc().getLabel());
        stmt.setNString(3, t.getTenNuoc());
        stmt.setNString(4, t.getDonViNuoc().toString());
        stmt.setInt(5, t.getSoLuongNuoc());
        stmt.setDouble(6, t.getGiaBan());
    
        int row = stmt.executeUpdate();
    }

    @Override
    public void update(ThucUong t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(ThucUong t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
