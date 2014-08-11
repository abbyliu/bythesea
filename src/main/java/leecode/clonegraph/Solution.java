package leecode.clonegraph;

import java.util.HashMap;
import java.util.Map;
/*
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors. 0
 * O(n), O(n)
 */
public class Solution {
	
	
    Map<UndirectedGraphNode, UndirectedGraphNode> map  =new HashMap<>();
    
    public UndirectedGraphNode cloneGraph3(UndirectedGraphNode node) {
        if (node == null) return node;
        if (map.containsKey(node)) {
            return map.get(node);
        }
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(node, copy);
        for (UndirectedGraphNode adj: node.neighbors) {
                UndirectedGraphNode copies = cloneGraph(adj);
                map.put(adj, copies);
                copy.neighbors.add(copies);
        }
        return copy;
    }
	
	   Map<UndirectedGraphNode, UndirectedGraphNode> cloneMap = new HashMap<>();
	   
	   public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
		   if (node == null) return null;
		   UndirectedGraphNode clone = null;
		   if (cloneMap.containsKey(node)) {
			   clone= cloneMap.get(node);
		   } else {
			   clone = new UndirectedGraphNode(node.label);
			   cloneMap.put(node, clone);
			   for (UndirectedGraphNode adj: node.neighbors) {
				   clone.neighbors.add(cloneGraph2(adj));
			   }
		   }
		   return clone;
	   }
	   public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		   if (node == null) return null;
		   
		   UndirectedGraphNode clone = null;
		   if (!cloneMap.containsKey(node)) {
			   clone = new UndirectedGraphNode(node.label);
			   cloneMap.put(node, clone);
			   if (node.neighbors != null && node.neighbors.size() > 0) {
				   for (UndirectedGraphNode n: node.neighbors) {
					   clone.neighbors.add(cloneGraph(n));
				   }
			   }
		   } else {
			   clone = cloneMap.get(node);
		   }
		   
		   return clone;
	   }
}
