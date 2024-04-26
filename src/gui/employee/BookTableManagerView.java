package gui.employee;

import entity.ThucUong;
import gui.ManagerPaneView;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.TableModel;
/**
 *
 * @author mac
 */
public class BookTableManagerView extends ManagerPaneView<ThucUong> {

    String[] list = {"Mã bàn", "Tên khách hàng", "Số điện thoại", "Thời gian đặt bàn", "Số lượng bàn",  "Hình thức thanh toán", "ghi chú"};

    public BookTableManagerView() {
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
