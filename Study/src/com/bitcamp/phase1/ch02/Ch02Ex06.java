package org.comstudy21.ch02;
// ����, ����, ����, ���� ������ �Է� �޾Ƽ� 
// ����, ����� ����ϴ� ���α׷��� ������

// �ڱ�Ұ��� �����͸� �Է� �޾Ƽ� ����ϴ� ���α׷��� ������

import static java.lang.System.out;
import java.util.Scanner;

public class Ch02Ex06 {
	
	public static void main(String[] args) {
	
	String name = "";
	int kor = 0, eng = 0, mat = 0, sum = 0;
	double avg = 0;
	
	Scanner scan = new Scanner(System.in);
	
	out.printf("�̸�: ");
	name = scan.nextLine();
	out.printf("����: ");
	kor = scan.nextInt();
	out.printf("����: ");
	eng = scan.nextInt();
	out.printf("����: ");
	mat = scan.nextInt();
	
	sum = kor + eng + mat;
	avg = sum / 3;
	
	out.printf("%s�� ������ %d, ����� %.1f�Դϴ�.\n", name, sum, avg);
	out.printf("����: %d, \t����: %d, \t����: %d", kor, eng, mat);
	
	}
}
