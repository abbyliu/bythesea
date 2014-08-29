package leecode.clonegraph;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution2 {
    Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return node;
        
        if (map.containsKey(node)) return map.get(node);
        
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(node, copy);
        for (UndirectedGraphNode neighbor: node.neighbors) {
            UndirectedGraphNode clone = cloneGraph(neighbor);
            copy.neighbors.add(clone);
        }
        return copy;
    }
    
}