package baseballGame;

import java.io.IOException;
import java.util.Scanner;

public class NewVersion {
	public static void main(String[] args) throws IOException {
		
//입력: com 난수 (3자리의 임의의 숫자를 만들어 com에 저장한다)
		int com = 0;
		com = (int)(Math.random() * 1000); 
	
//입력: user 입력 (숫자를 입력 받아 int로 변환 후 user에 저장한다)
		int atm = 1;
		run: do {
			Scanner sc = new Scanner(System.in);
			System.out.println("[정답을 입력하세요]");
			String input = sc.nextLine();
			int user = Integer.parseInt(input); 
			
// 처리: Count ( strike와 ball의 값을 저장할 char 배열을 선언하고 변환한다, 값을 비교하여 해당 값을 증가시킨다)
			int[] count = {0,0}; 
			char[] c = String.valueOf(com).toCharArray(); 
			char[] u = String.valueOf(user).toCharArray(); 
			for(int i=0; i<c.length; i++) {
				for(int j=0; j<u.length; j++) {
					if(c[i]==u[j]) {
						if(i==j) {
							count[0]++;
						}else {
							count[1]++;
						}}}}
			
//출력: xS, xB, xO + 시도횟수 (단순 출력) 
			if(count[0]!=3) {
				System.out.printf("%d S,\t%d B\n", count[0], count[1]);
				System.out.printf("(  %d번째 시도  )\n\n", atm );
				atm++;
			}else{
				System.out.println("축하합니다! 정답은 "+com+"입니다!");
				break run;
			}
		}while(atm!=1); 
		
	}
}
