package controllers;

import gui.employee.MenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;

public class SideBarController {

    JPanel panelSideBar;
    private ArrayList<MenuItem> menuItems = new ArrayList<>();
    private MenuItem activeMenuItem = null; // item vừa chọn

    interface MenuBarEvent {

        public abstract void onSelectMenuItem(MenuItem item);
    }

    public SideBarController() {

    }

    public SideBarController(JPanel panelSideBar) {
        this.panelSideBar = panelSideBar;
    }

    public void setMenuItems(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public JPanel getPanelSideBar() {
        return panelSideBar;
    }

    public void setPanelSideBar(JPanel panelSideBar) {
        this.panelSideBar = panelSideBar;
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    // Thêm dropdown menu
    public void addMenu(MenuItem... menu) {
        for (int i = 0; i < menu.length; i++) {
            MenuItem item = menu[i];
            menuItems.add(item);
            item.setActive(false);
            panelSideBar.add(item);

        }
    }

    public void addMenuEvent(MenuBarEvent mbe) { // Thêm event mỗi khi click vào 1 item 
        for (MenuItem menuItem : menuItems) {
            menuItem.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {

                    if (!menuItem.equals(activeMenuItem)) { 
                       mbe.onSelectMenuItem(menuItem);
                        setMenu(menuItem);
                    } 
                }
            });
        }
    }

    private void closePreviosMenu(MenuItem previousItem) { //Đóng menu cũ
        previousItem.setActive(false);
    }

    public void setMenu(MenuItem item) {//Chọn menu
        boolean isActive = item.isActive();

        if (activeMenuItem != null) {
            closePreviosMenu(activeMenuItem);
        }
        activeMenuItem = item;
        item.setActive(!isActive);

    }

}
