package study.sp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class RunManager {

	//22년 A형 1번 
	public static void main(String[] args) {
		
		// 1. 콘솔 입력
		// 2. 입력 값에 대한 파일 읽기
		// 3. proxy 파일의 내용 읽어 service 파일 열기
		// 4. service 파일의 내용 읽어 콘솔 출력 
		Scanner sc = new Scanner(System.in);
        String line;
        
        while((line=sc.nextLine()) != null) {
            readFile(line);
        }

	}
	
	public static void readFile(String fileName) {
		String filePath;
		StringBuffer sb= new StringBuffer();
		if(fileName.endsWith(".txt")) {
			sb.append("./").append(fileName);
		}else {
			sb.append("./").append(fileName).append(".txt");
		}
		filePath = sb.toString();
		
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;            
            while((line = br.readLine()) != null){            	
                if(line.endsWith(".txt")) {
                	readFile(line);
                }else {
                	System.out.println(line);
                }
            }
        } catch (Exception e) {
        	System.out.println(e);
        }



		
	}

}
