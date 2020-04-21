import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class BingoTest {
	// 2차원 배열 arr의 빙고 갯수를 세어서 반환. 아래의 메서드를 완성하고 테스트하시오.
	int bingoCheck(int[][] arr) {
		int cnt = 0;
		
		// 같은 배열, 다른 순서 -> 값들이 같음 -> 빙고
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				if(arr[i][j]!=1) break;
				else if(j==arr[i].length-1) cnt++;
				
			}
		}
		// 다른 배열, 같은 순서 -> 값들이 같음 -> 빙고
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				if(arr[j][i]!=1) break;
				else if(j==arr[i].length-1) cnt++;
			}
		}
		// (대각선)배열과 순서의 숫자가 같음 -> 값들이 같음 -> 빙고
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				if(i==j && arr[i][j]!=1) break;
				else if(i==j && i==arr.length-1) cnt++;
			}
		}
		// (역대각선)배열과 순서를 합하여 길이가 됨 -> 값들이 같음 -> 빙고
		A: for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				if(i+j==arr.length-1 && arr[i][j]!=1) break A;
				else if(i+j==arr.length-1 && i==arr.length-1) cnt++;
			}
		}
		return cnt;
}
