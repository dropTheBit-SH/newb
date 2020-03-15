package org.comstudy21.ch01;
/*
 * 성명, 나이, 사는곳, 전공, 직업, 특기, 키, 시력, 혈액형, 장래희망
 */
import java.lang.System;
import static java.lang.System.*;

public class Day02EX02 {
	public static void main(String[] args){
		
		
		err.println("- - - - - 자 기 소 개 - - - - -"); 
		
//		java.lang.System.out.println();
		
//		java.lang.System;
//		Static java.lang.System.out;
		
		/* static import로 out 필드 객체를 불러오기 
		 * import: 프로젝트 외부에 선언된 클래스나 객체를 불러온다
		 * 원칙적으로는 system 클래스도 import해야 사용할 수 있다
		 * java.lang 패키지는 디폴트임으로 생략(자바 컴파일러가 자동으로 추가해줌)
		 * 
		 * out 파란이탤릭체
		 * static 객체 = class 멤버
		 */
	
		
		System.out.printf("성명: %s\n", "김수희");
		System.out.printf("나이: %d\n", 30);
		System.out.printf("사는곳: %s\n", "경기도 과천");
		System.out.printf("전공: %s\n", "경영정보학과");
		System.out.println("직업: 백수..?(이전 직업: IT컨설턴트)");
		System.out.println("특기: 요리");
		System.out.print("키: 158\t" + "시력: 안경씀(5년 전 라섹했는데 나빠짐)\t" + "혈액형: O형\n");
		//%10d 10칸 띄고 오른쪽
		//%.1f 소수점 
		// alt 방향키 복제이동
		// ctrl shift 슬래시 주석
		System.out.println("장래희망: 개발자");
		
	}
}
