package scoremng.model;

public class Dao {

	public static final int MAX = 100;
	public Dto[] dtoArr = new Dto[MAX];
	public int top = 0;
	public int seq = 1;
	
	private Dao(){}
	private static Dao instance;
	public static Dao getInstance(){
		if(instance == null)	instance = new Dao();
		return instance;
	}
	
	public static int getMax() {
		return MAX;
	}
	public int getTop() {
		return top;
	}

	public void insert(Dto dto){
		dto.setIdx(seq++);
		dtoArr[top++] = dto;
	}
	
	public void insertGroup(Dto[] tmpArr) {
		for(int i=0; i<tmpArr.length; i++) {
			tmpArr[i].setIdx(seq++);
			dtoArr[top++] = tmpArr[i];
		}
	}
	
	public Dto[] selectAll() {
		
		Dto[] arr = new Dto[top];
		Dto tmp = new Dto();
		for(int i=0; i<top; i++){
			arr[i] = new Dto();
			
			arr[i].setIdx(dtoArr[i].getIdx());
			arr[i].setName(dtoArr[i].getName());
			arr[i].setSubKor(dtoArr[i].getSubKor());
			arr[i].setSubEng(dtoArr[i].getSubEng());
			arr[i].setSubMath(dtoArr[i].getSubMath());
			arr[i].setSum(dtoArr[i].getSum());
			arr[i].setAvg(dtoArr[i].getAvg());
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=i; j<arr.length; j++) {
				if(arr[i].getAvg() < arr[j].getAvg()) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}	
		}
		return arr;
	}
}
