package org.comstudy21.ch02;

import java.util.Scanner;

import static java.lang.System.out;

public class Ch02Ex04 {
	public static void main(String[] args) {
		//Scanner�� �̿��ؼ� ���� ����, ���� ���̸� �Է� �޾Ƽ� ���簢���� ���̸� ����ϴ� ���α׷��� ���弼��
		
		Scanner sc = new Scanner(System.in);
		
		double width = 0, height = 0; 
		out.print("���� ����: \n");
		width = sc.nextInt();
		out.printf("���� ����: \n");
		height = sc.nextInt();
		
		double area = 0;
		area = width * height;
		
		out.printf("���� %.1f, ���� %.1f�� ���簢���� ���̴� %.1f�Դϴ�."
				, width, height, area);
	}
}
