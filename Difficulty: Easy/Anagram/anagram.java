
import java.util.*;
class Solution {
    public static boolean areAnagrams(String s1, String s2) {
        // code here
        char [] s=s1.toCharArray();
        char [] q=s2.toCharArray();
        
        Arrays.sort(s);
        Arrays.sort(q);
        if(s.length!=q.length) return false;
        
         for (int i = 0; i < s.length; i++) {
            if (s[i] != q[i]) return false;
        }
        return true;
        
    }
}