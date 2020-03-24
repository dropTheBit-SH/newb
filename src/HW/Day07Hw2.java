package day07;

public class Day07Hw2 {
	static int[][] arr = new int[5][5];
	static int number = 1;
	
	public static void printArr() {

		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				System.out.print(arr[i][j]==0? " \t": arr[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Arr4();
	}
	
	
	public static void Arr4() {
		//  1  2  3  4 5
		// 16 17 18 19 6
		// 15 24 25 20 7
		// 14 23 22 21 8
		// 13 12 11 10 9
		
		int mid = 2;
		int w = 0;
		int h = 0;
		
		for(int i=0; i<mid; i++){
			// 동
			for(w=i; w<4-i; w++){
				arr[i][w] = number++;
			}
	
			// 남
			for(h=i; h<4-i; h++){
				arr[h][4-i] = number++;
			}
			
			// 서
			for(w=4-i; w>=i; w--){
				arr[4-i][w] = number++;
			}
			
			//북
			for(h=3-i; h>=i+1; h--){
				arr[h][i] = number++;
			}
			
			//중앙
			
		}
		arr[mid][mid] = number++;
			
		printArr();
	}
	
	public static void Arr3() {
		// 1  2  3  4  5
		// 6  7  8  9
		// 10 11 12
		// 13 14 15 16
		// 17 18 19 20 21
		
		for(int i=0; i<5; i++){
			for(int j=0; i<=2 && j<5-i; j++){
				arr[i][j] = number++;
				//i<=2 && 5-i? j : j>i? j : 
			}
			for(int j=0; i>2 && j<=i; j++){
				arr[i][j] = number++; 
			}
		}
		printArr();
	}
	
	public static void Arr2() {
		// 나비
		// 1        13
		// 2 6   10 14
		// 3 7 9 11 15
		// 4 8   12 16
		// 5        17
		
		for(int i=0; i<5; i++) {
			for(int j=i; i<=2 && j<5-i; j++) {
				arr[j][i] = number++;
			}
			for(int j=4-i; i>2 && j<=i; j++) {
				arr[j][i] = number++;
			}
	
		}
		printArr();
	}
	
	public static void Arr1() {
		// 모래시계
		//  1 2 3 4 5
		//    6 7 8 
		//      9
		//   10 11 12
		// 13 14 15 16 17
		
		for(int i=0; i<5; i++) {
			for(int j=i; i<=2 && j<5-i; j++) {
				arr[i][j] = number++;
			}
			for(int j=4-i; i>2 && j<=i; j++) {
				arr[i][j] = number++;
			}
	
		}
		printArr();
	}
}
