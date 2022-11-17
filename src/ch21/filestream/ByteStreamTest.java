package ch21.filestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamTest {

	public static void main(String[] args) {
		/**
		 * 바이트 단위 입출력 스트림 : 메모리나 이진 파일 입출력
		 */
		
		/**
		 * FileOutputStream
		 */
		byte[] data = {1,2,3,4,5,6,7};
		FileOutputStream out = null;
		try {
			out = new FileOutputStream("test.bin");
			out.write(data);
			System.out.println("Write Success");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		/**
		 * FileInputStream
		 */
		FileInputStream in = null;
		try {
			in = new FileInputStream("test.bin");
			int avail = in.available();	//읽어야할 데이터가 얼마나 남았는지 조사한다.
			byte[] data1 = new byte[avail];
			in.read(data1);
			for(byte b: data1) {
				System.out.print(b);
			}
			System.out.println();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

		/**
		 * FileInputStream : 2바이트씩(block) 읽기
		 */
		FileInputStream in2 = null;
		try {
			in2 = new FileInputStream("test.bin");
			byte[] data2 = new byte[2];
			int len;
			for(;;) {
				len = in2.read(data2);
				if (len == -1) break;	//-1이면 다읽은 것
				for(byte b : data2) {
					System.out.print(b);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			try {
				in2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
