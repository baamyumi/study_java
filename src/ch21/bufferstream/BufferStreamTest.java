package ch21.bufferstream;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;

public class BufferStreamTest {

	public static void main(String[] args) {
		/**
		 * 기본 File Stream 클래스는 스트림으로 직접 입출력하는데, 파일에 직접 액세스하기 때문에 성능이 떨어지고
		 * 액세스가 빈번해 속도가 느림.
		 * 그래서 기본 입출력 스트림을 도와주는 보조 스트림 Buffer Stream을 사용한다.
		 * 파일과 객체 사이에 버퍼를 두고 버퍼에 모았다가 한번에 입출력한다.
		 */
		
		
		/**
		 * BufferedOutputStream
		 */
		try (
				FileOutputStream fout = new FileOutputStream("test.buf");
				BufferedOutputStream out = new BufferedOutputStream(fout);
				){
			
			byte[] data = {3,1,4,1,5,9,2,6,5,3,5,8,9,7,9};
			out.write(data);
			System.out.println("Write Success");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/**
		 * BufferedInputStream + StringBuffer
		 */
		String str = ReadFileToString("test.txt");
		System.out.println(str);

	}
	
	static String ReadFileToString(String Path) {
		StringBuffer result = new StringBuffer();
		int ch;
		try (
				BufferedReader in = new BufferedReader(new FileReader(Path));
		){
			for (;;) {
				ch = in.read();
				if (ch == -1) break;
				result.append((char)ch);	//한문자씩 읽어 문자열에 순서대로 덧붙임
			}
		} catch (Exception e) {
			e.setStackTrace(null);
		}
		
		return result.toString();
	}

}
