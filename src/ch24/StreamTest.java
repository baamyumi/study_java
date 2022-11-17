package ch24;

import java.util.Arrays;
import java.util.List;

class Student {

    private String name;
    private boolean isMale; // 성별
    private int hak; // 학년
    private int ban; // 반
    private int score;

    public Student(String name, boolean isMale, int hak, int ban, int score) {
		this.name = name;
		this.isMale = isMale;
		this.hak = hak;
		this.ban = ban;
		this.score = score;
	}

	public String toString() {
        return String.format("[%s, %s, %d학년 %d반, %3d점 ]", name, isMale ? "남" : "여", hak, ban, score);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	public int getHak() {
		return hak;
	}

	public void setHak(int hak) {
		this.hak = hak;
	}

	public int getBan() {
		return ban;
	}

	public void setBan(int ban) {
		this.ban = ban;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}

public class StreamTest {

	public static void main(String[] args) {
		Student[] stuArr = new Student[]{
			    new Student("나자바", true, 1, 1, 300),
			    new Student("김지미", false, 1, 1, 250),
			    new Student("김자바", true, 1, 1, 200),
			    new Student("이지미", false, 1, 2, 150),
			    new Student("남자바", true, 1, 2, 100),
			    new Student("안지미", false, 1, 2, 50),
			    new Student("황지미", false, 1, 3, 100),
			    new Student("강지미", false, 1, 3, 150),
			    new Student("이자바", true, 1, 3, 200),
			    new Student("나자바", true, 2, 1, 300),
			    new Student("김지미", false, 2, 1, 250),
			    new Student("김자바", true, 2, 1, 200),
			    new Student("이지미", false, 2, 2, 150),
			    new Student("남자바", true, 2, 2, 100),
			    new Student("안지미", false, 2, 2, 50),
			    new Student("황지미", false, 2, 3, 100),
			    new Student("강지미", false, 2, 3, 150),
			    new Student("이자바", true, 2, 3, 200)
			};
		
		List<Student> list = Arrays.asList(stuArr);
		
		int mcnt = (int) list.stream()
				.filter(s -> s.getScore() < 150)
				.filter(Student::isMale)
				.count();
		System.out.println(mcnt);
		
		int fcnt = (int) list.stream()
				.filter(s -> s.getScore() < 150)
				.filter(s -> s.isMale())
				.count();
		System.out.println(fcnt);
	}

}
