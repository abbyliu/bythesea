package leecode.ladder1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Set;

public class Solution2 {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start == null || end == null || dict.isEmpty()) return 0;
        
        Deque<String> q = new LinkedList<>();
        Deque<String> tmp = new LinkedList<>();
        int dist = 1;
        q.offer(start);
     
        while (!q.isEmpty()) {
            String str = q.poll();
            if (str.equals(end)) {
                return dist;
            }
            char[] chars = str.toCharArray();
            for (int i =0; i < str.length();i++) {
                for(char c = 'a'; c<='z';c++) {
                    if (c != chars[i]) {
                        char old = chars[i];
                        chars[i] = c;
                        String newStr = new String(chars);
                        if (dict.contains(newStr)) {
                            tmp.offer(newStr);
                            dict.remove(newStr);
                        }
                        chars[i] = old;
                    }
                }
            }
            if (q.isEmpty()) {
                q = tmp;
                tmp = new LinkedList<>();
                dist++;
            }
        }
        return 0;
    }
        
        
        
 
}