package org.comstudy21.controller;


public class CancelController implements Controller {

	public CancelController() {
	}

	@Override
	public void service() {
		nameField.setText(null);
		emailField.setText(null);
		phoneField.setText(null);
	}
}
