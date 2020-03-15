package com.bitcamp.basic2.demo;

import java.io.IOException;


/**
injection: 주입한다 = 필요로 하는 매개변수 전달 (프레임웤이 자동으로 연결해주는 기능을 함)
 */

public class BootApp {
	public static void main(String[] args) throws IOException {
		game(new PlayerImpl(), new JangPlayer());
		game(new JangPlayer(), new PlayerImpl());
	}
	
	
	public static void game(Player left, Player right) {
		Player[] list = new Player[2]; 
		list[0] = left; 
		list[1] = right;
		int caller = 0;
		while(true){ 
			int cv =  list[caller].getCallValue(); 
			int[] rs = list[1-caller].response(cv); 
			list[caller].predict(rs[0], rs[1]);  
			System.out.println(rs[0]+"S");
			System.out.println(rs[1]+"B");
			if( rs[0]==3 ) { 
				System.out.println(0+" Payer win");
				break;
			}
			caller=(caller==1)?0 : 1;  
		}		
	}
	
//	
}

