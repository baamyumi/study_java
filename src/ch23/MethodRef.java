package ch23;

import java.util.function.Predicate;

public class MethodRef {

	static int[] arAge = {29,30,34,32,30,31,28,31,29,30};
	
	public static void main(String[] args) {
		
		/**
		 * 메서드 참조/메서드레퍼런스
		 * 클래스::정적 메서드
		 * 클래스::인스턴스 메서드
		 * 객체::인스턴스 메서드
		 */
		System.out.println("over = "+ count(MethodRef::isAgeOver));
		System.out.println("under = "+ count(MethodRef::isAgeUnder));

	}
	
	static boolean isAgeOver(int age) {
		return (age >  30);
	}
	
	static boolean isAgeUnder(int age) {
		return (age < 30);
	}
	
	static int count(Predicate<Integer> op) {
		int num = 0;
		for(int i = 0; i<arAge.length; i++) {
			if (op.test(arAge[i])) num++;
		}
		return num;
	}

}
