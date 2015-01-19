package leecode.integertoroman;
/* Integer to Roman
 * Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		s.intToRoman2(40);
	}
	
    public String intToRoman2(int num) {
        String result = "";
        int base[] = {1000,500,100,50,10,5,1,0};
        char baseC[] = {'M','D','C','L','X','V','I'};
        int basen = 0;
        while(num > 0) {
            if(basen%2 == 0 && num/base[basen] == 4) {
                result += baseC[basen];
                result += baseC[basen-1];
                num -= base[basen] * 4;
            } else if(num >= base[basen]) {
                result += baseC[basen];
                num -= base[basen];
            } else if(basen%2 == 0 && num / base[basen+2] == 9) {
                result += baseC[basen+2];
                result += baseC[basen];
                num -= base[basen+2]*9;
            } else {
                basen++;
            }
        }
        return result;
    }
    public String intToRoman(int num) {
    	if (num <=0) return "";
    	StringBuilder builder = new StringBuilder();
    	int value = num;
    	for (int i = 1000; i <= num; i = i + 1000) {
    		builder.append("M");
    	}
    	int hundreds = value % 1000;
    	if (hundreds >= 900) {
    		builder.append("CM");
    	} else if (hundreds < 500  && hundreds >=400) {
    		builder.append("CD");
    	} else {
    		if (hundreds >=500) {
    			builder.append("D");
    			hundreds -= 500;
    		}
    		for (int i = 100; i <= hundreds; i = i + 100) {
    			builder.append("C");
    		}
    	}
    	
    	int tenths = hundreds % 100;
    	
    	if (tenths >= 90) {
    		builder.append("XC");
    	} else if (tenths < 50  && tenths >=40) {
    		builder.append("XL");
    	} else {
    		if (tenths >=50) {
    			builder.append("L");
    			tenths -= 50;
    		}
    		for (int i = 10; i <= tenths; i = i + 10) {
    			builder.append("X");
    		}
    	}
    	
    	int digits = tenths % 10;
    	if (digits >=9) {
    		builder.append("IX");
    	} else if (digits == 4) {
    		builder.append("IV");
    	} else {
    		if (digits >= 5) {
    			builder.append("V");
    			digits -=5;
    		}
    		for (int i = 1; i <= digits; i++) {
    			builder.append("I");
    		}
    	}
    	
    	return builder.toString();
    }
}
