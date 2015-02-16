package leecode.twosumIII;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	 private Map<Integer,Integer> elements=new HashMap<>();  
     public void add(int number) {  
       if(elements.containsKey(number))  
       {  
         elements.put(number,elements.get(number)+1);  
       }  
       else  
       {  
         elements.put(number,1);  
       }  
     }  
     public boolean find(int value) {  
       for(Integer i:elements.keySet())  
       {  
         int needed=value-i;  
         if(elements.containsKey(needed))  
         {  
           if(i==needed&&elements.get(needed)<2)  
           {  
             continue;  
           }  
           return true;  
         }  
       }  
       return false;  
     }  
}
