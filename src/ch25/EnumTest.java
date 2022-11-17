package ch25;

enum Direction{EAST, WEST, SOUTH, NORTH};
enum Yoil{SUN, MON, TUE, WED, THR, FRI, SAT};

public class EnumTest {

	public static void main(String[] args) {
		Direction origin = Direction.EAST;
		origin = Direction.SOUTH;
		if(origin == Direction.WEST) {}
		if(origin == Direction.NORTH) {}
		
		Direction[] ways = Direction.values();
		for(Direction way : ways) {
			System.out.print(way + ", ");
		}
		System.out.println("중 하나를 선택하십시오.");

		Direction origin2 = Direction.valueOf("EAST");
		System.out.println(origin2);
	}

}
