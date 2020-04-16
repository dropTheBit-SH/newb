package org.comstudy21.evt_handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.comstudy21.view.ButtonView;

import static org.comstudy21.resource.R.*;

public class ButtonEventHandler implements ActionListener {
	ButtonView target;
	
	public ButtonEventHandler(ButtonView buttonView) {
		this.target = buttonView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton btn = (JButton)e.getSource();
			
			if(btn == target.allBtn) {
				listController.service();
			}
			if(btn == target.insertBtn) {
				insertController.service();
				listController.service();
			}
			if(btn == target.searchBtn) {
				searchController.service();
			}
			if(btn == target.deleteBtn) {
				deleteController.service();
				listController.service();
			}
			if(btn == target.cancelBtn) {
			}
			
		}
	}

}
