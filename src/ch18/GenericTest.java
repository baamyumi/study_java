package ch18;

import java.util.ArrayList;

class Box<T>{
	T value;
	Box(T value){
		this.value = value;
	}
	T get() {
		return value;
	}
	void set(T value) {
		this.value = value;
	}
}


public class GenericTest {
	
	static <T> void dumpArray(ArrayList<T> ar) {
		for (T a : ar) {
			System.out.println(a);
		}
	}
	
	public static void main(String[] args) {
	
		Box<Integer> bi = new Box<Integer>(1234);
		int biv = bi.get();
		System.out.println(biv);
		
		Box<Double> bd = new Box<Double>(56.78);
		double bdv = bd.get();
		System.out.println(bdv);
		
		System.out.println(bi.getClass() == bd.getClass());	//제네릭 타입은 딱 한번만 컴파일 하여 하나의 클래스 파일로 저장한다.
		
		//제네릭매서드
		ArrayList<String> yoil = new ArrayList<String>();
		yoil.add("월요일");
		yoil.add("목요일");
		GenericTest.<String>dumpArray(yoil);

		ArrayList<Integer> score = new ArrayList<Integer>();
		score.add(81);
		score.add(100);
		GenericTest.<Integer>dumpArray(score);

	}

}
