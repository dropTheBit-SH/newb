package org.comstudy21.view;

import org.comstudy21.model.People;

public class Input implements PhonebookView {

	@Override
	public void display() {
		People p = new People();
		System.out.println("::: 입력 기능 :::");
		System.out.print("성명 입력 : ");
		p.setName(scan.next());
		System.out.print("전화 번호 : ");
		p.setPhone(scan.next());
		
		data.people = p;
		System.out.println("친구 정보 입력 완료");
	}

}
