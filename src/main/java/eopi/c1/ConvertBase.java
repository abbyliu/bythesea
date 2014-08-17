package eopi.c1;

public class ConvertBase {
	public String convertBase(String s, int b1, int b2) {
		boolean neg = s.startsWith("-");
		int x = 0;
		for (int i = (neg? 1:0); i<s.length();i++) {
			x = x*b1;
			x += Character.isDigit(s.charAt(i)) ? s.charAt(i)-'0' : s.charAt(i) - 'A' +10;
		}
		
		String ans = "";
		String[] letters =new String[26];
		for (char i = 'a';i <= 'z';i++) {
			letters[i-'a'] = String.valueOf(i);
		}
		while (x>0) {
			int r = x%b2;
			ans = ans+ (r>=10? (letters[r-10]): r);
			x = x/b2;
		}
		if (ans.length()==0) {
			ans = "0";
		}
		if (neg) {
			ans += "-";
		}
		return new StringBuilder(ans).reverse().toString();
	}
	public static void main(String[] args) {
		ConvertBase c = new ConvertBase();
		System.out.println(c.convertBase("617", 7, 13));
	}
}
