package ch24;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class BasicStream {

	public static void main(String[] args) throws IOException {

		Stream<Integer> stream = Stream.of(3,1,4,1,5);
		stream.forEach(System.out::print);
		//->
		Stream.of(3,1,4,1,5).forEach(System.out::print);
		
		System.out.println();
		
		//배열로 스트림 연산
		String[] arr = {"한국","중국","일본"};
		Stream<String> stream2 = Arrays.stream(arr);
		stream2.forEach(System.out::print);
		
		System.out.println();
		
		//Math.random 메서드를 호출하여 난수로 채워진 스트림 생성
		Stream.generate(Math::random)
			.limit(5)
			.forEach(System.out::println);
		
		//iterate : 시작값와 입력갓을 받아 다음 값을 생성하는 함수를 전달한다.
		Stream.iterate(1, a -> a+1)
			.limit(5)
			.forEach(System.out::print);
		
		//File.lines : 텍스트 파일의 각 줄을 읽어 문자열 스트림 생성
		//Stream<String> lines = Files.lines(Paths.get("테스트.txt"));
		//lines.forEach(System.out::println);
		//lines.close();
		
		//File.list : 지정한 경로의 파일목록을 스트림으로 생성
		Stream<Path> list = Files.list(Paths.get("c:/"));
		list.forEach(p->System.out.println(p.getFileName()));
		list.close();
		

	}

}
