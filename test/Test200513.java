package test;

public class Test200513 {
	public static void main(String[] args) {
		System.out.println(Trans.BUS.getBasicFare());
		System.out.println(Direc.EAST.getVal());
	}
}

enum Trans{
	BUS(100){int fare(int distance) {return distance*BASIC_FARE;} },
	TRAIN(150){int fare(int distance) {return distance*BASIC_FARE;} };
	
	abstract int fare(int distance);
	protected final int BASIC_FARE;
	Trans(int basicFare){ BASIC_FARE = basicFare; }
	public int getBasicFare() { return BASIC_FARE; }
}

enum Direc{
	EAST(1), SOUTH(99);
	
	private final int value;
	Direc(int value){this.value = value;}
	public int getVal() { return value;}
}
