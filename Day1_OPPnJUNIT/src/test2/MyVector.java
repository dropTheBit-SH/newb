package test2;

public class MyVector {
	Object[] objArr;
	int size;
	
	public MyVector(){
		this(16);
	}
	public MyVector(int capacity){
		objArr = new Object[capacity];
	}
	
	//objArr에 저장된 객체의 개수 size 반환
	public int size(){
		return size;
	}
	
	//objArr의 길이를 반환
	public int capacity(){
		return objArr.length;
	}
	
	//objArr이 비었는지 확인
	public boolean isEmpty(){
		return size==0;
	}
	
	//objArr에 객체를 추가(부족하면 사이즈 늘리기)
	public void add(Object obj){
		if(capacity() == size){
			Object[] tmpArr = new Object[capacity()+1];
			for(int i=0; i<capacity(); i++){
				tmpArr[i] = objArr[i];
			}
			objArr = tmpArr;
		}
		
		objArr[size()] = obj;
		size++;
	}
	
	//objArr에 index번째 객체 반환
	public Object get(int index){
		return objArr[index-1]; //n번째 객체는 [n-1]에 있기 때문에
	}
	
	//objArr에서 지정된 객체가 저장되어 있는 위치를 반환
	public int indexOf(Object obj){
		for(int i=0; i<capacity(); i++){
			if(objArr != null){
				 if(obj.equals(objArr[i]))
					 return i;
			}
		}
		return -1;
	}
	
	//objArr에서 지정된 객체를 삭제
	public boolean remove(Object obj){
		if(indexOf(obj) == -1) //지정된 객체와 동일한 객체가 없을 때
			return false;
		objArr[indexOf(obj)] = null;
		return true;
	}
	
	//====================================================
	
	//objArr의 지정된 위치에 객체 추가
	public void add(int index, Object obj){
		if(capacity() == size() || index > capacity()){
			Object[] tmpArr = new Object[capacity()+1];
			for(int i=0; i<capacity(); i++){
				tmpArr[i] = objArr[i];
			}
			objArr = tmpArr;
		}
		
		objArr[index] = obj;
	}
	
	//objArr을 용량을 크기에 맞게 줄인다(빈 공간을 줄인다)
	void trimToSize(){
		Object[] tmpArr = new Object[this.size()];
		for(int i=0; i<this.capacity(); i++){
			if(objArr[i] != null)
				tmpArr[i] = objArr[i];
		}
		setSize(this.size());
		objArr = tmpArr;
	}
	
	//objArr의 용량을 변경
	public void setSize(int newSize){
		Object[] tmpArr = new Object[newSize];
		for(int i=0; i<newSize; i++){
			tmpArr[i] = objArr[i];
		}
		objArr = tmpArr;
	}
	
	//objArr의 저장된 객체를 모두 제거
	void clear(){
		for(int i=0; i<capacity(); i++)
			objArr[i] = null;
	}
	
	//objArr의 모든 객체를 문자열로 이어서 반환
	@Override
	public String toString() {
		String result = "";
		for(int i=1; i<=capacity(); i++){
			if(get(i) != null){
				result += get(i);
				if(i!=size)
					result += ",";
			}
		}
		return "MyVector [objArr="+result+"]";
	}
}
