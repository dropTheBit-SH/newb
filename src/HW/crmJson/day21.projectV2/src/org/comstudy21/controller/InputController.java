package org.comstudy21.controller;

import org.comstudy21.model.Member;

public class InputController implements Controller {

	public InputController() {
	}

	@Override
	public void service() {
		String name = nameField.getText();
		String email = emailField.getText();
		String phone = phoneField.getText();
		Member dto = new Member(0, name, email, phone);
		dao.insert(dto);
	}

}
