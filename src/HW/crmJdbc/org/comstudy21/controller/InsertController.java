package org.comstudy21.controller;


import javax.naming.event.NamingExceptionEvent;

import org.comstudy21.model.Member;

public class InsertController implements Controller {

	@Override
	public void service() {
		String name = nameFiled.getText();
		String email = emailFiled.getText();
		String phone = phoneFiled.getText();
		
		Member dto = new Member(0, name, email, phone);
		
		dao.insert(dto);
	}

}
