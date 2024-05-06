/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.employee;

import controllers.popup.OrderFoodPopupController;
import dao.BanDao;
import dao.ChiTietHoaDonDao;
import dao.HoaDonDao;
import dao.KhachHangDao;
import entity.Ban;
import entity.ChiTietHoaDon;
import entity.HinhThucThanhToan;
import entity.HoaDon;

import gui.employee.OrderDetailView;
import gui.employee.OrderManagerView;
import gui.employee.TableItem;
import gui.popup.OrderFoodPopupView;
import gui.popup.OrderFoodUpdateView;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import utils.FormatVND;
import utils.OrderStatus;
import java.sql.Timestamp;
import javax.swing.JOptionPane;
import utils.IconManager;
import utils.PrintOrder;
import utils.TableStatus;
/**
 *
 * @author mac
 */
public class OrderDetailController {

    OrderDetailView prevView = null;
    OrderFoodPopupController orderFoodPopupController = new OrderFoodPopupController();
    private HoaDonDao hoaDonDao = new HoaDonDao();
    private ChiTietHoaDonDao chiTietHoaDonDao = new ChiTietHoaDonDao();
    private KhachHangDao khachHangDao = new KhachHangDao();
    private BanDao banDao = new BanDao();
    private TableItem tableItem;
    private final double PRICE_MAX = 1000000000;
    private PrintOrder printOrder;
    IconManager icon = new IconManager();
    
    public OrderDetailController() {
         
    }

    interface OrderEvent {

        public abstract TableItem getTableItem();

    }
    
    
    public void addOrderDetail(OrderManagerView view,  HoaDon hoaDon, int i )
    {
         OrderDetailView viewDetail = new OrderDetailView();
         this.prevView = viewDetail;
         viewDetail.setHoaDon(hoaDon);
         
         view.getOrderDetailPanel().add(viewDetail, "B" + i);
    }
  

    public void addOrderEvent(OrderDetailView view, OrderEvent evnt)  {
        this.prevView = view;
        orderFoodPopupController.setOrderView(view);
        this.tableItem = evnt.getTableItem();
        
      
        orderFoodPopupController.setTableItem(tableItem);

        view.getBtnChoose().addActionListener(evt -> {
            OrderFoodPopupView orderFoodPopupView = new OrderFoodPopupView();
            orderFoodPopupController.add(orderFoodPopupView, this::updateData, view::showError);
            orderFoodPopupController.updateData(orderFoodPopupView);

        });
        JSpinner tienNhanCuaKhach = view.getTienNhanCuaKhach(); 
        tienNhanCuaKhach.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                try {
//                      tinh tien thừa 
                     double tongTien = chiTietHoaDonDao.getTongTienByMaHoaDon(view.getHoaDon().getMaHoaDon());
                     String price = FormatVND.getFormat( (double)tienNhanCuaKhach.getValue()  - tongTien   );
                     view.getTienThua().setText(price);
                } catch (Exception err){
                    view.showError(err);
                }
              
            }
        });
        
        
        view.getPay().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                payTheBill();

             
            }
        });
        
        view.getBtnEdit().addActionListener(evt -> {
            orderFoodPopupController.edit(new OrderFoodUpdateView());
        });

        view.getBtnRemove().addActionListener(evt -> {

        });

    }
    
    
    public void payTheBill()
    {
        String tenKH = prevView.getCustomerName().getText();
        if( tenKH.trim().equals(""))
        {
            prevView.showError("Tên khách hàng không được phép rỗng");
            return;
        }
        try {
            printOrder = new PrintOrder();
            HoaDon hoaDon = prevView.getHoaDon();
            Date date = prevView.getOnTheDay().getDate();
            JSpinner tienNhanCuaKhach = prevView.getTienNhanCuaKhach(); 
            Timestamp thoiGianVao =  new Timestamp(date.getTime()) ;
            String payment = prevView.getPayments().getSelectedItem().toString();
            
            hoaDon.setHinhThucThanhToan(HinhThucThanhToan.getByName(payment));
            hoaDon.getKhachHang().setTenKhachHang(tenKH);
            hoaDon.setOrderStatus(OrderStatus.PAID);
            hoaDon.setNgayVao(thoiGianVao);
            hoaDon.getBan().setStatus(TableStatus.FREE);
            hoaDon.setTienKhachHang((double)tienNhanCuaKhach.getValue());
            
            prevView.getCustomerName().setText("");
            

            
            prevView.showMessage("Đã thanh toán thành công");
            
            
            int result = JOptionPane.showConfirmDialog(prevView,
                        "Bạn có chắc muốn in hoá đơn không  ",
                        "Xác nhận",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
            
            if(result == JOptionPane.YES_OPTION)
            {
                double tongTien = chiTietHoaDonDao.getTongTienByMaHoaDon(prevView.getHoaDon().getMaHoaDon());
                printOrder.createPrintOrder(hoaDon,tongTien);
                printOrder.showPdf();
            } 
                
            
            
         
            hoaDonDao.update(hoaDon);
            khachHangDao.updateTenKhachHang(hoaDon.getKhachHang());
            banDao.updateStatus(hoaDon.getBan());
            tableItem.getBan().setStatus(TableStatus.FREE);
            
            
            hoaDon = new HoaDon();
            hoaDon.setBan(tableItem.getBan());
            prevView.setHoaDon(hoaDon);
            
            
            updateTable();
            
            
        } catch (Exception e) {
            prevView.showError(e);
        }
    }
    

    public  void updateTable()
    {
        try {
            ArrayList<ChiTietHoaDon> chiTietHoaDons  = chiTietHoaDonDao.getAllByMaHoaDon(prevView.getHoaDon().getMaHoaDon());
            prevView.setTableData(chiTietHoaDons);
            tableItem.getNumberTable().setIcon(icon.getIcon("unOrderTable.png"));
            tableItem.getNumberTable().setForeground(Color.BLACK);
            
            
            prevView.getTongTien().setText(FormatVND.getFormat(0));
            prevView.getTienThua().setText(FormatVND.getFormat(0));
            prevView.getTienNhanCuaKhach().setValue((double)0);
           
        } catch (Exception e) {
            prevView.showError(e);
        }
    }
    public void updateData(){
        try {
            ArrayList<ChiTietHoaDon> chiTietHoaDons  = chiTietHoaDonDao.getAllByMaHoaDon(prevView.getHoaDon().getMaHoaDon());
            prevView.setTableData(chiTietHoaDons);
  
           double tongTien = chiTietHoaDonDao.getTongTienByMaHoaDon(prevView.getHoaDon().getMaHoaDon());
           prevView.getTongTien().setText(FormatVND.getFormat(tongTien));
           
            JSpinner tienNhanCuaKhach = prevView.getTienNhanCuaKhach(); 
            SpinnerNumberModel model = new SpinnerNumberModel(tongTien , tongTien , PRICE_MAX, 10000); // value, min, max, step
            tienNhanCuaKhach.setModel(model);
            
            String price = FormatVND.getFormat( (double)tienNhanCuaKhach.getValue()  - tongTien   );
            prevView.getTienThua().setText(price);
            
        } catch (Exception e) {
            prevView.showError(e);
        }
    }

}
