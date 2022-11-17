package ch17;

import java.util.LinkedList;
import java.util.Stack;

public class StackQueueTest {

	public static void main(String[] args) {
		
		/***
		 * Stack
		 */
		Stack<String> stack = new Stack<String>();
		stack.push("호랑이");
		stack.push("사자");
		stack.push("코끼리");
		
		while(stack.empty() == false){
			System.out.println(stack.pop());  //LIFO
		}

		System.out.println("=================");
		
		/***
		 * Queue : 큐는 인터페이스는 있지만 구현 클래스는 없다. 여기서는 LinkedList를 이용해서 구현한다.
		 */
		LinkedList<String> queue = new LinkedList<String>();
		queue.offer("호랑이");
		queue.offer("사자");
		queue.offer("코끼리");
		
		while(!queue.isEmpty()){
			System.out.println(queue.poll());	//FIFO
		}
	}

}
