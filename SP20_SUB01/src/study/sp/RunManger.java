package study.sp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunManager {
	static final String MONITORING = "./INPUT/MONITORING.txt";
	static final String REPORT = "./OUTPUT/REPORT.txt";
	

	//20년 1번  
	public static void main(String[] args) {
		// 1. 콘솔 입력
		Scanner sc = new Scanner(System.in);
        	String inputVal = sc.nextLine();
        	int limitVal = Integer.parseInt(inputVal);
        
		// 2. 파일 읽고 쓰기 
		List<String> monitoringList = readFile(MONITORING);
		for (String checkStr : monitoringList) {
			StringBuffer sb= new StringBuffer();
			if(limitVal < Integer.parseInt(checkStr.substring(9, 12))) {
				sb.append(checkStr).append("#Y\n");
			}else {
				sb.append(checkStr).append("#N\n");
			}
			fileWrite(REPORT, sb.toString(), true);
			
		} 

	}
	
	public static List<String> readFile(String path) {
		// 파일 객체 생성 
		Path p = Paths.get(path);
		List<String> list = new ArrayList<String>();
		
		try {
			list = Files.readAllLines(p);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 파일 쓰는 함수
	// flag: true 이어쓰기, false 새로쓰기 
	public static void fileWrite(String path, String content, Boolean flag) {
		File file = new File(path);
		try {
			FileWriter fw = new FileWriter(file, flag);
			fw.write(content);
			fw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	

}
