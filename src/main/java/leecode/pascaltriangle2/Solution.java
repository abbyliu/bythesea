package leecode.pascaltriangle2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* Pascal's Triangle II
 * Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space? 
O(n2)
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) {
            return Collections.emptyList();
        }
        
        List<Integer> output = new ArrayList<>(rowIndex+1);
        for (int i = 0; i < rowIndex+1; i++) {
            output.add(1);
        }
        for (int i = 0 ; i < rowIndex -1; i++) {
            for (int j = i+1; j>=1;j--) {
                int v = output.get(j) + output.get(j-1);
                output.set(j, v);
            }
        }
        
        return output;
    }
}