package day05;
import java.util.Scanner;
import static java.lang.System.out;
//숙제2
//정수 세개를 입력 받는다
//제일 큰 수, 제일 작은 수를 판별하여 출력
//단 논리연산자는 쓰지 않기

public class Day05Hw2 {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int a, b, c;
		int max, min, mid=0;
		
		out.print("입력1: "); a = sc.nextInt();
		out.print("입력2: "); b = sc.nextInt();
		out.print("입력3: "); c = sc.nextInt();
		
		if(a>b){ 
			if(b>c){ // abc
				max = a; mid = b; min = c;
			}else/*(b<c)*/{ 
				if(a<c){ // cab
					max = c; mid = a; min = b;
				}else{ // acb
					max = a; mid = c; min = b;
				}
			}

		}else/*(a<b)*/{  
			if(b<c){ // cba 
				max = c; mid = b; min = a;
			}else/*(c<b)*/{    
				if(a<c){ // bca 
					max = b; mid = c; min = a;
				}else{ // bac
					max = b; mid = a; min = c;
				}
			}
		}	
		
		out.println("max = "+max);
		out.println("mid = "+mid);
		out.println("min = "+min);
		
	}
}
