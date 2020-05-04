package ch15;
//[15-3] 다음은 디렉토리의 요약정보를 보여주는 프로그램이다. 
//파일의 개수, 디렉토리의 개수, 파일의 총 크기를 계산하는 countFiles()를 완성하시오.
import java.io.*;

class DirectoryInfoTest {
	static int totalFiles = 0;
	static int totalDirs = 0;
	static int totalSize = 0;

	public static void main(String[] args) {
		File dir = new File("e:/workspace/JavaJungsuk_Chapter15/bin/ch15/"+args[0]);
		if (!dir.exists() || !dir.isDirectory()) {
			System.out.println("유효하지 않은 디렉토리입니다.");
			System.exit(0);
		}
		countFiles(dir);
		System.out.println("총 " + totalFiles + "개의 파일");
		System.out.println("총 " + totalDirs + "개의 디렉토리");
		System.out.println("크기 " + totalSize + " bytes");
	} // main

	public static void countFiles(File dir) {
		//1. dir의 파일목록(File[])을 얻어온다. 
		File[] files = dir.listFiles();
		for(int i=0; i<files.length; i++){
			//2. 얻어온 파일목록의 파일 중에서 디렉토리면, totalDirs의 값을 증가시키고 countFiles()를 재귀호출한다. 
			if(files[i].isDirectory()){
				totalDirs++;
				countFiles(dir);
			//3. 파일이면, totalFiles를 증가시키고 파일의 크기를 totalSize에 더한다.
			}else{
				totalFiles++;
				totalSize += files[i].length();
			}
		}
	} // countFiles
}
