package org.comstudy21.controller;

import java.util.Vector;

import javax.swing.JOptionPane;

public class SearchController implements Controller{

	public SearchController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void service() {
		String srchName = JOptionPane.showInputDialog("검색할 이름을 입력해주세요");
		Vector result = dao.search(srchName);
		if(result != null ){
			while(dm.getRowCount() > 0) {
				dm.removeRow(0);
			}
			dm.addRow(result);

		} else {
			System.out.println("출력 할 데이터가 없습니다!");
		}
	}

}
