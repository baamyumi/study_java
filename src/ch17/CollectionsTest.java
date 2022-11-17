package ch17;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsTest {

	public static void main(String[] args) {
		
		//Collections 클래스를 사용하려면 Comparable한 타입만 가능
		
		ArrayList<String> arName = new ArrayList<String>();
		arName.add("장보고");
		arName.add("김유신");
		arName.add("강감찬");
		arName.add("을지문덕");
		
		for(String s : arName) {
			System.out.printf(s + " ");
		}
		System.out.println();
		
		Collections.sort(arName); //정렬
		Collections.reverse(arName); //역순정렬
		for(String s : arName) {
			System.out.printf(s + " ");
		}
		System.out.println();
		
		Collections.shuffle(arName);  //무작위로 섞기
		for(String s : arName) {
			System.out.printf(s + " ");
		}
	}

}
