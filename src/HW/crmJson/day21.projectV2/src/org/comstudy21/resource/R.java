package org.comstudy21.resource;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.comstudy21.controller.CancelController;
import org.comstudy21.controller.DeleteController;
import org.comstudy21.controller.InputController;
import org.comstudy21.controller.ListController;
import org.comstudy21.controller.SearchController;
import org.comstudy21.model.Dao;
import org.comstudy21.view.ListView;

public interface R {
	DefaultTableModel dm = new DefaultTableModel(10, 4);
	Object[] colNames = {"번호","이름","이메일","전화번호"};
	ListView listView = new ListView(dm, colNames);
	
	JTextField nameField = new JTextField(15);
	JTextField emailField = new JTextField(15);
	JTextField phoneField = new JTextField(15);
	
	ListController listController = new ListController();
	InputController inputController = new InputController();
	DeleteController deleteController = new DeleteController();
	SearchController searchController = new SearchController();
	CancelController cancelController = new CancelController();
	
	Dao dao = new Dao();
	
	
}
