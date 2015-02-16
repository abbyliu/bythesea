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
        	if (lastLine) {
        		printLastLine(words, idx, line, start);
        	} else {
        		printEachLineEvenly(words, L, idx, line, wordLength, start,
						numOfWords);
        	}
			appendSpace(line, L - line.length());
        	result.add(line.toString());
        	idx++;
        }
        return result;
    }

	private void printEachLineEvenly(String[] words, int L, int idx,
			StringBuilder line, int wordLength, int start, int numOfWords) {
		int numOfSpaces = numOfWords - 1;
		int spaces = (numOfSpaces == 0) ? (L - wordLength):(L - wordLength)/numOfSpaces;
		int remains = (numOfSpaces == 0) ? 0:(L- wordLength) % numOfSpaces;
		for (int i = start; i<=idx; i++) {
			if (i > start) {
				appendSpace(line, spaces);
				if (remains > 0) {
		    		remains--;
		    		appendSpace(line, 1);
				} 
			}
			line.append(words[i]);
		}
	}

	private void printLastLine(String[] words, int idx, StringBuilder line,
			int start) {
		for (int i = start; i<=idx; i++) {
			if (i > start) {
				appendSpace(line, 1);
			}
			line.append(words[i]);
		}
	}
    
    private void appendSpace(StringBuilder builder, int space) {
    	for (int i = 0 ; i < space; i++) {
    		builder.append(" ");
    	}
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	String[] strs = {"like", "a", "box","of", "chocolates.", "You"}; 
    	System.out.println(s.fullJustify(strs, 12));
    }
} 