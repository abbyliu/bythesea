package leecode.majoritynumber;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class T {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("e:/downloads/1.txt"));
		String str  = null;
		int ones = 0;
		int twoes = 1;
		while ((str = reader.readLine()) != null) {
			String[] splits = str.split(",");
			System.out.println(splits.length);
			for (String sp: splits) {
				if (sp.equals("1")) {
					ones++;
				} else if (sp.equals("2")) {
					twoes++;
				}
			}
		}
		reader.close();
		System.out.println("1: " + ones);
		System.out.println("2: " + twoes);
	}

}
