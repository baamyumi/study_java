package ch17;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

	public static void main(String[] args) {
		
		//ArrayList는 읽기,쓰기가 빠르고 LinkedList는 삽입,삭제가 빠르다
		
		List<String> arName = new LinkedList<String>();
		//실제 프로젝트에서는 필요에따라 컬렉션(ArrayList, LinkedList)을 바꿔가며 쓴다. 그래서 실무에서는 컬렉션 객체는 상위 인터페이스 타입으로 선언할 것을 권장한다.
		arName.add("전두환");
		arName.add("김영삼");
		arName.add("김대중");
		arName.add(1,"노태우"); //(index, element)
		
		/* LinkedList를 순회하는 방법 [1] 단순반복문 */
		for(String s : arName) {
			System.out.println(s);
		}
		
		/* LinkedList를 순회하는 방법 [2] Iterator */
		//Iterator가 현재 위치를 기억하기 때문에 단순 for 루프 순회에 비해 속도가 훨씬 빠르다
		Iterator<String> it = arName.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		
		
	}

}
