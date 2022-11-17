package ch23;

import java.util.function.Predicate;

class Human{
	int age;
	String name;
	Human(int age, String name){
		this.age = age;
		this.name = name;
	}
}

public class PredicateTest {

	static Human[] members = {
			new Human(21, "김상형"),
			new Human(14, "김한슬"),
			new Human(21, "문한올"),
			new Human(66, "구홍녀")
	};
	
	public static void main(String[] args) {
		/**
		 * 대표적인 함수형 인터페이스 Predicate : 파라미터가 있고 리턴값(Boolean)이 있는 경우
		 */
		
		//Predicate 타입으로 람다식을 전달한다.
		listHuman("성인", h -> h.age >= 19);	
		listHuman("김가", h -> h.name.startsWith("김"));
		listHuman("미성년 김가", h -> h.name.startsWith("김") && h.age < 19);
		
	}
	
	static void listHuman(String cap, Predicate<Human> pred) {
		System.out.print(cap + "인 사람 목록 : ");
		for(Human h : members) {
			if(pred.test(h)) {
				System.out.print(h.name + " ");
			}
		}
		System.out.println();
	}

}
