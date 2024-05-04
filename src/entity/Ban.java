/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import utils.TableStatus;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author mac
 */
public class Ban {
    private  int maBan;
    private int soChoNgoi;
    private TableStatus status;

    public Ban() {
        soChoNgoi = 2;
        status = TableStatus.FREE;
    }    
    
    public Ban(int maBan, int soChoNgoi, TableStatus status) {
        this.maBan = maBan;
        this.soChoNgoi = soChoNgoi;
        this.status = status;
    }

    public int getMaBan() {
        return maBan;
    }

    public void setMaBan(int maBan) {
        this.maBan = maBan;
    }

    public int getSoChoNgoi() {
        return soChoNgoi;
    }

    public void setSoChoNgoi(int soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    public TableStatus getStatus() {
        return status;
    }

    public void setStatus(TableStatus status) {
        this.status = status;
    }
    
        
    public static Ban getFromResultSet(ResultSet rs) throws SQLException  {
        int maBan = rs.getInt("maBan");
        int soChoNgoi = rs.getInt("soChoNgoi");
        String trangThai = rs.getNString("trangThai");
        TableStatus status = TableStatus.getByName(trangThai);
        Ban ban = new Ban(maBan, soChoNgoi, status);
 
        return ban;
    }
    
    
    
    
}
