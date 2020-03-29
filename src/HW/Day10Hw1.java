package day10;

class Music{
	private String singer;
	private String song;
	
	public Music(){	
		this("가수", "노래");
	}
	public Music(String singer, String song){
		this.singer = singer;
		this.song = song;
	}
	
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public void setSong(String song) {
		this.song = song;
	}

	public String play(){
		return singer+"의 "+song+"...재생 중입니다.";
	}
	
}

class MusicPlayer extends Music{
	private String[] list = new String[7];
	private int idx = 0;
	
	public String[] add(Music m) {
		if(idx<list.length) {
			list[idx] = m.play();
			idx++;
		}else	System.out.println("더 이상 추가할 수 없습니다!");
		return list;
	}
	
	public String play(){
		for(int i=0; i<idx; i++) 
			System.out.println(list[i]);
		
		return null;
	}

}

public class Day10Hw1 {
	public static void main(String[] args) {
		Music m1 = new Music("룰라", "3!4!");
		Music m2 = new Music();
		m2.setSinger("투투");
		m2.setSong("1과 2분의 1");
		Music m3 = new Music("이선희", "아~옛날이여");
		
//		m1.play();
//		m2.play(); 
//		m3.play();
		
		MusicPlayer mp = new MusicPlayer();
		mp.add(m1); // 배열 안에 들어가도록, 최대 7곡까지 추가 가능
		mp.add(m2);
		mp.add(m3);
		mp.add(new Music("조용필", "바람의 노래"));
		mp.play(); // 상단이 쭉 실행되게
		
	}
}

