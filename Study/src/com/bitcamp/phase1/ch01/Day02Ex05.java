package org.comstudy21.ch01;
// System.in.read() : �ƽ�Ű�ڵ�� Ű���� �Է��� �޴´�
import java.io.IOException;

public class Day02Ex05 {
	
	public static void test(String[] args){
		
		System.out.printf("%c, %d\n", '0', (int)'0'); // 0�� ���ؼ� char�� 10������ ���
		System.out.printf("%c, %d\n", 'A', (int)'A');
		System.out.printf("%c, %d\n", 'a', (int)'a');
	}
	
	
	public static void main(String[] args) throws IOException{
	
	// scanner�� ���� �Է� (java.util)
	// �����Է� -> �̸��Է�
	
	int age = 0; // ���� ���� �� �ʱ�ȭ
	int name = 0;
	
	System.out.println("�����Է�: ");
	age = System.in.read() - '0'; // ���Ͱ� ���� ������ buffer �ȿ� ���� �޴´�
	System.in.read(); // enter = \n\r  (\n ����)
	System.in.read(); // (\r ����)
	
	System.out.println("�̸��Է�: ");
	name = System.in.read(); 
	
	System.out.printf("����:%d, �̸�:%c\n", age, name);

	}
}
