package org.comstudy21.view;

import org.comstudy21.model.People;

public class Input implements PhonebookView {

	@Override
	public void display() {
		People p = new People();
		System.out.println("::: �Է� ��� :::");
		System.out.print("���� �Է� : ");
		p.setName(scan.next());
		System.out.print("��ȭ ��ȣ : ");
		p.setPhone(scan.next());
		
		data.people = p;
		System.out.println("ģ�� ���� �Է� �Ϸ�");
	}

}
