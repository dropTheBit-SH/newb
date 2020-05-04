package ch15;
//[15-3] ������ ���丮�� ��������� �����ִ� ���α׷��̴�. 
//������ ����, ���丮�� ����, ������ �� ũ�⸦ ����ϴ� countFiles()�� �ϼ��Ͻÿ�.
import java.io.*;

class DirectoryInfoTest {
	static int totalFiles = 0;
	static int totalDirs = 0;
	static int totalSize = 0;

	public static void main(String[] args) {
		File dir = new File("e:/workspace/JavaJungsuk_Chapter15/bin/ch15/"+args[0]);
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
		for(int i=0; i<files.length; i++){
			//2. ���� ���ϸ���� ���� �߿��� ���丮��, totalDirs�� ���� ������Ű�� countFiles()�� ���ȣ���Ѵ�. 
			if(files[i].isDirectory()){
				totalDirs++;
				countFiles(dir);
			//3. �����̸�, totalFiles�� ������Ű�� ������ ũ�⸦ totalSize�� ���Ѵ�.
			}else{
				totalFiles++;
				totalSize += files[i].length();
			}
		}
	} // countFiles
}
