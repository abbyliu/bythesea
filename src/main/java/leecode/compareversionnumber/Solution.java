package leecode.compareversionnumber;

public class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1.equals(version2)) {
            return 0;
        }
        String[] v1s = version1.split("\\.");
        String[] v2s = version2.split("\\.");
        
        int idx1 = 0; int idx2 = 0;
        while (idx1 < v1s.length && idx2 < v2s.length) {
            int v1 = Integer.parseInt(v1s[idx1]);
            int v2 = Integer.parseInt(v2s[idx2]);
            if (v1 < v2) {
                return -1;
            } else if (v1 > v2) {
                return 1;
            }
            idx1++;
            idx2++;
        }
        if (v1s.length != v2s.length) {
            String[] longer = null;
            int idxx = 0;boolean first = false;
            if (idx1 < v1s.length) {
                longer = v1s;
                idxx = idx1;
                first = true;
            } 
            if (idx2 < v2s.length) {
                longer = v2s;
                idxx = idx2;
                first = false;
            }
            while (idxx < longer.length) {
                if (Integer.parseInt(longer[idxx]) != 0) {
                    if (first) return 1;
                    return -1;
                }
                idxx++;
            }
        }
        return 0;
    }
    
}