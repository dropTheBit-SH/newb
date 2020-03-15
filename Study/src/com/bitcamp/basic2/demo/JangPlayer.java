package com.bitcamp.basic2.demo;

/**
 팀프로젝트를 위한 인터페이스 정립
 인터페이스는 설계
 연결된 작업을 지연 없이 동시다발적으로 처리할 수 있다
 (추상클래스나 인터페이스로)
*/

public class JangPlayer implements Player{

	@Override
	public int getCallValue() {
		return 0;
	}

	@Override
	public int[] response(int cv) {
		return null;
	}

	@Override
	public void predict(int i, int j) {
	}

	@Override
	public void genInt() {
	}

}
