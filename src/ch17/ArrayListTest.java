package ch17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		
		ArrayList<String> arName = new ArrayList<String>();
		arName.add("전두환");
		arName.add("김영삼");
		arName.add("김대중");
		arName.add(1,"노태우"); //(index, element)
		for(String s : arName) {
			System.out.println(s);
		}
		
		System.out.println("==========");
		arName.remove(2);
		arName.set(2, "원더걸스");
		for(String s : arName) {
			System.out.println(s);
		}
		if (arName.indexOf("노태우") != -1) {
			System.out.println("있다");
		}
		else {
			System.out.println("없다");
		}
		
		/***
		 * ArrayList 벌크연산
		 */
		ArrayList<Integer> arNum = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		ArrayList<Integer> arNum2 = new ArrayList<Integer>(Arrays.asList(2,3));
		
		/* 합집함 */
		ArrayList<Integer> arNumAdd = new ArrayList<Integer>(arNum);
		arNumAdd.addAll(arNum2);
		for(Integer i : arNumAdd) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		/* 차집함 */
		ArrayList<Integer> arNumRemove = new ArrayList<Integer>(arNum);
		arNumRemove.removeAll(arNum2);
		for(Integer i : arNumRemove) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		/* 교집함 */
		ArrayList<Integer> arNumRetain = new ArrayList<Integer>(arNum);
		arNumRetain.retainAll(arNum2);
		for(Integer i : arNumRetain) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		/* 부분집함 확인 */
		if (arNum.containsAll(arNum2)) {
			System.out.println("부분집합임");
		} else {
			System.out.println("부분집합 아님");
		}
		
		/***
		 * ArrayList -> 배열
		 */
		Integer[] ar = new Integer[arNum.size()];
		arNum.toArray(ar);
		for(Integer i : ar) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		/***
		 * 뷰
		 */
		List<Integer> sub = arNum.subList(1, 4); //뷰 생성
		for(Integer i : sub) {
			System.out.printf(i +" ");
		}
		System.out.println();
		
		arNum.set(2, 100); //원본 요소 값을 변경하면 뷰의 값도 변경된다
		for(Integer i : sub) {
			System.out.printf(i +" ");
		}
		System.out.println();
		
		sub.set(1, 200); //뷰의 요소 값을 변경하면 원본 값도 변경된다
		for(Integer i : sub) {
			System.out.printf(i +" ");
		}
		System.out.println();
		
		sub.clear(); //뷰의 요소를 제거하면 원본의 요소도 제거된다
		for(Integer i : arNum) {
			System.out.printf(i +" ");
		}
		System.out.println();
		//원본 요소값이 변경되는건 상관없지만 원본의 구조가 변경되면 뷰는 무효가 된다.
		//무효가 된 뷰를 참조하면 ConcurrentModificationException 예외가 발생한다.
	}

}
