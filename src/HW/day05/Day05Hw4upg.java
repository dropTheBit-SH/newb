package day05;

import java.util.Scanner;
import static java.lang.System.out;
/*
 * 1주차 미니프로젝트
 * 높다낮다 게임 구현
 * 난수 만들어서
 * 정해진 횟수 안에 맞추기(5번) => 못맞추면 실격
 * 이전과 같은 값 입력시 카운트 안 오름
 * 오답시 범위 알려주기
 */

/*	RULE
 * -----------------------------
 * GAME
 * ---------------------------
 * 시스템이 숫자를 생성하였습니다.
 * 정답 입력(1~100 사이): 101
 * >>> 범위를 초과하였습니다. 
 * 다시 입력(1~100 사이): 50
 * >>> 50은 너무 큰 숫자입니다.
 * >>> 기회가 4번 남았습니다.
 * 정답 입력(1~49 사이): 30
 * >>> 30은 너무 작은 숫자입니다.
 * >>> 기회가 3번 남았습니다
 * 정답 입력(31~49 사이): 35
 * >>> 정답입니다!
 * 
 * >>> 실격입니다!
 * 계속 하시겠습니까(y/n)? t
 * >>> y 또는 n만 입력하세요!
 * 계속 하시겠습니까(y/n)? n
 * >>> 수고하셨습니다!
 * 
 */
public class Day05Hw4upg {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int com = 0, user = 0;
		int rangeS = 1, rangeE = 100, time;
		String retry; boolean flag = true;
		String input = "";
		String grammar = ""; int[] grammarRef = {0,1,3,6,7,8};

		out.printf("=========================\n        G A M E\n=========================\n");
		/* com 난수 생성 */
		com = (int) (Math.random() * 100);
		out.println("시스템이 숫자를 생성했습니다.");
		
		/* user값 입력 */
		run: for (time=5; time >= 0; time--) {
			input = "";
			out.printf("\n> 정답 입력(%d~%d 사이): ", rangeS, rangeE);
			input = sc.next();
			
			/* - 유효성 검사: 범위 초과 */
			check: do {
				if(!input.matches("[0-9]+")) {
					out.println("숫자만 입력해주세요");
				}else {
					user = Integer.parseInt(input);
					if(!(user >= rangeS && user <= rangeE)) {
						out.println("범위를 초과했습니다.");
					}else {
						break check;
					}
				}
				input = "";
				out.printf("\n> 다시 입력(%d~%d 사이): ", rangeS, rangeE);
				input = sc.next();
			}while((!(user >= rangeS && user <= rangeE)) || (!input.matches("[0-9]+")) );
				
			
			/* 값 비교  */
			do { 
				if (com != user) {
					if (com < user) {
						rangeE = user-1;
						for(int i=0; i<grammarRef.length; i++) {
							if(user==grammarRef[i] || user%10==grammarRef[i]) { grammar = "은"; break; } grammar = "는"; 
						}
						out.printf("%d%s 너무 큰 숫자입니다.\n기회가 %d번 남았습니다.\n", user, grammar, time); //
						continue run;
					} else {
						rangeS = user+1;
						for(int i=0; i<grammarRef.length; i++) {
							if(user==grammarRef[i] || user%10==grammarRef[i]) { grammar = "은"; break; } grammar = "는"; 
						}
						out.printf("%d%s 너무 작은 숫자입니다.\n기회가 %d번 남았습니다.\n", user, grammar, time);
						continue run;
					}
				
				} else {
					out.println("정답입니다!");
					System.exit(0);
				}
			} while (time != 0);
		}
		
		/* 실격 재도전(횟수가 남지 않았을 때) */
		out.println("실격입니다!");
		do {
			out.println("> 재도전 하시겠습니까?(y/n)");
			input = sc.next();
			retry = String.valueOf(input);
			
			if (retry.equals("y")) {
				flag = false;
				main(null);
			} else if (retry.equals("n")) {
				flag = false;
				out.println("수고하셨습니다!");
				System.exit(0);
			} else {
				out.println("y 또는 n만 입력하세요!");
			}
		} while (flag);

	} //end of main
}
