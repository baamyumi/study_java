package ch15;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Human{
	int age;
	String name;
	
	Human(int age, String name){
		this.age = age;
		this.name = name;
	}
	
	void intro() {
		System.out.println(age+"살 "+ name +"입니다.");
	}
}

public class GetClassTest {

	public static void main(String[] args) {
		Human human = new Human(29, "홍길동");
		
		Class cls = human.getClass();
		System.out.println("클래스이름: "+ cls.getName());
		System.out.println("슈퍼 클래스이름= "+ cls.getSuperclass().getName());
		
		System.out.println("필드: ");
		Field[] fields = cls.getDeclaredFields();
		for(Field f : fields) {
			System.out.println(f.getName() + " ");
		}
		
		System.out.println();
		System.out.println("메서드 : ");
		Method methods[] = cls.getDeclaredMethods();
		for(Method m : methods) {
			System.out.println(m.getName()+" ");
		}

	}

}
