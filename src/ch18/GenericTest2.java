package ch18;

import java.util.ArrayList;

class Human {
	void intro() {
		System.out.println("나 사람");
	}
}
class Student extends Human{
	void intro() {
		System.out.println("나 학생");
	}
}

class Box2<T>{
	T value;
	Box2(T value){
		this.value = value;
	}
	T get() {
		return value;
	}
	void set(T value) {
		this.value = value;
	}
}

public class GenericTest2 {

	static<T extends Comparable<T>> T max(T a, T b) {
		//T가 적용되는 범위가 너무 광범위하기 때문에, 비교 연사자를 사용하려면 비교가능한 타입으로 T를 제한해야한다.
		if (a.compareTo(b) > 0) {
			return a;
		}
		else {
			return b;
		}
	}
	
	static void printMan(Box2<? extends Human> box) {
		box.get().intro();
	}
	
	public static void main(String[] args) {
		int result = GenericTest2.max(1,2);
		System.out.println(result);
		
		
		/***
		 * 컬렉션으로 테스트
		 */
		ArrayList<Human> ah = new ArrayList<Human>();
		ArrayList<Student> as = new ArrayList<Student>();
		
		ah.add(new Human());
		as.add(new Student());
		ah.add(new Student());	//적상 작동 => Human과 Student는 상속관계이기 때문에
		
		// ah = as; //에러 발생 => ArrayList<Human>와 ArrayList<Student>는 상속 관계가 아니다.
		as.add(new Student());
		Student k = as.get(1);
		
		
		/***
		 * 와일드 카드 사용
		 */
		Human h = new Human();
		Box2<Human> bh = new Box2<Human>(h);
		printMan(bh);
		
		Student s = new Student();
		Box2<Student> bs = new Box2<Student>(s);
		printMan(bs);
	}

}
