package org.comstudy21.view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListView extends View {

	@Override
	public void display() {
		columnIdentifiers.add("번호");
		columnIdentifiers.add("이름");
		columnIdentifiers.add("이메일");
		columnIdentifiers.add("전화번호");
		
		dm.setColumnIdentifiers(columnIdentifiers);
		JTable table = new JTable(dm);
		JScrollPane scrollPane = new JScrollPane(table);
		
		add(scrollPane);
	}

}
