package ch15;

import java.io.*;
import java.util.ArrayList;

class DirectoryInfoTest {
	static int totalFiles = 0;
	static int totalDirs = 0;
	static int totalSize = 0;

	public static void main(String[] args) {
		File dir = new File(args[0]);
		if (!dir.exists() || !dir.isDirectory()) {
			System.out.println("��ȿ���� ���� ���丮�Դϴ�.");
			System.exit(0);
		}
		countFiles(dir);
		System.out.println("�� " + totalFiles + "���� ����");
		System.out.println("�� " + totalDirs + "���� ���丮");
		System.out.println("ũ�� " + totalSize + " bytes");
	} // main

	public static void countFiles(File dir) {
		//1. dir�� ���ϸ��(File[])�� ���´�. 
		File[] files = dir.listFiles();
		for(int i=0; i<files.length; i++) {
			//2. ���� ���ϸ���� ���� �߿��� ���丮��, totalDirs�� ���� ������Ű�� countFiles()�� ���ȣ���Ѵ�. 
			if(files[i].isDirectory()) {
				totalDirs++;
				countFiles(files[i]);
			//3. �����̸�, totalFiles�� ������Ű�� ������ ũ�⸦ totalSize�� ���Ѵ�.
			}else {
				totalFiles++;
				totalSize += files[i].length();
			}
		}
	} // countFiles
}