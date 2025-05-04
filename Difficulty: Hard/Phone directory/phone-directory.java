//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String contact[] = in.readLine().trim().split("\\s+");
            String s = in.readLine();
            
            Solution ob = new Solution();
            ArrayList<ArrayList<String>> ans = ob.displayContacts(n, contact, s);
            for(int i = 0;i < ans.size();i++){
                for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.println();
            }
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static ArrayList<ArrayList<String>> displayContacts(int n, String contact[], String s) {
        Set<String> uniqueContacts = new HashSet<>(Arrays.asList(contact));
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            ArrayList<String> matched = new ArrayList<>();

            for (String c : uniqueContacts) {
                if (c.startsWith(prefix)) {
                    matched.add(c);
                }
            }

            if (matched.isEmpty()) {
                matched.add("0");
            } else {
                Collections.sort(matched);
            }

            result.add(matched);
        }

        return result;
    }
}
