// User function Template for Java

class Solution {
    String removeDuplicates(String s) {
        
        HashSet<Character> set=new HashSet<>();
        String a="";
         for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(set.add(c))
            {
                a+=c;
            }
        }return a;
    }
}
