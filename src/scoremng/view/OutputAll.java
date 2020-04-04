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

		for(int i=0; i<data.dtoArr.length; i++){
			System.out.printf(data.dtoArr[i].toString()+(i+1)+"\n");
		}
		System.out.println(endTitle);
	}

}
