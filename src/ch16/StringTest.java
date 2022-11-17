package ch16;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StringTest {

	public static void main(String[] args) {
		String str = "아름다운 우리나라";
		System.out.println(str.length()); //길이
		System.out.println(str.isEmpty()); //문자열이 비어있는 지 확인 -> length() == 0 체크보다 빠르다.
		System.out.println(str.charAt(2)); //두번째 문자

		String str1 = "KOREA";
		String str2 = "korea";
		
		System.out.println(str1.equals(str2));
		System.out.println(str1.equalsIgnoreCase(str2));//대소문자 무시
		
		String apple = "apple";
		String orange = "orange";
		int Result = apple.compareTo(orange);	//사전순 정렬 전후관계 : 음수이면 apple이 더 앞, 양수이면 orange가 더 앞
		System.out.println(Result);
		
		/* 문자열 위치 검색 */
		String search = "String Search Method of String Class";
		System.out.println(search.indexOf('t')); //앞에서부터
		System.out.println(search.lastIndexOf('t')); //뒤에서부터
		System.out.println(search.indexOf('z')); //검색해서 없으면 -1 반환
		System.out.println(search.indexOf("String"));
		System.out.println(search.lastIndexOf("String"));
		
		String[] files = {
			"111.jpg",
			"222.png",
			"333.avi",
			"444.jpg",
			"555.gif"
		};
		
		for(String s : files) {
			if (s.endsWith(".jpg")) {  // startsWith
				System.out.println(s);
			}
		}
		
		/* 변경 */
		String str3 = "Bae Yu Mi";
		System.out.println(str3.toLowerCase());
		System.out.println(str3.toUpperCase());
		
		String str4 = "       Bae Yu Mi        ";
		System.out.println(str4.trim()); //앞뒤 공백제거
		System.out.println(str4.trim().concat(" HaHa")); //문자열 연결 : + 쓰는거랑 같음
		System.out.println(str4.replace("Bae", "Baam"));
		System.out.println(str4.trim().substring(4,9));
		
		String city = "서울,대전,대구,부산";
		String[] token = city.split(",");
		
		for(String s : token) {
			System.out.println(s);
		}
		
		List<String> subway = Arrays.asList("서울역","남영","용산","노량진");
		System.out.println(String.join("->", subway));
		
		
		/* StringBuffer */
		long start = System.currentTimeMillis();
		StringBuffer strb = new StringBuffer();
		for(int i = 0;i <1000;i++) {
			for(char ch = 'A';ch <= 'z';ch++) {
				strb.append(ch);  // + 연산자 대신 append 사용
			}
			strb.append('\n');
		}
		System.out.println(strb);
		System.out.println((System.currentTimeMillis() - start)/1000.0 + "초");
		// > 문자열을 조작할때는 String보다 StringBuffer가 훨신 속도에서 유리하다.
		
		/* repeat */
		String home = "대한민국";
		String hurrah = "만세! ";
		System.out.println(home + hurrah.repeat(3));
		
		/* isBlank, isEmpty */
		String text = "\t \n";
		System.out.println("isEmpty : " + text.isEmpty());
		System.out.println("isBlank : " + text.isBlank());
		
		/* lines : 개행 문자를 기준으로 분할하열 배열로 만든다 */
		String text1 = "apple\norange\nbanana";
		Stream<String> fruits = text1.lines();
		fruits.forEach(System.out::println);
		
		
	}

}
