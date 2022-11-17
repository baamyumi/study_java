package ch24;

import java.io.IOException;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

enum Cont {ASIA, AFRICA, AMERICA, EUROPE}

class Country{
	String name;
	Cont cont;
	int popu;
	boolean oecd;
	
	Country(String name, Cont cont, int popu, boolean oecd){
		this.name = name;
		this.cont = cont;
		this.popu = popu;
		this.oecd = oecd;
	}
	
	String getName() {return name;}
	Cont getCont() {return cont;}
	int getPopu() {return popu;}
	boolean isOecd() {return oecd;}
	public String toString() {
		return name + " in" + cont + " : " + popu + (oecd ? "(0)":"");
	}
}

class Data{
	static List<Country> nara = Arrays.asList(
			new Country("한국",Cont.ASIA, 49, true),
			new Country("미국",Cont.AMERICA, 318, true),
			new Country("중국",Cont.ASIA, 1355, false),
			new Country("캐나다",Cont.AMERICA, 34, true)
		);
}

public class BasicStream2 {

	public static void main(String[] args) throws IOException {

		/**
		 * 중간연산
		 */
		//filter : boolean을 리턴한다. 조건이 맞는 것만 골라낸다.
		Data.nara.stream()
			.filter(c->c.oecd) // .filter(Country::isOeced)
			.forEach(System.out::println);
		
		//map : 요소에서 일부를 추출 및 조합하여 다른 형태의 스트림을 만들다. 요소끼리 일대일로 대응되는 변환을하며 요소의 형태만 바뀌고 개수는 변함없다.
		Data.nara.stream()
			.map(c -> c.name)	// .map(Country::getName)
			.forEach(c-> System.out.print(c + " "));
		
		Data.nara.stream()
		.map(c -> c.cont)
		.distinct()
		.forEach(System.out::println);
		

		//limit, skip :  범위 제한
		Data.nara.stream()
			.limit(2)	//앞 두개만 제한해서 새로운 스트림생성, 나머지는 잘라낸다 
			.forEach(System.out::println);
		
		Data.nara.stream()
			.skip(3)	//3개를 건너뛰고 남은것만 출력한다.
			.forEach(System.out::println);
		
		//규칙에따라 스트림을 계속 생성하는 무한 스트림에는 limit가 반드시 필요하다
		Stream.iterate(2, a -> a*2)
			.limit(10)
			.forEach(n -> System.out.print(n + " "));
		
		//sorted : 정렬 - Comparable한 객제만 정렬이 가능하다. sorted를 사용하려면 Comparable 인터페스를 구현해야한다.
		Data.nara.stream()
			.map(Country::getName)
			.sorted()
			.forEach(n -> System.out.print(n + " "));
		
		/**
		 * 최종연산
		 */
		//count
		System.out.println(Data.nara.stream().count());
		
		//anyMatch, allMatch, noneMatch
		System.out.println(Data.nara.stream().anyMatch(c -> c.cont == Cont.AMERICA));	//하나라도 매치되는것이 있는지
		System.out.println(Data.nara.stream().allMatch(c -> c.popu > 300));	//모두 매치되는지
		System.out.println(Data.nara.stream().noneMatch(c -> c.popu < 30));	//매치되는것이 없는지
		
		//max, min
		Optional<Integer> max = Data.nara.stream()
				.map(Country::getPopu)
				.max((a,b) -> a-b);
		System.out.println(max.get());
		
		Optional<Integer> min = Data.nara.stream()
				.map(Country::getPopu)
				.max((a,b) -> a-b);
		System.out.println(min.get());
		
		
		//reduce : 스트림의 집합적인 값으로부터 하나의 최종값을 도출하는 연산
		// T reduce(T identity, BinaryOperator<T> accumulator)
		// 첫번째 인수 - 초깃값 / 두번째 인수 - 누적자
		int total = Data.nara.stream()
				.map(Country::getPopu)
				.reduce(0, (i,j) -> i+j); //초깃값이 필요하지 않다면 = .reduce(Integer::sum)
		System.out.println(total);
		
		//=> map이 정수형인 popu를 integer로 박싱해서 스트림에 저장하고 reduce로 정수값을 언박싱해서 읽으면 성능에 불리하다.
		//=> 그래서 기본형에 대한 스트림을 사용한다.
		// mapToInt / mapToLong / mapToDouble
		int total2 = Data.nara.stream()
				.mapToInt(Country::getPopu)
				.sum();
		System.out.println(total2);
		
		
		/**
		 * IntStream range / IntStream rangeClosed  : 일정한 범위의 정수 스트림 생성 (rangeClosed는 끝값도 범위에 포함)
		 */
		int total3 = IntStream.rangeClosed(1, 100).sum();
		System.out.println(total3);
		
		/**
		 * collect : 스트림으로부터 자료를 추출 및 가공하여 다른 형태로 변형하는 최종 연산
		 * 
		 */
		//Collectors toList() : T를 받아 List<T>객체를 생성한다.
		//Collectors toSet() : 중복을 제거한 Set<T>객체를 생성한다.
		List<String> names = Data.nara.stream()
					.map(Country::getName)
					.collect(Collectors.toList());
		for(String s : names) {
			System.out.print(s +" ");
		}
		
		//Collectors joining(char) : 모든 요소를 문자열 하나로 조립하여 리턴한다.
		String nameStr = Data.nara.stream()
				.map(Country::getName)
				.collect(Collectors.joining(", "));
		System.out.println(nameStr);
		
		//Collectors counting() : 개수
		//Collectors maxBy()/minBy() : 최댓값/최솟값
		long num = Data.nara.stream()
			.collect(Collectors.counting());
		System.out.println(num);
		Optional<Integer> max1 = Data.nara.stream()
				.map(Country::getPopu)
				.collect(Collectors.maxBy(Integer::compare));
		System.out.println(max1.get());
		Optional<Integer> min1 = Data.nara.stream()
				.map(Country::getPopu)
				.collect(Collectors.minBy(Integer::compare));
		System.out.println(min1.get());
		
		//Collectors summingInt()/averagingInt() : 합계/평균
		int sum = Data.nara.stream()
				.collect(Collectors.summingInt(Country::getPopu));
		System.out.println(sum);
		double avg = Data.nara.stream()
				.collect(Collectors.averagingDouble(Country::getPopu));
		System.out.println(avg);
		
		//Collector summarizingInt()  합계, 최댓값, 최솟값 평균을 한번에 구한다.
		IntSummaryStatistics summary = Data.nara.stream()
				.collect(Collectors.summarizingInt(Country::getPopu));
		System.out.println(summary);
		
		//Collectors reducing() : 리덕션 연산 수행
		int sum3 = Data.nara.stream()
				.collect(Collectors.reducing(0, Country::getPopu, Integer::sum));
		System.out.println(sum3);
		
		//Collectors groupingBy() : 인수로 그룹핑에 사용할 키를 리턴하는 함수를 전달한다.
		Map<Cont, List<Country>> map = Data.nara.stream()
				.collect(Collectors.groupingBy(Country::getCont));
		
		Set<Cont> keys = map.keySet();
		Iterator<Cont> key = keys.iterator();
		while(key.hasNext()) {
			Cont cont = key.next();
			System.out.println(cont + ":");
			List<Country> n = map.get(cont);
			for(Country c: n) {
				System.out.println(c.name + " ");
			}
			System.out.println();
		}
		
		//Collector partitioningBy() : 서술자를 인수로 취해 이값의 진위 여부에 따라 스트림의 요소를 분할한다.
		Map<Boolean, List<Country>> map2 = Data.nara.stream()
				.collect(Collectors.groupingBy(Country::isOecd));
		Set<Boolean> keys2 = map2.keySet();
		Iterator<Boolean> key2 = keys2.iterator();
		while(key2.hasNext()) {
			Boolean oecd = key2.next();
			System.out.println(oecd + ":");
			List<Country> n = map.get(oecd);
			for(Country c: n) {
				System.out.println(c.name + " ");
			}
			System.out.println();
		}
		
		
		
	}
}
