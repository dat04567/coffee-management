/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Ban;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author mac
 */
public class BanDao implements Dao<Ban>{

    @Override
    public ArrayList<Ban> getAll() throws SQLException {
        ArrayList<Ban> bans = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `Ban`";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Ban ban = Ban.getFromResultSet(rs);
            bans.add(ban);
        }
        return bans;
    }

    @Override
    public Ban get(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int save(Ban t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void update(Ban t) throws SQLException {
         throw new UnsupportedOperationException("Not supported yet."); 
    }
     public void updateStatus(Ban ban) throws SQLException
     {
        String query = "UPDATE `Ban` SET `trangThai` = ? WHERE `maBan` = ?";

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setNString(1, ban.getStatus().getName());
        stmt.setInt(2, ban.getMaBan());
      
        int row = stmt.executeUpdate();
     }

    @Override
    public void delete(Ban t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
