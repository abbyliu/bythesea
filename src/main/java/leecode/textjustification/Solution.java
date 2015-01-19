package leecode.textjustification;

import java.util.ArrayList;
import java.util.List;
/*  Text Justification
 *  Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16. 
O(# of words)
 */
public class Solution {
    public List<String> fullJustify(String[] words, int L) {
    	List<String> result = new ArrayList<>();
        if (words == null || words.length == 0) return result;
        int idx = 0;
        while (idx < words.length) {
        	StringBuilder line = new StringBuilder();
        	int wordLength = words[idx].length();
        	int start = idx;
        	int total = wordLength;
        	while (idx+1 < words.length && total + 1 + words[idx+1].length() <= L) {
        		total = total + 1 + words[idx+1].length();
        		wordLength = wordLength + words[idx+1].length();
        		idx++;
        	}
        	boolean lastLine = idx == words.length-1;
        	int numOfWords = idx - start + 1;
        	if (numOfWords == 1) {
        		line.append(words[start]);
        		for (int i = 0; i < L - words[start].length(); i++) {
        			line.append(" ");
        		}
        	} else if (lastLine) {
        		for (int i = start; i<=idx; i++) {
        			if (i > start) {
        				line.append(" ");
        			}
        			line.append(words[i]);
        		}
        		int remains = L - wordLength  - (numOfWords-1);
        		for (int j = 0; j < remains; j++) {
        			line.append(" ");
        		}
        	} else {
        		int numOfSpaces = numOfWords - 1;
        		int spaces = (L - wordLength)/numOfSpaces;
        		int remains = (L- wordLength) % numOfSpaces;
        		for (int i = start; i<=idx; i++) {
        			if (i > start) {
        				if (remains > 0) {
        	        		for (int j = 0; j <= spaces; j++) {
        	        			line.append(" ");
        	        		}
        	        		remains--;
        				} else {
        	        		for (int j = 0; j < spaces; j++) {
        	        			line.append(" ");
        	        		}
        				}
        			}
        			line.append(words[i]);
        		}
        	}
        	result.add(line.toString());
        	idx++;
        }
        return result;
    }
    public static void main(String[] args) {
    	Solution s = new Solution();
    	String[] strs = {"like", "a", "box","of", "chocolates.", "You"}; 
    	System.out.println(s.fullJustify(strs, 12));
    }
} 