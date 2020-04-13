package org.comstudy21.evt_handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.comstudy21.resource.R;
import org.comstudy21.view.ButtonView;

public class BtnEvtHandler implements ActionListener, R {
	ButtonView target;

	public BtnEvtHandler(ButtonView target) {
		this.target = target;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() instanceof JButton) {
			JButton btn = (JButton) e.getSource();
			if (btn == target.allBtn) {
				listController.service();
			}
			if (btn == target.inputBtn) {
				inputController.service();
				listController.service();
			}
			if (btn == target.deleteBtn) {
				deleteController.service();
				listController.service();
			}
			if (btn == target.searchBtn) {
				searchController.service();
			}
			if (btn == target.cancelBtn) {
				cancelController.service();
			}
		}
	}
}
