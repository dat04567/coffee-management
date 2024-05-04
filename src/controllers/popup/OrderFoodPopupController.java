/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.popup;

import dao.BanDao;
import dao.ChiTietHoaDonDao;
import dao.HoaDonDao;
import dao.ThucUongDao;
import entity.Ban;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.ThucUong;
import gui.employee.OrderDetailView;
import gui.employee.OrderTableModel;
import gui.employee.TableItem;
import gui.popup.OrderFoodPopupView;
import gui.popup.OrderFoodUpdateView;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import utils.IconManager;
import utils.TableStatus;

/**
 *
 * @author mac
 */
public class OrderFoodPopupController {

    JFrame previousView;
    OrderFoodPopupView view;
    ThucUongDao thucUongDao = new ThucUongDao();
    HoaDonDao hoaDonDao = new HoaDonDao();
    OrderDetailView orderView;
    private ChiTietHoaDonDao chiTietHoaDonDao = new ChiTietHoaDonDao();
    private TableItem tableItem;
    private BanDao banDao = new BanDao();
    IconManager icon = new IconManager();
    
    


    public void add(OrderFoodPopupView view, SuccessCallback sc, ErrorCallback ec) {
        if (previousView != null && previousView.isDisplayable()) {
            previousView.requestFocus();
            return;
        }
        previousView = view;
        view.setVisible(true);
           
        view.getBtnCancel().addActionListener(evt -> view.dispose());

        view.getBtnAdd().addActionListener(evt -> {
            try {
                tableItem.getBan().setStatus(TableStatus.SERVING);
                tableItem.getNumberTable().setIcon(icon.getIcon("didOrder.png"));
                tableItem.getNumberTable().setForeground(Color.BLUE);

                addDsChiTietHoaDon(view);
                sc.onSuccess();
              
                
                view.dispose();


            } catch (Exception ex) {
                ec.onError(ex);
            }
        });
    }
        
     public void setOrderView(OrderDetailView view)
     {
         this.orderView = view;
     }
     
     public  void setTableItem(TableItem item)
     {
         this.tableItem = item;
     }
     
     

    public void addDsChiTietHoaDon(OrderFoodPopupView view) throws Exception {
        String[] dsMaThucUongs = view.getSelectedIds();

        if (dsMaThucUongs.length == 0) {
            throw new Exception("Vui lòng chọn thức uống");
        }
       
        for (int i = 0; i < dsMaThucUongs.length; i++) {
               addChiTietHoaDon(view, dsMaThucUongs[i]);
        }
        
    }
    
    
   
    

    public void addChiTietHoaDon(OrderFoodPopupView view, String maThucUong) throws Exception {
            HoaDon hoaDon = orderView.getHoaDon();
            HoaDon existingHoaDon = hoaDonDao.get(String.valueOf(hoaDon.getMaHoaDon()));
            ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(hoaDon, new ThucUong(maThucUong), 1, "");
            Ban ban = tableItem.getBan();
            if (existingHoaDon == null) {
                HoaDon newHoaDon = hoaDonDao.createNewHoaDon(ban);
                hoaDon.setMaHoaDon(newHoaDon.getMaHoaDon());
                hoaDon.setKhachHang(newHoaDon.getKhachHang()); 
                banDao.updateStatus(ban);
                chiTietHoaDonDao.save(chiTietHoaDon);
                
            } else {
                chiTietHoaDonDao.save(chiTietHoaDon);
            }
      

    }

    public void edit(OrderFoodUpdateView view) {
        if (previousView != null && previousView.isDisplayable()) {
            previousView.requestFocus();
            return;
        }
        previousView = view;
        view.setVisible(true);
        view.getBtnCancel().addActionListener(evt -> view.dispose());
        
        

    }

    public void updateData(OrderFoodPopupView view) {
        try {
            ArrayList<ThucUong> thucUongs = thucUongDao.getAll();
            view.setTableData(thucUongs);
        } catch (Exception e) {
            view.showError(e);
        }
    }

//    public ArrayList<ThucUong> getAllPopupSelect() {
//        ArrayList<ThucUong> thucUongs = new ArrayList<ThucUong>();
//        OrderFoodPopupView view = (OrderFoodPopupView) previousView;
//        String[] selectIds = view.getSelectedIds();
//
//        for (int i = 0; i < selectIds.length; i++) {
//
//            try {
//                ThucUong thucUong = thucUongDao.get(selectIds[i]);
//                thucUongs.add(thucUong);
//            } catch (Exception e) {
//                view.showError(e);
//            }
//
//        }
//        return thucUongs;
//    }

}
