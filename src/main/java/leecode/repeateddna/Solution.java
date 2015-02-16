package leecode.repeateddna;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Repeated DNA Sequences
 * O(2^20) space
 * O(N) time
 */
public class Solution {
    
   	private int[] allPossible10LongSequences = new int[1024 * 1024];
	private char[] lookupArray = new char[4];
	private int totalCharsRead;
	private int currSeqAsInt = 0;
	private int mask = (1024 * 1024) - 1;

	private int getMappingValue(char c) {
		switch (c) {
		case 'A':
		case 'a': return 0;
		case 'C':
		case 'c': return 1;
		case 'G': 
		case 'g': return 2;
		case 'T':
		case 't': return 3;
		default:
			throw  new IllegalArgumentException("unexpected character " + c);
		}
	}
	
	private void initLookup() {
		lookupArray[0]= 'A';
		lookupArray[1] = 'C';
		lookupArray[2] = 'G';
		lookupArray[3] = 'T';
	}
	
	private void processChar(char b) {
		currSeqAsInt = ((currSeqAsInt << 2) | getMappingValue(b)) & mask;

		if (++totalCharsRead < 10) {
			return;
		}
		allPossible10LongSequences[currSeqAsInt]++;
	}

	private List<String> printResults(int[] allPossible10LongSequences) {
	    List<String> result = new ArrayList<>();
		for (int i = 0; i < allPossible10LongSequences.length; i++) {
			if (allPossible10LongSequences[i] > 1) {
				result.add(printSequence(i));
			}
		}
		return result;
	}
	
	private String printSequence(int sequence) {
		char[] result = new char[10];
		for (int i = 0; i < 10; i++) {
			result[result.length-1-i] = lookupArray[sequence & 0b11];
			sequence >>>= 2;
		}
		return new String(result);
	}
	
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() == 0) {
            return Collections.emptyList();
        }
        
        initLookup();
       	for (int i = 0; i < s.length(); i++) {
			processChar(s.charAt(i));
		}
        List<String> result = printResults(allPossible10LongSequences);
        
        return result;
    }
}