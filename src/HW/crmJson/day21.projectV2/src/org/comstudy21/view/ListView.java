package org.comstudy21.view;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListView extends View {
	// IoC 디자인 패턴(제어의 역전) - 사용 할 데이터를 외부에서 생성하고 객체로 입력한다.
	JTable table;
	DefaultTableModel model;

	public ListView(DefaultTableModel dm, Object[] colNames) {
		model = dm;
		model.setColumnIdentifiers(colNames);
		init();
	}

	@Override
	public void init() {
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}
	
	public int getRow(){
		int selectedRow = table.getSelectedRow();
		int selectedNo = (int) table.getValueAt(selectedRow, 0);
		return selectedNo;
	}

}
