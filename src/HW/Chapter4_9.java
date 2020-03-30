package book2;

import java.util.Scanner;

interface Stack{
	int length();
	int capacity();
	String pop();
	boolean push(String val);
}
class StringStack implements Stack{
	public int length;
	public int capacity;
	public String pop;
	public boolean push;
	public String[] res;
	public int top;
	
	public StringStack(int capacity) {
		res = new String[capacity];
		top = 0;
	}
	public int length(){
		return length;
	}
	public int capacity(){
		return res.length;
	}
	public String pop(){
		String str = res[top-1];
		top--;
		return str;
	}

	public boolean push(String val){
		if(top<res.length) {
			res[top] = val;
			top++;
			return true;
		}else {
			return false;
		}
	}
	public String toString() {
		String s = "";
		for(int i=0; i<res.length; i++) {
			s += pop()+" ";
		}
		return s;
	}
	
	
}
public class Chapter4_9 {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("총 스택 저장 공간의 크기 입력 >> ");
		StringStack sa = new StringStack(scan.nextInt());
		
		while(true) {
			System.out.print("문자열 입력 >> ");
			String str = scan.next();
			if(str.equals("그만")) break;
			if(sa.push(str)==false) System.out.println("스택이 꽉 차서 푸시 불가!");
		}
		
		System.out.print("스택에 저장된 모든 문자열 팝: ");
		System.out.println(sa.toString());
	}
}
