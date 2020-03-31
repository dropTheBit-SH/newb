package org.comstudy21.model;

import static org.comstudy21.resource.R.*;

public class Dao {
	// DB나 파일에 데이터를 저장하는 역할
	private static int sequence = 1;
	private People[] pArr = new People[MAX];
	private int top = 0;
	
	{
		pArr[top++] = new People(sequence++, "KIM", "1111-1111");
		pArr[top++] = new People(sequence++, "LEE", "2222-2222");
		pArr[top++] = new People(sequence++, "PARK", "3333-3333");
		pArr[top++] = new People(sequence++, "LEE", "4444-4444");
		pArr[top++] = new People(sequence++, "KANG", "5555-5555");
	}
	
	// 싱글톤 패턴
	private Dao() {
		// TODO Auto-generated constructor stub
	}
	
	private static Dao instance;
	
	public static Dao getInstance() {
		if(instance == null) {
			instance = new Dao();
		}
		return instance;
	}
	
	public void insert(People dto) {
		if(top >= MAX) {
			System.out.println("더이상 입력 불가입니다.");
			return;
		}
		dto.setIdx(sequence++);
		pArr[top++] = dto;
	}
	public People[] select() {
		People[] arr = new People[top];
		for(int i=0; i<arr.length; i++) {
			People dto = new People();
			dto.setIdx(pArr[i].getIdx());
			dto.setName(pArr[i].getName());
			dto.setPhone(pArr[i].getPhone());
			arr[i] = dto;
		}
		return arr;
	}

	public People[] select(People dto) {
		People[] tmp = new People[top];
		int cnt = 0;
		for(int i=0; i<top; i++) {
			if(pArr[i].getName().toUpperCase().equals(dto.getName().toUpperCase())){
				People p = new People();
				p.setIdx(pArr[i].getIdx());
				p.setName(pArr[i].getName());
				p.setPhone(pArr[i].getPhone());
				tmp[cnt++] = p;
			}
		}
		People[] arr = new People[cnt];
		for(int i=0; i<cnt; i++) {
			arr[i] = tmp[i];
		}
		return arr;
	}

	public void modify(People dto) {
		// pArr에서 dto의 idx와 같은 데이터를 찾아서 객체를 교체한다.
		System.out.println("dao-modify ===> " + dto);
		boolean flag = false;
		for(int i=0; i<top; i++) {
			if(dto.getIdx() == pArr[i].getIdx()) {
				pArr[i] = dto;
				flag = true;
				break;
			}
		}
		if(!flag) {
			System.out.println("수정 실패!");
		} else {
			System.out.println("수정 성공!");
		}
	}

	public void delete(People dto) {
		// dto.idx와 같은 데이터를 찾아서 제거한다.
		// 한칸씩 앞으로 이동 후에 top--
		for(int i=0; i<top; i++) {
			if(dto.getIdx() == pArr[i].getIdx()) {
				for(int j=i; j<top-1; j++) {
					pArr[j] = pArr[j+1];
				}
				top--;
				break;
			}
		}
	}
}
