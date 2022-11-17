package ch21.filestream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamTest {

	public static void main(String[] args) {
		/***
		 * 문자 스트림 - 텍스트 파일 입출력
		 */
		
		/**
		 * FileWriter
		 */
		String str = "자바 Stream 입출력";
		try(FileWriter out = new FileWriter("test.txt") ) {
			out.write(str);
			System.out.println("Write Success");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/**
		 * FileReader - 한 문자씩 읽기
		 */
		try (FileReader in = new FileReader("test.txt")){
			int ch;
			for(;;) {
				ch = in.read();
				if(ch == -1) {
					break;
				}
				System.out.print((char)ch);
			}
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/**
		 * FileReader - 한꺼번에 읽기
		 */
		try (FileReader in = new FileReader("test.txt")){
			char[] text = new char[100];
			int num = in.read(text);
			System.out.println("읽은 문자 개수 = " + num);
			System.out.println(text);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
