package org.comstudy21.ch02;
//�ڱ�Ұ��� �����͸� �Է� �޾Ƽ� ����ϴ� ���α׷��� ������
/// ����, ����, ��°�, ����, ����, Ư��, Ű, �÷�, ������, �巡���

import static java.lang.System.out;
import java.util.Scanner;

public class Ch02Ex07 {
	public static void main(String[] args) {
		
		String nam = "", adr = "", maj = "", job = "", hob = "", blo = "", dre = "";
		int age = 0;
		double hei = 0, sigR = 0, sigL = 0;  
		
		Scanner sc = new Scanner(System.in);
		
		out.printf("�̸�: ");
		nam = sc.nextLine(); 
		out.printf("�ּ�: ");
		adr = sc.nextLine(); 
		out.printf("����: ");
		maj = sc.nextLine();
		out.printf("����: ");
		job = sc.nextLine();
		out.printf("Ư��: ");
		hob = sc.nextLine();
		out.printf("������: ");
		blo = sc.nextLine();
		out.printf("����: ");
		age = sc.nextInt(); 
		out.printf("Ű: ");
		hei = sc.nextDouble();
		out.printf("�÷�(��): ");
		sigR = sc.nextDouble();
		out.printf("�÷�(��): ");
		sigL = sc.nextDouble(); 
		out.printf("�巡���: ");
		dre = sc.nextLine();
		
		
		out.printf("����: %s\t ����: %d\n", nam, age);
		out.printf("��°�: %s\n", adr);
		out.printf("����: %s\t ����: %s\t Ư��: %s\n", maj, job, hob);
		out.printf("Ű: %.1f\t �÷�(��): %.1f\t �÷�(��): %.1f\t ������: %s\n", hei, sigR, sigL, blo);
		out.printf("�巡���: %s\n", dre);
		
	}
}
