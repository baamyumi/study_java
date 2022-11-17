package ch23;

import java.util.function.BiFunction;

class Human2 {
	int age;
	String name;
	Human2(int age, String name){
		this.age =age;
		this.name = name;
	}
}

public class NewRef {

	public static void main(String[] args) {
		// ::new  생성자 메서드 레퍼런스 표기
		BiFunction<Integer, String, Human> creator = Human::new;
		// Human::new == (i, s) -> new Human(i,s)
		Human kim = creator.apply(21, "김상헝");
		System.out.println(kim.age + "세 "+ kim.name);
	}

}
