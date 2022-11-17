package ch23;

public class FuncInterface {

	/***
	 * 함수형 인터페이스 : 1개의 추상 메서드를 갖고 있는 인터페이스
	 * 
	 * 
	 * 1. Runnable -> 파라미터 없고 리턴값도 없는 경우 / run()
	 * 2. Consumer<T> -> 파라미터 있고 리턴값 없는 경우 / accept(T t)
	 * 3. Supplier<T> -> 파라미터 없고 리턴값 있는 경우 / get() 
	 * 4. Function<T,R> -> 파라미터 있고 리턴값 있는 경우 / apply(T t) / 데이터 맵핑용, int받고 String반환같은
	 * 5. Operator<T> -> 파라미터 있고 리턴값 있는 경우 / 연산용도, 임의의 타입 전달하고 임의의 타입 반환
	 * 6. Predicate<T> -> 파라미터 있고 리턴값(boolean) 있는 경우 / test(T t) / 임의의 타입 받고 boolean형 반환

	 */
	public static void main(String[] args) {
		/**
		 * 함수형 인터페이스를 람다식으로 구현하기1
		 */
		PlusOne1 po = i -> i+1;
		System.out.println("result = " + po.plus(5));

		
		/**
		 * 함수형 인터페이스를 람다식으로 구현하기2 : 람다식을 인수로 넘기기
		 */
		print(5, i -> i+1);
		print(5, i -> i-1);
		print(5, i -> i*1);
		
		FindMax fm = (a,b) -> a > b ? a: b;
		System.out.println("result = " + fm.max(3, 5));
		
		GetTime gt = () -> System.currentTimeMillis();
		System.out.println("result = " +  gt.systemtime());
	}
	
	static void print(int i, PlusOne1 po) {
		System.out.println("result = " +  po.plus(i));
	}

}

interface PlusOne1{
	int plus(int i);
}

interface FindMax{
	int max(int a, int b);
}

interface GetTime{
	long systemtime();
}
