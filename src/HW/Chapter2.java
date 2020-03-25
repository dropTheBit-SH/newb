package book;

import java.util.*;

public class Chapter2 {
	static Scanner scan = new Scanner(System.in);
	static int input = 0;
	static int tmp1 = 0;
	static int tmp2 = 0;
	static int tmp3 = 0;
	public static void main(String[] args) {
//		//실습1
//		System.out.print("원화를 입력하세요(단위 원)>>");
//		input = scan.nextInt();
//		System.out.printf("%d원은 $%1.1f입니다", input, (double)input/1100);
//
//		//실습2
//		System.out.print("2자리수 정수 입력(10~99)>>");
//		do{
//			input = scan.nextInt();
//		}while(input<10||input>99);
//		if(input/10 == input%10)
//			System.out.println("Yes! 10의 자리와 1의 자리가 같습니다.");
//		else System.out.println("No! 10의 자리와 1의 자리가 다릅니다.");
//	
//		//실습3
//		int 오만원권 = 0;
//		int 만원권 = 0;
//		int 천원권 = 0;
//		int 백원 = 0;
//		int 오십원 = 0;
//		int 십원 = 0;
//		int 일원 = 0;
//		System.out.print("금액을 입력하시오>>");
//		input = scan.nextInt();
//		
//		if(input>=50000){
//			오만원권 = input/50000;
//			input -= 오만원권*50000;
//			if(input>=10000){
//				만원권 = input/10000;
//				input -= 만원권*10000;
//				if(input>=1000){
//					천원권 = input/1000;
//					input -= 천원권*1000;
//					if(input>=100){
//						백원 = input/100;
//						input -= 백원*100;
//						if(input>=50){
//							오십원 = input/50;
//							input -= 오십원*50;
//							if(input>=10){
//								십원 = input/10;
//								input -= 십원*10;
//							}
//						}
//					}
//				}
//			}
//		}
//		일원 = input;
//		
//		System.out.printf("오만원권 %d매\n", 오만원권);
//		System.out.printf("만원권 %d매\n", 만원권);
//		System.out.printf("천원권 %d매\n", 천원권);
//		System.out.printf("백원 %d개\n", 백원);
//		System.out.printf("오십원 %d개\n", 오십원);
//		System.out.printf("십원 %d개\n", 십원);
//		System.out.printf("일원 %d개\n", 일원);
//	
//		//실습4
//		int mid = 0;
//		System.out.println("다른 정수 3개 입력");
//		System.out.print("첫번째 정수>>");
//		tmp1 = scan.nextInt();
//		System.out.print("두번째 정수>>");
//		tmp2 = scan.nextInt();
//		System.out.print("세번째 정수>>");
//		tmp3 = scan.nextInt();
//		
//		if((tmp2>tmp1 && tmp1>tmp3) || (tmp2<tmp1 && tmp1<tmp3)) mid = tmp1;
//		if((tmp1>tmp2 && tmp2>tmp3) || (tmp1<tmp2 && tmp2<tmp3)) mid = tmp2;
//		if((tmp1>tmp3 && tmp3>tmp2) || (tmp1<tmp3 && tmp3<tmp2)) mid = tmp3;
//		
//		System.out.println(mid);
//		
//		//실습5
//		System.out.println("다른 정수 3개 입력");
//		System.out.print("첫번째 정수>>");
//		tmp1 = scan.nextInt();
//		System.out.print("두번째 정수>>");
//		tmp2 = scan.nextInt();
//		System.out.print("세번째 정수>>");
//		tmp3 = scan.nextInt();
//		
//		if(tmp1>tmp2+tmp3||tmp2>tmp1+tmp3||tmp3>tmp1+tmp2){
//			System.out.println("삼각형이 됩니다");
//		}else{
//			System.out.println("앙대");
//		}
//		
//		//실습6
//		System.out.print("1~99 사이의 정수를 입력하시오>>");
//		input = scan.nextInt();
//		int count = 0;
//		if(input/10==3||input/10==6||input/10==9){
//			count++;
//		}
//		if(input%10==3||input%10==6||input%10==9){
//			count++;
//		}
//		System.out.println(count==2? "박수짝짝" : count==1? "박수짝" : "...");
//		
//		//실습7
//		int x = 0;
//		int y = 0;
//		System.out.println("점 (x,y)의 좌표를 입력하시오");
//		System.out.print("x 좌표:");
//		x = scan.nextInt();
//		System.out.print("y 좌표:");
//		y = scan.nextInt();
//		if(100<=x && x<=200 && 100<=y && y<=200)
//			System.out.printf("(%d, %d)는 사각형 안에 있습니다", x, y);
//		else 
//			System.out.printf("(%d, %d)는 사각형 안에 없습니다", x, y);
//		
//		//실습8
//		
//		int x1 = 0; int y1 = 0;
//		int x2 = 0; int y2 = 0;
//		int rectx1 = 100; int recty1 = 100;
//		int rectx2 = 200; int recty2 = 200;
//		
//		System.out.print("x1 좌표: ");
//		x1 = scan.nextInt();
//		System.out.print("y1 좌표: ");
//		y1 = scan.nextInt();
//		System.out.print("x2 좌표: ");
//		x2 = scan.nextInt();
//		System.out.print("y2 좌표: ");
//		y2 = scan.nextInt();
//		
//		if((x1>=rectx1 && x1<=rectx2) && (y1>=recty1 && y1<=recty2))
//			System.out.print("사각형과 충돌합니다.");
//		else if((x1>=rectx1 && x1<=rectx2) && (y2>=recty1 && y2<=recty2))
//			System.out.printf("사각형과 충돌합니다.");
//		else if((x2>=rectx1 && x2<=rectx2) && (y1>=recty1 && y1<=recty2))
//			System.out.printf("사각형과 충돌합니다.");
//		else if((x2>=rectx1 && x2<=rectx2) && (y2>=recty1 && y2<=recty2))
//			System.out.printf("사각형과 충돌합니다.");
//		else System.out.printf("사각형 밖에 있습니다.");
//		
//		//실습9-미완성
//		double x1 = 0;
//		double y1 = 0;
//		double r = 0;
//		double x2 = 0;
//		double y2 = 0;
//		
//		System.out.println("원의 중심과 반지름을 입력하세요>>");
//		System.out.print("중심의 x 좌표: ");
//		x1 = scan.nextInt();
//		System.out.print("중심의 y 좌표: ");
//		y1 = scan.nextInt();
//		System.out.print("원의 반지름: ");
//		r = scan.nextInt();
//		System.out.print("확인할 점의 x 좌표: ");
//		x2 = scan.nextInt();
//		System.out.print("확인할 점의 y 좌표: ");
//		y2 = scan.nextInt();
//		
//		if()
//		
//		System.out.printf("점 (%.0f, %.0f)는 원 안에 있다.", x2, y2);
//		
//		//실습10-미완성
//		//실습11
//		System.out.print("달을 입력하세요(1~12)>>");
//		input = scan.nextInt();
//		
//		if(input==3 || input==4 || input==5){
//			System.out.println("봄");
//		}else if(input==6 || input==7 || input==8){
//			System.out.println("여름");
//		}else if(input==9 || input==10 || input==11){
//			System.out.println("가을");
//		}else if(input==12 || input==1 || input==2){
//			System.out.println("겨울");
//		}else{
//			System.out.println("잘못입력");
//		}
//		
//		switch(input){
//		case 3: case 4: case 5:
//			System.out.println("봄");
//			break;
//		case 6: case 7: case 8:
//			System.out.println("여름");
//			break;
//		case 9: case 10: case 11:
//			System.out.println("가을");
//			break;
//		case 12: case 1: case 2:
//			System.out.println("겨울");
//			break;
//		default:
//			System.out.println("잘못입력");
//		}
		
		//실습12
		int num1 = 0;
		int num2 = 0;
		String opr = "";
		System.out.print("연산할 숫자1>>");
		num1 = scan.nextInt();
		System.out.print("연산자>>");
		opr = scan.next();
		System.out.print("연산할 숫자2>>");
		num2 = scan.nextInt();
		
		if(opr.equals("+")){
			System.out.printf("%d%s%d=%d", num1, opr, num2, num1+num2);
		}else if(opr.equals("-")){
			System.out.printf("%d%s%d=%d", num1, opr, num2, num1-num2);
		}else if(opr.equals("*")){
			System.out.printf("%d%s%d=%d", num1, opr, num2, num1*num2);
		}else if(opr.equals("/")){
			System.out.printf("%d%s%d=%d", num1, opr, num2, num1/num2);
		}else{
			System.out.println("잘못 입력하셨습니다.");
		}
		
	}	
}
