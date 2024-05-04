/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.employee;

import controllers.ManagerController;
import controllers.popup.TableOrderPopupController;
import entity.DatBan;
import gui.popup.TablePopupView;
import java.util.ArrayList;

/**
 *
 * @author mac
 */
public class TableOrderManagerController  extends ManagerController{
    TableOrderPopupController tableOrderPopupController = new TableOrderPopupController();
    

    @Override
    public void actionAdd() {
       tableOrderPopupController.add(new TablePopupView(), this::updateData, view::showError);
    }

    
      
    @Override
    public void updateData() {
        try {
//            ArrayList<DatBan> datBans = datBanDao.getAll();
//            view.setTableData(datBans);
        } catch (Exception e) {
            view.showError(e);
        }
    }
    @Override
    public void actionSearch() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionDelete() {
       
    }

    @Override
    public void actionEdit() {

         if (view.getLengthTableData() == 0) {
            view.showError("Không có bàn để sửa");
            return;
        }
        int selectedRow = view.getTblData().getSelectedRow();
        if (selectedRow == -1) {
            view.showError("Vui lòng chọn một để sửa");
            return;
        }
        DatBan datBan = (DatBan) view.getTableData().get(selectedRow);
        tableOrderPopupController.edit(new TablePopupView(), datBan, this::updateData, view::showError);
    }

   
    
}
