package day05;
import static java.lang.System.out;
public class Day05Hw1 {
//주말과제1-별찍기 다이아반전
	
//********* 
//**** ****
//***   ***
//**     **
//*       *
//**     **
//***   ***
//**** ****
//*********

	public static void main(String[] args) {
		for(int k=0; k<=9; k++) out.print((k!=9? "*":"\n"));
		
		for(int i=1; i<5; i++){ 
			for(int j=0; j<5-i; j++) out.print("*");
			for(int j=1; j<2*i; j++) out.print("^");
			for(int j=5; j>i; j--) 	 out.print("*");
			out.println();	
		}
	
		for(int i=1; i<4; i++){ 
			for(int j=0; j<1+i; j++) out.print("*");
			for(int j=7; j>2*i; j--) out.print("^");
			for(int j=0; j<i+1; j++) out.print("*");
			out.println();	
		}
		
		for(int k=0; k<=9; k++) out.print((k!=9? "*":"\n"));
		
	}
}
