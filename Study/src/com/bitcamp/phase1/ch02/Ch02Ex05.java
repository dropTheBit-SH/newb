package org.comstudy21.ch02;

import java.util.Scanner;
import static java.lang.System.out;

public class Ch02Ex05 {
	public static void main(String[] args) {
		
		double area = 0; // ���� ����
		double line = 0; // ���� �ѷ��� ����
		double r = 0; // ������
		final double PI = 3.141592;
		
		// ���� �������� �Է� �޾Ƽ� �ѷ��� ���̿� ������ ����ϴ� ���α׷�
		
		Scanner scan = new Scanner(System.in);
		
		out.printf("������: \n");
		r = scan.nextDouble();
		
		area = PI * (r * r);
		line = 2 * PI * r;
		
		out.printf("������ %.1f �� ��, ������ %.1f�̰� �ѷ��� %.1f"
												, r, area, line);
		
		
	}
}
