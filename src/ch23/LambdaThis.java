package ch23;

public class LambdaThis {

	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.method();

	}

}

class Outer{
	void method() {
		//지역 클래스에서의 this
		class PlusOneImpl implements PlusOne3{

			@Override
			public int plus(int i) {
				System.out.println(this);
				return i+1;
			}
			
		}
		PlusOne3 po = new PlusOneImpl();
		System.out.println("result = " + po.plus(5));
		
		//람다식에서의 this
		PlusOne3 po2 = i -> {
			System.out.println(this);
			return i +1;
		};
		System.out.println("result =" +  po2.plus(5));
	}
}

/**
 * 함수형 인터페이스는 추상메서드만 가지며 두개 이상의 메서드를 가져서는 안된다. 이를 명확히 하기위해 어노테이션을 붙인다.
 * 자바는 자주 사용할 함수형 인터페이스를 java.util.function 패키지에 정의해 놓았다.
 * 패키지 내부의 함수형 인터페이스에는 모두 @FunctionalInterface가 붙여져있다.
 */
@FunctionalInterface  
interface PlusOne3{
	int plus(int i);
}