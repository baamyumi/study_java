package ch20;

public class ThreadTest2 {

	public static void main(String[] args) {
		PrintThread1 worker1 = new PrintThread1();
		PrintThread2 worker2 = new PrintThread2();
		worker1.start();
		worker2.setPriority(10);//우선 순위 지정
		worker2.start();

	}
	

}

class PrintThread1 extends Thread{
	public void run() {
		double sum = 0;
		for(int i = 0; i< 10000000; i++) {
			sum += Math.cos(i);
		}
		System.out.println("cos =" + sum);
	}
}

class PrintThread2 extends Thread{
	public void run() {
		double sum = 0;
		for(int i = 0; i< 10000000; i++) {
			sum += Math.sin(i);
		}
		System.out.println("sin =" + sum);
	}
}