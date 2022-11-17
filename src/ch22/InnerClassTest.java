package ch22;

class Human{
	int age;
	Name name;
	
	class Name{
		String first;
		String family;
		
		Name(String first, String family){
			this.first = first;
			this.family = family;
		}
		
		void outAge() {
			System.out.println("저는 " +  age + "살입니다.");
		}
	}
	
	Human(int age, String first, String family){
		this.age = age;
		this.name = new Name(first, family);
	}
	
	void intro() {
		System.out.println("Hi." + age + "살 "+ name.family + name.first + "입니다.");
	}
}

public class InnerClassTest {

	public static void main(String[] args) {
		Human h = new Human(14, "길동", "홍");
		h.intro();
		h.name.outAge();

	}

}
