package day05;
import java.util.Scanner;
import static java.lang.System.out;
// 구구단 
//시작과 종료 입력 후 3x3 출력
public class Day05Hw3 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int startDan, endDan, tmp = 0, dan = 0;
		
		out.printf("시작단:");
		startDan = sc.nextInt();
		out.printf("종료단:");
		endDan = sc.nextInt();
		
		if(startDan>endDan){
			tmp=startDan; startDan=endDan; endDan=startDan;
		}
		
		dan = startDan;		
		for(; startDan<=endDan; startDan+=3){
			for(int i=0; i<3; i++){ 
				if(endDan>=startDan+i && dan<=startDan+i){ 
					out.printf("===%d===\t", startDan+i);
				}
			}out.println();
			
			for(int cnt=1; cnt<=9; cnt++){
				for(int i=0; i<3; i++){
					if(endDan>=startDan+i && dan<=startDan+i){
						out.printf("%d*%d=%d\t", startDan+i, cnt, (startDan+i)*cnt);
					}
				}out.println();
			}
			out.println();
		}
	}
}
