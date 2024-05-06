/*

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.employee;

import dao.BanDao;
import dao.HoaDonDao;
import entity.Ban;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import gui.employee.OrderManagerView;
import gui.employee.BookTableManagerView;
import gui.employee.OrderDetailView;
import gui.employee.TableItem;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import utils.IconManager;
import utils.TableStatus;

/**
 *
 * @author mac
 */
public class TableController {
    OrderManagerView view;
    ArrayList<TableItem> tableItems;
    private TableItem activeMenuItem = null;
    ArrayList<OrderDetailView> orderDetailViews;
    OrderDetailController orderDetailController ;
    IconManager icon = new IconManager();
    private BanDao banDao = new BanDao();
    private ArrayList<Ban> bans;
    private HoaDonDao hoaDonDao = new HoaDonDao();
    

    interface TableEvent {

        public abstract void onSelectTableItem(TableItem table);
    }
    public TableController(OrderManagerView view) {
        this.view = view;
        try {
             bans = banDao.getAll();
        } catch (Exception e) {
            view.showError(e);
        }
       
        tableItems = new ArrayList<>();
        orderDetailViews = new ArrayList<OrderDetailView>();
        orderDetailController = new OrderDetailController();
    }
    
    
    
    public  void addTable()
    {
        int height = 0;

        for (int i = 1  ; i <= bans.size() ; i++)
        {
            TableItem item = new TableItem("Bàn " + i ); 
            Ban ban = bans.get(i - 1);
           
            height = item.getPreferredSize().height;
            item.setBan(ban);
            tableItems.add(item);
            
            try {
               
                HoaDon hoaDon =  hoaDonDao.getByMaBan(ban.getMaBan());
                orderDetailController.addOrderDetail(view, hoaDon, i);
                orderDetailController.updateData();
               
            } catch (Exception e) {
                view.showError(e);
            }          
            
            if(ban.getStatus() == TableStatus.SERVING)
            { 
                item.getNumberTable().setIcon(icon.getIcon("didOrder.png"));
                item.getNumberTable().setForeground(Color.BLUE);
            }

            view.getTableManPnl().add(item);
            
        }
        

        Dimension dim = view.getTableManPnl().getPreferredSize();

        view.getTableManPnl().setPreferredSize(new Dimension(dim.width , (height*bans.size())/3 ) );
   
 
    }
    
    public  void loadHoaDon(TableItem tableItem, OrderDetailView view )
    {
        try {
            Ban ban = tableItem.getBan();
//            HoaDon hoaDon =  hoaDonDao.getByMaBan(ban.getMaBan());
//            prevView.setHoaDon(hoaDon);
        } catch (Exception e) {
           
            view.showError(e);
        }
    }
    
    
    
    
   public  TableItem getTableItemActive()
   {
       return activeMenuItem;
   }
    
    
    public void addTableEvent(TableEvent ev){
        for (TableItem tableItem : tableItems) {
            tableItem.getNumberTable().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                       
                    if (!tableItem.equals(activeMenuItem)) { 
                       setTable(tableItem);
                       ev.onSelectTableItem(tableItem);
                    
                       
                      
                    } 
                    
                }
            });
            
        }
    }
    
 
    
    private void closePreviosMenu(TableItem previousItem) { //Đóng menu cũ
        previousItem.setActive(false);
//        view.s
        
    }

    public void setTable(TableItem item) { 
        boolean isActive = item.isActive();
        if (activeMenuItem != null) {
            closePreviosMenu(activeMenuItem);
        }
        activeMenuItem = item;
        item.setActive(!isActive);

    }
            
    
    
    
    
}
