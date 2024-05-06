/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.Dao.conn;
import entity.ChiTietDatBan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author mac
 */
public class ChiTietDatBanDao implements Dao<ChiTietDatBan> {

    @Override
    public ArrayList<ChiTietDatBan> getAll() throws SQLException {
        ArrayList<ChiTietDatBan> chiTietDatBans = new ArrayList<ChiTietDatBan>();
        Statement statement = conn.createStatement();
        String query = "SELECT ctdb.thoiGianDatBan, ctdb.maDatBan, db.soLuongBan, db.ghiChu, kh.tenKhachHang, kh.soDienThoai "
                + "FROM ChiTietDatBan ctdb JOIN  DatBan db ON ctdb.maDatBan = db.maDatBan "
                + "JOIN KhachHang kh ON db.maKhachHang = kh.maKhachHang ";

        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            ChiTietDatBan chiTietDatBan = ChiTietDatBan.getFromResultSet(rs);
            chiTietDatBans.add(chiTietDatBan);

        }

        return chiTietDatBans;
    }

    @Override
    public ChiTietDatBan get(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int save(ChiTietDatBan t) throws SQLException {
        if (t == null) {
            throw new SQLException("Thức uống rỗng");
        }
        String query = "INSERT INTO `ChiTietDatBan` (`maDatBan`, `thoiGianDatBan`) VALUES (?, ?)";

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setNString(1, t.getDatBan().getMaBan());
        stmt.setTimestamp(2, t.getThoiGianDatBan());
        int row = stmt.executeUpdate();
        return 1;
    }

    @Override
    public void update(ChiTietDatBan t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(ChiTietDatBan t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
