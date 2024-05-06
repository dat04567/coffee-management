package gui.employee;

import entity.ThucUong;
import gui.ManagerPaneView;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author mac
 */
public class BookTableManagerView extends ManagerPaneView<ThucUong> {

    String[] list = {"Mã bàn", "Tên khách hàng", "Số điện thoại", "Thời gian đặt bàn", "Số lượng bàn", "ghi chú"};

    public BookTableManagerView() {
        super();
        setTableModel();
        renderTable();
      

    }

    @Override
    public void setTableModel() {
          for (int i = 0 ; i < list.length;i++) {
              tableModel.addColumn(list[i]);

        }
         
        this.getCboSearch().setModel(new DefaultComboBoxModel(list));
    }
}
