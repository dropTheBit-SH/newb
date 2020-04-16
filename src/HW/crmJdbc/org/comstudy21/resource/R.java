package org.comstudy21.resource;

import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.comstudy21.controller.DeleteController;
import org.comstudy21.controller.InsertController;
import org.comstudy21.controller.ListController;
import org.comstudy21.controller.SearchController;
import org.comstudy21.model.Dao;

public interface R {
	DefaultTableModel dm = new DefaultTableModel(1, 4);
	Vector<String> columnIdentifiers = new Vector<>();
	
	JTextField nameFiled = new JTextField(12);
	JTextField emailFiled = new JTextField(12);
	JTextField phoneFiled = new JTextField(12);
	
	ListController listController = new ListController();
	InsertController insertController = new InsertController();
	SearchController searchController = new SearchController();
	DeleteController deleteController = new DeleteController();
	
	Dao dao = new Dao();
}
