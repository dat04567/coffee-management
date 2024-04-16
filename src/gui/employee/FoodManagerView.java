package gui.employee;

import entity.ThucUong;
import gui.ManagerPaneView;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.TableModel;
/**
 *
 * @author mac
 */
public class FoodManagerView extends ManagerPaneView<ThucUong> {

    String[] list = {"Mã thức uống", "Loại nước", "Tên nước","Đơn Vị", "Số lượng", "Giá Bán"};

    public FoodManagerView() {
        super();
        setTableModel();
        renderTable();
    }

    @Override
    public void setTableModel() {
          for (String string : list) {
              tableModel.addColumn(string);
        }
        this.getCboSearch().setModel(new DefaultComboBoxModel(list));
    }
}
