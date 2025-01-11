//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        
        int n = s.length();
        int maxLen = 0;
        int j = 0;
        HashSet<Character> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            char currentChar = s.charAt(i);
            while (set.contains(currentChar)) {
                set.remove(s.charAt(j));
                j++;
            }
            set.add(currentChar);
            maxLen = Math.max(maxLen, i - j + 1);
        }
        
        return maxLen;
    }
}