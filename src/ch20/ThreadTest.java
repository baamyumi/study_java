package ch20;

public class ThreadTest {

	public static void main(String[] args) {
		PrintThread thread = new PrintThread();
		thread.start();
		
		PrintRunnable print = new PrintRunnable();
		Thread worker = new Thread(print);
		worker.start();
		
		Thread worker2 = new Thread(new Runnable() {	//[3]익명 내부클래스 사용
			public void run() {
				for(int num = 0; num < 30; num++) {
					System.out.print("W");
					try { Thread.sleep(100); } catch (InterruptedException e) {;}
				}
			}
		});
		worker2.start();

		for(int num = 0; num < 30; num++) {
			System.out.print("O");
			try { Thread.sleep(200); } catch (InterruptedException e) {;}
		}

	}
	

}

class PrintThread extends Thread{		//[1]Thread를 상속받아 사용
	public void run() {
		for(int num = 0; num < 30; num++) {
			System.out.print("X");
			try { Thread.sleep(100); } catch (InterruptedException e) {;}
		}
	}
}

class PrintRunnable implements Runnable{	//[2]Runnable 인터페이스를 구현해서 사용
	public void run() {
		for(int num = 0; num < 30; num++) {
			System.out.print("Y");
			try { Thread.sleep(100); } catch (InterruptedException e) {;}
		}
	}
}
