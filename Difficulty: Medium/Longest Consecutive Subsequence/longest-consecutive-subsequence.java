//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.longestConsecutive(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        if(arr.length==0) return 0;
        Set<Integer> s=new HashSet<>();
        for(int i:arr) s.add(i);
        int ans=0;
        for(int i:arr){
            if(!s.contains(i-1)){
                int curr=i;
                int req=1;
                while(s.contains(curr+1)){
                    curr+=1;
                    req++;
                }
                ans=Math.max(ans,req);
            }
        }
        return ans;
    }
}