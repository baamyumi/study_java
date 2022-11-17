package ch16;

import java.util.Random;

public class MathTest {

	public static void main(String[] args) {
		/* 난수 생성방법 2가지 */
		/* 1. Math클래스의 random() 메서드 -> 적당히 곱하고 더해서 원하는 범위의 난수를 얻는다. */
		System.out.println(Math.random());
		
		/* 2. Random 클래스 */
		Random R = new Random();
		for(int i=0; i<5; i++) {
			System.out.println(R.nextInt(10)); //0 ~ 10 미만의 정수 난수
		}
		
		System.out.println(getRandom(5, 10));

	}
	
	/* 일정 범위안의 난수를 얻는 메서드 */
	static int getRandom(int a, int b) {
		return (int)(Math.random() * (b-a)) + a;
	}

}
