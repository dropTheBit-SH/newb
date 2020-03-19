package day04;
//for
//1+2-3+4-5+6-7+8-9+10=7
public class Test {
	final static int END = 10;
	static int total = 1;
	static String result="1";

	public static void main(String[] args) {
		test2();
		System.out.println(result);
	}
	
	static String test2(){
		int num = 1;
		for(int i=2; i<=END; i++){
			if(num==1){
				result += "+"+i;
				total += i;
				num++;
			}else{	
				result += "-"+i;
				total -= i;
				num--;
			}
		}

		result = result + "=" + total;
		return result;
	}
		
}
