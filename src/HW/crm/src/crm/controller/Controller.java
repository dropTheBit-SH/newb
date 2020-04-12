package crm.controller;

import javax.swing.JOptionPane;

import crm.model.DAO;
import crm.view.View;

public class Controller {
	public static void service(int menu) {
		
		DAO dao = DAO.getInstance();
		switch(menu) {
		case 0:
			new View();
		case 1:
			dao.total();
			break;
		case 2:
			dao.add(View.inputInfo());
			JOptionPane.showMessageDialog(null, "Success!");
			dao.cancel();
			break;
		case 3:
			dao.total();
			String del = JOptionPane.showInputDialog("Please enter a name to delete");
			dao.delete(del);
			JOptionPane.showMessageDialog(null, "Success!");
			dao.total();
			break;
		case 4:
			View.dtm.setRowCount(0);
			String srch = JOptionPane.showInputDialog("Please enter a name to search");
			dao.search(srch);
			break;
		case 5:
			dao.cancel();
			View.reset();
			break;
		}
	}
}
