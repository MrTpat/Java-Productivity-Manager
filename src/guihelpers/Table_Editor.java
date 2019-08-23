package guihelpers;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import nongui.Goal_List;

public class Table_Editor {

	private JTable table;
	private DefaultTableModel model;

	public Table_Editor(JTable j) {
		table = j;
		model = (DefaultTableModel) table.getModel();
		
	}

	public void fill() throws Exception {
		clear();
		Goal_List list = new Goal_List();
		for (int i = 0; i < list.getList().size(); i++) {
			String name = list.getList().get(i).getName();
			double hoursCompleted = list.getList().get(i).gethC();
			double hoursNeeded = list.getList().get(i).gethN();
			String comp = "",need = "";
			if(hoursCompleted-(int)hoursCompleted<.15){
				comp = (int)hoursCompleted + ":0" + (int)(60*(hoursCompleted-(int)hoursCompleted));
			}
			else{
				comp = (int)hoursCompleted + ":" + (int)(60*(hoursCompleted-(int)hoursCompleted));
			}
			if(hoursNeeded-(int)hoursNeeded<.15){
				need = (int)hoursNeeded + ":0" + (int)(60*(hoursNeeded-(int)hoursNeeded));
			}
			else{
				need = (int)hoursNeeded + ":" + (int)(60*(hoursNeeded-(int)hoursNeeded));
			}
			comp+=":00";
			need+=":00";
			Object[] data = { name, comp, need };
			if (hoursNeeded > hoursCompleted) {
				model.addRow(data);
			} else {
				list.get(i).notification();
				list.getList().remove(i);
				list.save();
			}

		}
	}

	public void clear() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
	}

	public int deleteRow() {
		if (table.getSelectedRow() != -1) {
			int x = table.getSelectedRow();
			model.removeRow(x);
			return x;
		} else {
			return -1;
		}
	}
}
