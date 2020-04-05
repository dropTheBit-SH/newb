package scoremng.view;

public class OutputAll implements View {

	@Override
	public void display() {
		System.out.println(outputAllTitle);
		
		if(!check()) return;
			
		for(int i=0; i<tableBarArr.length; i++){
			System.out.printf("%s\t", tableBarArr[i]);
		}
		System.out.println();

		System.out.printf(data.dtoArr[0].toString()+1+"\n");
		for(int i=1; i<data.dtoArr.length; i++){
			if(!(data.dtoArr[i].getAvg() == data.dtoArr[i-1].getAvg())) {
				System.out.printf(data.dtoArr[i].toString()+(i+1)+"\n");
			}else {
				System.out.printf(data.dtoArr[i].toString()+(i)+"\n");
			}
			  
		}
		
		System.out.println(endTitle);
	}

}
