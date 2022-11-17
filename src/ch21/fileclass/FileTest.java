package ch21.fileclass;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {

		/**
		 * 파일 관리
		 */
		File f = new File("c:\\Temp\\test.txt");
		if(f.exists()) {
			if(f.isFile()) {
				System.out.println("파일입니다.");
				System.out.println("파일경로 : " + f.getParent());
				System.out.println("파일이름: " + f.getName());
				System.out.println("파일 크기: " + f.length());
				System.out.println("숨김 파일 : " + f.isHidden());
				System.out.println("절대 경로 : " + f.isAbsolute());
				System.out.println("파일입니다.");
			} else if (f.isDirectory()) {
				System.out.println("디렉터리입니다.");
			}
		} else {
			System.out.println("파일이 없습니다.");
		}
		
		/**
		 * 디렉터리 관리
		 */
		File folder = new File("c:\\TestFolder");
		if(folder.mkdir()) {
			File file = new File("c:\\\\TestFolder\\MyFile.txt");
			try {
				if(file.createNewFile()) {	//파일이 이미 있으면 false 반환
					try (FileWriter out = new FileWriter(file)){
						out.write("테스트 파일");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * 파일 목록 출력
		 */
		f = new File("c:\\");
		File[] arFile = f.listFiles();
		for(int i = 0; i < arFile.length; i++) {
			if(arFile[i].isFile()) {
				System.out.printf("%s %d 바이트\n", arFile[i].getName(), arFile[i].length());
			} else {
				System.out.printf("[%s] <폴더>\n", arFile[i].getName());
			}
		}

	}

}
