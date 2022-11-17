package ch25;

enum Direction1{
	EAST("동"), WEST("서"), SOUTH("남"), NORTH("북");	//연관값 :  연관값은 개수에 상관없이 여러 개 붙일 수 있다.
	final private String hanDir;
	private Direction1(String han) {
		hanDir = han;
	}
	String getHanDir() {
		return hanDir;
	}
}

public class EnumTest2 {

	public static void main(String[] args) {

		Direction1 origin = Direction1.EAST;
		System.out.println(origin.getHanDir() + "쪽으로 갑니다.");
	}

}
