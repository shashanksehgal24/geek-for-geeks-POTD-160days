// User function Template for Java

class Solution {
    String removeSpecialCharacter(String s) {
        // code here
        StringBuilder q=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
        char a=s.charAt(i);
        if(Character.isLetter(a)){
            q.append(a);
        }
        
            
        }
         if (q.length() == 0) {
            return "-1";
        }
        return q.toString();
    }
}