package controllers.employee;


import controllers.ManagerController;
import controllers.popup.FoodPopupController;
import dao.ThucUongDao;
import entity.ThucUong;

import gui.popup.FoodPopupView;
import java.util.ArrayList;




public class FoodManagerController extends ManagerController {
    FoodPopupController foodPopupController = new FoodPopupController();
    ThucUongDao thucUongDao = new ThucUongDao();
   
    
    @Override
    public void actionAdd() {
 
        foodPopupController.add(new FoodPopupView(), this::updateData, view::showError);
    }
    
    @Override
    public void actionEdit() {
        if (view.getTblData() == null) {
            view.showError("Không có thức uống");
            return;
        }
        int selectedRow = view.getTblData().getSelectedRow();
        if (selectedRow == -1) {
            view.showError("Vui lòng chọn một thức uống để sửa");
            return;
        }
        ThucUong thucUong = (ThucUong) view.getTableData().get(selectedRow);
        foodPopupController.edit(new FoodPopupView(), thucUong, this::updateData, view::showError);
    }
    
    
   @Override
    public void actionDelete() {
        if (view.getTblData() == null) {
            view.showError("Không có thức uống");
            return;
        }
        int selectedRow = view.getTblData().getSelectedRow();
        if (selectedRow == -1) {
            view.showError("Vui lòng chọn một thức uống để xóa");
            return;
        }
        ThucUong thucUong = (ThucUong) view.getTableData().get(selectedRow);
        try {
            ThucUong selectedThucUong = thucUongDao.getByMaNuoc(thucUong.getMaNuoc());
            if (selectedThucUong != null) {
                thucUongDao.delete(selectedThucUong);
                updateData();
                view.showMessage("Xóa thức uống thành công!");
            } else {
                view.showError("Thức uống không tồn tại");
            }
        } catch (Exception e) {
            view.showError(e);
        }
    }


    
    @Override
    public void updateData() {
        try {
            ArrayList<ThucUong> thucUongs = thucUongDao.getAll();
            view.setTableData(thucUongs);
        } catch (Exception e) {
            view.showError(e);
        }
    }

    @Override
    public void actionSearch() {
        try {
//            ArrayList<Employee> employees = employeeDao.searchByKey(view.getCboSearchField().getSelectedItem().toString(), String.valueOf(view.getTxtSearch().getText()));
//            view.setTableData(employees);
        } catch (Exception e) {
            view.showError(e);
        }
    }

    

    
}
