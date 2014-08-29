package leecode.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution4 {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        if (start == null || end == null || dict.isEmpty()) return Collections.emptyList();
        if (start.equals(end)) {
            List<List<String>> ret = new ArrayList<>();
            List<String> rett = new ArrayList<>();
            rett.add(end);
            ret.add(rett);
            return ret;
        }
        Map<String, Set<String>> graph = buildGraph(start, end, dict);
        
        if (graph.isEmpty()) return Collections.emptyList();
        
        List<List<String>> ret = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
                tmp.add(start);

        buildResult(start, graph, ret, tmp);
        return ret;
    }
    private void buildResult(String start, Map<String, Set<String>> map, List<List<String>> ret, List<String> tmp) {
        if (!map.containsKey(start)) {
            List<String> rett = new ArrayList<>(tmp);
            ret.add(rett);
            return;
        }
        Set<String> list = map.get(start);
        for (String s: list) {
            tmp.add(s);
            buildResult(s, map, ret, tmp);
            tmp.remove(tmp.size()-1);
        }
    }

    private Map<String, Set<String>> buildGraph(String start, String end, Set<String> dict) {
        Set<String> previous = null;
        Set<String> current = new HashSet<>();
        current.add(end);
        Set<String> next = new HashSet<>();
        boolean found = false;
        Map<String, Set<String>> map = new HashMap<>();
        while (true) {
            for (String str: current) {
                if (str.equals(start)) {
                    found = true;break;
                }
                char[] chars = str.toCharArray();
                for (int i = 0; i < str.length();i++) {
                    for (char c = 'a' ; c<='z';c++) {
                        if (c!= chars[i]) {
                            char old = chars[i];
                            chars[i] = c;

                            String newStr = new String(chars);
                            if (dict.contains(newStr)
                               && !current.contains(newStr)
                               && (previous == null || !previous.contains(newStr))) {
                                   next.add(newStr);
                               if (map.containsKey(newStr)) {
                                   map.get(newStr).add(str);
                               } else {
                                   Set<String> arr = new HashSet<>();
                                   arr.add(str);
                                   map.put(newStr, arr);
                               }
                            }
                            chars[i] = old;
                        }
                    }
                }
            }
            if (found) break;
            if (next.isEmpty()) break;
            previous = current;
            current = next;
            next = new HashSet<>();
        }
        if (!found) {
            return Collections.emptyMap();
        } else {
            return map;
        }
    }
 

}