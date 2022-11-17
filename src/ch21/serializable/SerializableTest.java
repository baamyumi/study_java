package ch21.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Car implements Serializable{	//Serializable 상속받으면 직렬화 가능
	String name;
	String color;
	transient boolean gasoline; //transient를 붙이면 직렬화의 대상에서 제외된다.
	static int count = 0;	//정적 필드도 직렬화의 대상에서 제외.
	
	Car(String name, String color, boolean gasoline){
		this.name = name;
		this.color = color;
		this.gasoline = gasoline;
		count++;
	}
	
	void outInfo() {	//생성자나 메서드도 직렬화 대상에서 제외
		System.out.printf("이름 = %s, 색상 = %s, 연료 = %s\n", name, color, gasoline ? "휘발유" : "경유" );
	}
}

public class SerializableTest {

	public static void main(String[] args) {
		/**
		 * 직렬화 - 정보를 일렬(스트림 형태)로 나열
		 */
		Car pride = new Car("프라이드", "파랑", true);
		
		//파일로 출력
		try (
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("pride.car"));
		){
			out.writeObject(pride);
			System.out.println("파일로 기록");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//파일로부터 입력
		try (
				ObjectInputStream in = new ObjectInputStream(new FileInputStream("pride.car"));
		){
			Car pride2 = (Car)in.readObject();
			in.close();
			pride2.outInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
