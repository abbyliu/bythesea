package leecode.greycode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {
	public String test(){
		for (;;) {
			
		}
	}
	public static void main(String[] args) throws IOException {
		FileReader reader = new FileReader("E:\\Downloads\\maclist.txt");
		BufferedReader bfr = new BufferedReader(reader);
		while (bfr.readLine()!= null) {};
		
		bfr.close();
		reader.close();
	}
}
