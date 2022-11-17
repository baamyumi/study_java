package ch21.filestream;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ByteStreamEncodingTest {

	public static void main(String[] args) {
		/**
		 * 문자 인코딩 - 이진 스트림으로 읽어서 InputStreamReader를 이용
		 */
		
		/**
		 * char 타입으로 읽기
		 */
		try (
				FileInputStream fi = new FileInputStream("테스트.txt");
				InputStreamReader in = new InputStreamReader(fi, "euc-kr");
		){
			char[] text = new char[1000];
			int num = in.read(text);
			System.out.println("읽은 문자 수 = " + num);
			System.out.println(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/**
		 * byte 타입으로 읽기
		 */
		try (
				FileInputStream fi = new FileInputStream("테스트.txt");
		){
			byte[] text = new byte[1000];
			int num = fi.read(text);
			String utftext = new String(text, "euc-kr");	//String 생성자로 전달해서 인코딩
			System.out.println("읽은 바이트 수 : "+ num);
			System.out.println(utftext);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
