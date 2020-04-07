package chapter7;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class c7_6 {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Location[] location = new Location[4];
		HashMap<String, Location> cityMap = new HashMap<String, Location>();
		System.out.println("도시,경도,위도를 입력하세요.");
		for(int i=0; i<location.length; i++) {
			System.out.print(">> ");
			String input = scan.nextLine();
			StringTokenizer st = new StringTokenizer(input, ",");
			String city = st.nextToken();
			int longititude = Integer.parseInt(st.nextToken());
			int latitude = Integer.parseInt(st.nextToken());
			location[i] = new Location(longititude, latitude);
			cityMap.put(city, location[i]);
		}
		Set<String> key = cityMap.keySet();
		Iterator<String> it = key.iterator();
		System.out.println("------------------------");
		while(it.hasNext()) {
			String city = it.next();
			Location loca = cityMap.get(city);
			System.out.println(city+" "+loca.getLongitude()+" "+loca.getLatitude());
		}
		System.out.println("------------------------");
		while(true) {
			System.out.print("도시 이름>> ");
			String city = scan.next();
			if(city.equals("그만")) break;
			if(cityMap.get(city)==null) System.out.println(city+"는 없습니다.");
			else System.out.println(city+" "+cityMap.get(city).getLongitude()+" "+cityMap.get(city).getLatitude());
		}
	}
}

class Location{
	int longitude; 
	int latitude;
	
	public Location(int longitude, int latitude) {
		this.longitude = longitude;
		this.latitude = latitude;
	}
	public int getLongitude() {
		return longitude;
	}
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
	public int getLatitude() {
		return latitude;
	}
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}
}
