package day04;

public class StarTree {
//	  *
//	 ***
//  *****
// *******
//*********
// *******
//  *****
//   ***
//	  *
	
	public static void main(String[] args) {
		for(int i=0; i<5; i++){            // 5줄을 출력한다 (0 1 2 3 4) 
			for(int j=0; j<4-i; j++){	      //공백:4 3 2 1 0	<4-0 43210	 
				System.out.print(" ");	
			}
			for(int j=0; j<(2*i+1); j++){    //별:1 3 5 7 9	<2*0+1 13579 	
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=0; i<4; i++){          // 4줄을 출력한다  (0 1 2 3)
			for(int j=0; j<=i; j++){          //공백:1 2 3 4 <=0 1234
				System.out.print(" ");
			}
			for(int j=7; j>=(2*i+1); j--){    //별:7 5 3 1 >=1357 
				System.out.print("*");
			}
			System.out.println();
		}
	}
		
}


