package leecode.restoreip;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
        if (s == null || s.length() < 4||s.length()>12) return ret;
        findValidIps(1, s, ret, "");
        return ret;
    }
    private boolean isValidIp(String s) {
        int v = 0;
        try {
            v = Integer.parseInt(s);
            return v >=0 && v <= 255 && String.valueOf(v).equals(s);
        } catch(Exception ex) {
            return false;
        }
    }
    private void findValidIps(int idx, String s, List<String> ret, String current) {
        if (idx == 4 && isValidIp(s)) {
            ret.add(current + "." + s);
            return ;
        }
        for (int i = 1; i < 4 && i <=s.length();i++) {
            String sub = s.substring(0, i);
            int rest= s.length() -i;
            if (isValidIp(sub) && rest >= (4-idx) && rest <= (4-idx)*3) {
                if (current.length()==0) {
                    findValidIps(idx+1, s.substring(i), ret, sub);
                } else {
                    findValidIps(idx+1, s.substring(i), ret, current + "." + sub);
                }
            }
        }
    }    
}