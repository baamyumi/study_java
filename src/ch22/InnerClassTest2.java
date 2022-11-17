package ch22;

class Human2{
	int field;
	static int staticField;
	
	//내부 클래스는 외부의 모든 멤버를 액세스 할 수 있다
	class Name{
		void method() {
			field = 0;
			staticField = 0;
		}
	}
	
	//정적 내부 클래스는 외부의 정적 필드만 액세스할 수 있다
	static class StaticName{
		void method() {
			//field = 0;	//에러
			staticField = 0;
		}
	}
	
	//비정적 메서드는 내부, 정적 내무 클래스 모두 액세스할 수 있다.
	void method() {
		Name n = new Name();
		StaticName sn = new StaticName();
	}
	
	//정적 메서드는 내부 정적 클래스만 액세스할 수 있다
	static void staticmethod() {
		//Name n = new Name();	//에러
		StaticName sn = new StaticName();
	}
}

public class InnerClassTest2 {

	public static void main(String[] args) {
		

	}

}
