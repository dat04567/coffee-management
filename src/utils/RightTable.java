/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author mac
 */
public class RightTable {
    
    static DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
    
    public static void setRightTable(JTable table, int column)
    {
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        table.getColumnModel().getColumn(column).setCellRenderer(rightRenderer);

    }
    
}
