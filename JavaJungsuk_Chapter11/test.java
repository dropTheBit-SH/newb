package ch11;

public class test {
	public static void main(String[] args) {
		for(int i=0, j=1; i<10; i++, j=i+1) {
			int value = 3000 + (j * 10);
			System.out.println(j+""+j+""+value);
		}
	}
}
