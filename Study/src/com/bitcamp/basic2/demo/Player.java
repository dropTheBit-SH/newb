package com.bitcamp.basic2.demo;

/**
인터페이스가 추가 되면 
그걸 구현하는 온갖 각 클래스에서 다시 작업이 되어야 함
 */

public interface Player {
	int getCallValue();

	int[] response(int cv);

	void predict(int i, int j);
	
	void genInt();
	
}
