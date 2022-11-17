package ch23;

import java.util.function.Predicate;

public class LibInterface {
	static int[] arAge = {29,30,34,32,30,31,28,31,29,30};
	
	public static void main(String[] args) {
		System.out.println("over = " + count(a -> a > 30));
		System.out.println("28~ 30 범위 = " + count(a -> a >= 28 && a <= 30));
	}
	
	static int count(Predicate<Integer> op) {
		int num = 0;
		for(int i = 0; i < arAge.length; i++) {
			if(op.test(arAge[i])) num++;
		}
		return num;
	}
}
