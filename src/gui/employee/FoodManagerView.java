package gui.employee;

import entity.ThucUong;
import gui.ManagerPaneView;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import utils.RightTable;

/**
 *
 * @author mac
 */
public class FoodManagerView extends ManagerPaneView<ThucUong> {

    String[] list = {"Mã thức uống", "Loại nước", "Tên nước","Đơn Vị", "Gam", "Giá Bán"};

    public FoodManagerView() {
        super();
        setTableModel();
        renderTable();
        RightTable.setRightTable(getTblData(), 4);
        RightTable.setRightTable(getTblData(), 5);
    }

    @Override
    public void setTableModel() {
          for (String string : list) {
              tableModel.addColumn(string);
        }
        this.getCboSearch().setModel(new DefaultComboBoxModel(list));
    }
}
