package org.comstudy21.ch01;

import java.io.IOException;

public class Day02Ex03 {
	public static void main(String[] args) throws IOException{
		/* �������� �Է�
		 * 1) System.in 
		 * 2) Scanner [����]
		 */
		
		// ���̸� �Է� �޾Ƽ� ����Ѵ� 
		System.out.print("���� �Է�: ");
		int age = System.in.read() - 48; // IOException ����ó���� �ʿ��ϴ�
		
		System.out.printf("����: %d\n", age); 
		// !!! ASKII�ڵ�(�Ǵ� �����ڵ�)�� �ν��Ͽ� ���ϴ� ���� ��µ��� �ʴ´�
		// 0 : 48, a: 97, A: 65 (48 = '0')
		// !!! read�� �� ���� �� ���ڸ� �о� �� �� �ִ�
		
//		age = age *10; 
//		age += System.in.read() -48;


	}
}
