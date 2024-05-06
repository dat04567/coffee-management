/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.employee;

import entity.ChiTietHoaDon;
import entity.ThucUong;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;
import utils.FormatVND;

/**
 *
 * @author mac
 */
public class OrderTableModel  extends AbstractTableModel{
     private ArrayList<ChiTietHoaDon> chiTietHoaDons = new ArrayList<>();
     String[] list = {"Mã nước",  "Tên nước", "Tiền nước", "Số lượng", "Ghi chú" };
     private int maHoaDon;


    public OrderTableModel(ArrayList<ChiTietHoaDon> chiTietHoaDons) {
        this.chiTietHoaDons = chiTietHoaDons;
    }

    public void setChiTietHoaDons(ArrayList<ChiTietHoaDon> chiTietHoaDons) {
        this.chiTietHoaDons = chiTietHoaDons;
    }

    public ArrayList<ChiTietHoaDon> getChiTietHoaDons() {
        return chiTietHoaDons;
    }

    
    
    
    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }
    

    @Override
    public int getRowCount() {
        return chiTietHoaDons.size();
    }

    @Override
    public int getColumnCount() {
        return list.length;
    }

    @Override
    public String getColumnName(int column) {
        return list[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

  
    
    

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass(); 
    }

     
     
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ChiTietHoaDon chiTietHoaDon = chiTietHoaDons.get(rowIndex);
        return switch(columnIndex) {
            case 0 -> chiTietHoaDon.getThucUong().getMaNuoc();
            case 1 -> chiTietHoaDon.getThucUong().getTenNuoc();
            case 2 -> FormatVND.getFormat(chiTietHoaDon.getGiaTien());
            case 3 -> chiTietHoaDon.getSoLuong();
            case 4 -> chiTietHoaDon.getGhiChu();
            default -> null;
          
        };
    }
    

    
}
