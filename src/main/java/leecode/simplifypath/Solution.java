package leecode.simplifypath;

import java.util.Stack;
/* Simplify Path
 * Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
O(# of "/")
 */
public class Solution {
    public String simplifyPath(String path) {
        if (path == null) return path;
        if (path.length() == 0) return "/";
        String[] splits = path.split("/");
        Stack<String> p = new Stack<>();
        for (int i = 0; i < splits.length; i++) {
        	if (splits[i].equals(".")) {
        		continue;
        	} else if (splits[i].equals("..")) {
        		if (!p.isEmpty()) {
        			p.pop();
        		}
        	} else if (splits[i].equals("")) {
        		continue;
        	} else {
        		p.push(splits[i]);
        	}
        }
        if (p.isEmpty()) {
        	return "/";
        }
        StringBuilder builder = new StringBuilder();
        while (!p.isEmpty()) {
        	builder.insert(0, p.pop());
        	builder.insert(0, "/");
        }
        return builder.toString();
    }
}