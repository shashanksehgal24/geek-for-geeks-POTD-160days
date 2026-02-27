// User function Template for Java

class Solution {
    String removeVowels(String s) {
        // code here
        StringBuilder r = new StringBuilder();
        
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if ("aeiouAEIOU".indexOf(c) == -1) {
                r.append(c);
            }
        }
        return r.toString();
    }
}