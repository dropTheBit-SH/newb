package book2;

import java.util.Scanner;

abstract class Converter{
	abstract protected double convert(double src);
	abstract protected String getSrcString();
	abstract protected String getDestString();
	protected double ratio; 
	
	public void run(){
		Scanner scanner = new Scanner(System.in);
		System.out.println(getSrcString()+"을 "+getDestString()+"로 바꿉니다");
		System.out.print(getSrcString()+"을 입력하세요>> ");
		double val = scanner.nextDouble();
		double res = convert(val);
		System.out.println("변환 결과: "+res+getDestString()+"입니다");
		scanner.close();
	}
}

class Won2Dollar extends Converter{
	public Won2Dollar(double ratio) { // 1200원
		this.ratio = ratio; 
	}
	protected double convert(double src){ // 입력값 24000원
		double res = src / ratio;
		return res;
	}
	protected String getSrcString(){
		return "원";
	}
	protected String getDestString(){
		return "달러";
	}
}

class Km2Mile extends Converter{
	public Km2Mile(double ratio){ // 1.6km
		this.ratio = ratio;
	}
	protected double convert(double src){  // 입력값 30
		double res = src / ratio;
		return res;
	}
	protected String getSrcString(){
		return "km";
	}
	protected String getDestString(){
		return "mile";
	}
}

public class Chapter4_3n4 {
	public static void main(String[] args) {
//		Won2Dollar toDollar = new Won2Dollar(1200); // 1달러는 1200원
//		toDollar.run();
		
		Km2Mile toMile = new Km2Mile(1.6);
		toMile.run();
	}
}
