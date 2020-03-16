package baseballGame;

public class OldVersion {
	
	public static void main(String[] args) { 	
		int[] count = ballCount(252, 322);		
		System.out.println("Strike : "+count[0]);
		System.out.println("Ball : "+count[0]);
	}
	
	public static int[] ballCount(int myNum, int urNum) { 	
		int[] count = new int[2]; 
		String myS = String.valueOf(myNum); 	
		char[] myChar = myS.toCharArray();  	
		String urS = String.valueOf(urNum);
		char[] urChar = urS.toCharArray();
		System.out.println(myChar);
		System.out.println(urChar);
		
		for(int myI=0; myI<myChar.length; ++myI) {
			for(int urI=0; urI<urChar.length; ++urI) {
				if(myChar[myI] == urChar[urI]) {
					if( myI==urI ) {
						count[0]++; 
					}else {
						count[1]++; 
					}}}}
		return count; 		
	}
}
