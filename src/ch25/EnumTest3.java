package ch25;

enum JavaType{
	SHORT("짧은 정수형", 2), INT("정수형", 4), DOUBLE("실수형", 8);
	final private String typeName;
	final private int length;
	
	JavaType(String name, int bytenum) {
		typeName = name;
		length = bytenum;
	}
	
	String getName() { return typeName;}
	int getLength() { return length; }
	
}

public class EnumTest3 {

	public static void main(String[] args) {
		
		JavaType Type;
		Type = JavaType.INT;
		
		System.out.println("타입: " + Type + " 이름: " + Type.getName() + " 길이 : " + Type.getLength());

	}

}
