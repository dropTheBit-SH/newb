package org.comstudy21.view;

import org.comstudy21.model.People;

public class Search implements PhonebookView {

	@Override
	public void display() {
		System.out.println("::: 검색 기능 :::");
		data.people = new People();
		System.out.print("검색 할 이름 : ");
		data.people.setName(scan.next());
	}
	
	public void display(People[] pArr) {
		System.out.println("::: 검색 결과 :::");
		if(pArr.length == 0) {
			System.out.println("------ 검색 결과가 없습니다 ------");
			return;
		}
		for(People p : pArr) {
			System.out.println(p);
		}
	}

}
