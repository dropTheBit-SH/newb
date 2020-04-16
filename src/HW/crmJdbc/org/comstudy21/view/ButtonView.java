package org.comstudy21.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.comstudy21.evt_handler.ButtonEventHandler;

public class ButtonView extends View {
	public JButton allBtn;
	public JButton insertBtn;
	public JButton searchBtn;
	public JButton deleteBtn;
	public JButton cancelBtn;
	@Override
	public void display() {
		JPanel pane = new JPanel();
		allBtn = new JButton("전체보기");
		insertBtn = new JButton("추가");
		searchBtn = new JButton("검색");
		deleteBtn = new JButton("삭제");
		cancelBtn = new JButton("취소");
		
		pane.add(allBtn);
		pane.add(insertBtn);
		pane.add(searchBtn);
		pane.add(deleteBtn);
		pane.add(cancelBtn);
		
		add(pane);
		
		ButtonEventHandler handler = new ButtonEventHandler(this);
		allBtn.addActionListener(handler);
		insertBtn.addActionListener(handler);
		searchBtn.addActionListener(handler);
		deleteBtn.addActionListener(handler);
		cancelBtn.addActionListener(handler);
	}
}
