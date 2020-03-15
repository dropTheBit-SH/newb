package com.bit.demo.hands;

public class Main {

	public static void main(String[] args) {
		Player left = new PlayerImpl();
		Player right = new JangPlayer();
		// 게임 : 가위바위보
		
		int lv = left.getHands();
		int rv = right.getHands();
		
		System.out.println(lv + ":" + rv);

	}

}
