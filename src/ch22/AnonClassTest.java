package ch22;

class Human3 {
	void intro() {
		System.out.println("나는 사람입니다.");
	}
}

interface Human4 {
	void intro();
}

public class AnonClassTest {

	public static void main(String[] args) {
		
		/**
		 * 익명 클래스
		 */
		Human3 lee = new Human3(){
			void intro() {
				System.out.println("나는 학생입니다");
			}
		};
		lee.intro();
		
		/**
		 * 익명 클래스로 인터페이스 구현
		 */
		Human4 kim = new Human4() {
			public void intro() {
				System.out.println("나는 휴먼4입니다");
			}
		};
		kim.intro();
	}

}
