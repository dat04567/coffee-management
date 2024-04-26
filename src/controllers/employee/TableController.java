/*

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.employee;

import gui.employee.OrderManagerView;
import gui.employee.BookTableManagerView;
import gui.employee.TableItem;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author mac
 */
public class TableController {
    JPanel panelTablel;
    ArrayList<TableItem> tableItems;
    

     interface TableEvent {

        public abstract void onSelectTableItem(JButton btn);
    }
    public TableController(JPanel panelTable) {
        this.panelTablel = panelTable;
        tableItems = new ArrayList<>();
    }
    
    
    public  void addTable(int numberTabler)
    {
        int height = 0;
        
        for (int i = 1  ; i <= numberTabler ; i++)
        {
            TableItem item = new TableItem("Bàn " + i ); 
            height = item.getPreferredSize().height;
            tableItems.add(item);
            panelTablel.add(item);
        }
        Dimension dim = panelTablel.getPreferredSize();
        System.out.println(dim.height);
        panelTablel.setPreferredSize(new Dimension(dim.width , (height*numberTabler)/3 ) );
//        panelTablel.set
    }
    
    public void addTableEvent(TableEvent ev){
        for (TableItem tableItem : tableItems) {
            tableItem.getNumberTable().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ev.onSelectTableItem(tableItem.getNumberTable());
                    
                }
            });
            
        }
    }
            
    
    
    
}
