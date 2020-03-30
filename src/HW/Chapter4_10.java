package book2;

abstract class PairMap {
	protected String keyArray[]; 
	protected String valueArray[]; 
	abstract String get(String key); // key 값을 가진 value 리턴, 없으면 null 리턴
	abstract void put(String key, String value); // key와 value를 쌍으로 저장. 기존에 key가 있으면, 값을 value로 수정
	abstract String delete(String key); // key 값을 가진 아이템 (value와 함께) 삭제, 삭제된 value 값 리턴
	abstract int length(); // 현재 저장된 아이템의 개수 리턴
	}

class Dictionary extends PairMap{
	private int num;
	private int set;
	public Dictionary(int num){
		this.num = num;
		keyArray = new String[num];
		valueArray = new String[num];
	}
	public String get(String key) {
		for(int i=0; i<num; i++) {
			if(key.equals(keyArray[i])) {
				return valueArray[i];
			}
		}
		return null;
	}
	public void put(String key, String value) {
		for(int i=0; i<num; i++) {
			if(key.equals(keyArray[i])) {
				valueArray[i] = value;
				return;
			}
		}
		keyArray[set] = key;
		valueArray[set] = value;
		set++;
	}
	public String delete(String key) {
		for(int i=0; i<num; i++) {
			if(key.equals(keyArray[i])) {
				keyArray[i]=null;
				valueArray[i]=null;
			}
		}
		return key;
	}
	public int length() {
		return set;
	}
	
	
}
public class Chapter4_10 {
	public static void main(String[] args) {
		Dictionary dic = new Dictionary(10);
		dic.put("황기태", "자바");
		dic.put("이재문", "파이선");
		dic.put("이재문", "C++");
		System.out.println("이재문의 값은 "+dic.get("이재문"));
		System.out.println("황기태의 값은 "+dic.get("황기태"));
		dic.delete("황기태");
		System.out.println("황기태의 값은 "+dic.get("황기태"));
	}
}
