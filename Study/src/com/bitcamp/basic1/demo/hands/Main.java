package com.bit.demo.hands;
// 가위바위보 

public class Main {
	public static void main(String[] args) {
		Player left = new PlayerImpl(); //구현체를 인터페이스 이름으로 바꿨다는 것은 같은 행동을 수행한다는 뜻이다
		Player right = new JangPlayer();
		
		int lv = left.getHands(); // 왼쪽이 낸거
		int rv = right.getHands(); // 오른쪽이 낸거
		
		
	}
}
