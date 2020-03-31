package org.comstudy21.view;

import org.comstudy21.model.People;

public class Modify implements PhonebookView {

	@Override
	public void display() {
		System.out.println("::: 수정 기능 :::");
		System.out.print("수정 할 idx 입력: ");
		int idx = scan.nextInt();
		boolean flag = false;
		for(int i=0; i<data.pArr.length; i++) {
			if(idx == data.pArr[i].getIdx()) {
				flag = true;
				break;
			}
		}
		if(!flag) {
			System.out.println("수정 할 데이터를 찾을 수 없습니다!");
			display();
		} else {
			System.out.println("수정 할 데이터를 찾았습니다!");
			People newPeople = new People();
			newPeople.setIdx(idx);
			System.out.print("새 이름입력 : ");
			newPeople.setName(scan.next());
			System.out.print("새 전화번호 : ");
			newPeople.setPhone(scan.next());
			data.people = newPeople;
		}
		
		
	}

}
