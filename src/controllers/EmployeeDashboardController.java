/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import controllers.employee.FoodManagerController;
import controllers.employee.OrderManagerController;
import controllers.employee.TableController;
import controllers.employee.TableOrderManagerController;
import gui.AboutView;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//import utils.IconManager;
import gui.EmployeeDashboardView;
import gui.HomeView;
import gui.LoginView;
import gui.employee.FoodManagerView;
import gui.employee.MenuItem;
import gui.employee.OrderManagerView;
import gui.employee.BookTableManagerView;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import utils.IconManager;


/**
 *
 * @author Admin
 */
public class EmployeeDashboardController {

    private EmployeeDashboardView view;
    ManagerController foodManagerController = new FoodManagerController(),
                      tableOrderManagerController = new TableOrderManagerController();
    
    
    OrderManagerController orderManagerController;
  
    HomeView homeView = new HomeView();
    AboutView aboutView = new AboutView();
    FoodManagerView foodManagerView = new FoodManagerView();
    OrderManagerView orderManagerView = new OrderManagerView();
    BookTableManagerView orderTableManagerView  = new BookTableManagerView();

    SideBarController sideBarController;
    TableController tableController;
    
    JPanel[] cards = {homeView, aboutView, foodManagerView, orderManagerView, orderTableManagerView};

    public EmployeeDashboardController(EmployeeDashboardView view) {
        this.view = view;
        sideBarController = new SideBarController(view.getPanelSideBar());
        view.setVisible(true);
        initMenu();
        addEvent();
        orderManagerController = new OrderManagerController(orderManagerView);
        
//        tableController = new TableController(orderManagerView.getTableManPnl());
//        tableController.addTable(25);
        view.setCards(cards);
        view.setPanel(homeView);


       

    }
    
    
    

    public EmployeeDashboardView getView() {
        return view;
    }

    public void setView(EmployeeDashboardView view) {
        this.view = view;
        sideBarController.setPanelSideBar(view.getPanelSideBar());
    }

    private void initMenu() {
        IconManager im = new IconManager();
    
        MenuItem menuTU = new MenuItem("QLTU", im.getIcon("fast-food.png"), "Quản lý thức uống");
        MenuItem menuDB = new MenuItem("QLDB", im.getIcon("round-table.png"), "Quản lý đặt bàn");
        MenuItem menuBH = new MenuItem("BH", im.getIcon("selling.png"), "Bán hàng");
        MenuItem menuVCT = new MenuItem("VCT", im.getIcon("teamwork.png"), "Về Chúng Tôi");
         
        
        
        sideBarController.addMenu(menuTU, menuDB, menuBH, menuVCT);
        sideBarController.addMenuEvent(this::onMenuChange);
    }

    private void addEvent() {
        view.getBtnLogout().addActionListener(evt -> {
            int confirm = JOptionPane.showConfirmDialog(view, "Bạn thực sự muốn đăng xuất?");
            if (confirm != JOptionPane.YES_OPTION) {
                return;
            }
            
            
           
            view.dispose();
            new LoginController(new LoginView());
        });
    }

    public void onMenuChange(MenuItem item) {

        switch (item.getId()) {
            case "QLTU": // Quản lý thức uống
                  view.setPanel(foodManagerView);
                  foodManagerController.setView(foodManagerView);
                  foodManagerController.updateData();

                break;
            case "QLDB":// Quản lý đặt bàn
                view.setPanel(orderTableManagerView);
                tableOrderManagerController.setView(orderTableManagerView);
                tableOrderManagerController.updateData(); 
                break;
            case "BH"://Bán hàng
                view.setPanel(orderManagerView);
                
               
                break;
            case "VCT":
                view.setPanel(aboutView);
                break;
            default:
                view.setPanel(homeView);
        }
    }
}
