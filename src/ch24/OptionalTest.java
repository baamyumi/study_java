package ch24;

import java.util.*;

class Notebook{
	String model;
	public Notebook(String model) {
		this.model = model;
	}
}

class Human{
	int age;
	String name;
	Optional<Notebook> book;
	
	Human(int age, String name, String model){
		if(model == null || model.length() ==0){
			book = Optional.empty();
		} else {
			book = Optional.of(new Notebook(model));
		}
		this.age = age;
		this.name = name;
	}
	
}

public class OptionalTest {

	public static void main(String[] args) {
		/**
		 * Optinal<T> : T타입의 객체를 가진 상태와 아무것도 갖지 않은 상태(null)를 표현하는 컨테이너
		 * Optional.empty : 빈상태로 생성
		 * Optional.of : 객체를 저장한 상태로 초기화
		 * Optional.ofNullable : 인수로 전달한 값을 저장하되 null이면 빈 상태로 초기화
		 */
		Human kim = new Human(29, "김상형", "레노보");
		useBook(kim);
		Human lee = new Human(44,"이승우",null);
		useBook(lee);
	

	}
	
	static void useBook(Human human) {
		/**
		 * isPresent() : 객체가 있는지 조사 -> true 이면 객체가 있는것
		 * get() : 객체를 읽어온다.
		 * ifPresesnt(람다식) : 객체가 있을때 람다식을 실행하며, 비어있으면 아무것도 하지 않는다.
		 */
		//[1] isPresent + get 이용한 방법
		if(human.book.isPresent()) {
			String model = human.book.get().model;
			System.out.println("내 노트북: " + model);
		} else {
			System.out.println("노트북이 없다.");
		}
		
		//[2] ifPresent 이용한 방법
		human.book.ifPresent(b -> System.out.println("내 노트북 :" + b.model));
		
		/**
		 * orElse(T other) : 비어있는 경우 대체 객체를 리턴
		 * orElseGet(람다식) : 객체를 생성하는 람다식을 전달하여 불필요할 경우 객체를 생성하지 않는다.
		 * orElseThrow : 객체가 비어 있을 때 예외를 던진다.
		 */
		Notebook book = human.book.orElse(new Notebook("싸구려"));
		
		Notebook book2 = human.book.orElseGet(() -> new Notebook("싸구려"));
		
		/**
		 * filter : 조건을 만족하면 객체를 가진 Optional 객체를 리턴, 그렇지않으면 빈객체 리턴
		 */
		human.book.filter(b-> b.model.indexOf("레노버") != -1)
			.ifPresent(b -> System.out.println("레노버 제품입니다."));
		
		
		/**
		 * map : 다른 타입의 값을 추출하여 형태를 변경, 빈객체이면 리턴값도 빈 객체이다
		 */
		String model = human.book.map(b-> b.model).orElse("이름 없음");
		System.out.println(model);
	}

}
