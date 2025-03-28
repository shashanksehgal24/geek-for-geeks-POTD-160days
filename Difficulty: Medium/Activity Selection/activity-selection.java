//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        while (t-- > 0) {
            // Read the start times
            String[] startInput = reader.readLine().trim().split("\\s+");
            int[] start = new int[startInput.length];
            for (int i = 0; i < startInput.length; i++) {
                start[i] = Integer.parseInt(startInput[i]);
            }

            // Read the end times
            String[] endInput = reader.readLine().trim().split("\\s+");
            int[] finish = new int[endInput.length];
            for (int i = 0; i < endInput.length; i++) {
                finish[i] = Integer.parseInt(endInput[i]);
            }

            // Create solution object and call activitySelection
            Solution obj = new Solution();
            System.out.println(obj.activitySelection(start, finish));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
  class pair implements Comparator<pair>{
         int s;
         int e;
         public pair(int s, int e){
             this.s=s;
             this.e=e;
         }
         public int compare(pair o1, pair o2){
             if(o1.e==o2.e){
                 return o1.s-o2.s;
             }else return o1.e-o2.e;
         }
     }
     
     public int activitySelection(int[] start, int[] finish) {
         int n=start.length;
         pair arr[]=new pair[n];
         for(int i=0;i<n;i++){
             arr[i]=new pair(start[i], finish[i]);
         }
         
         Arrays.sort(arr, new pair(0, 0));
         
         int cnt=0;
         int end=Integer.MIN_VALUE;
         
         for(int i=0;i<n;i++){
             if(end<arr[i].s){
                 cnt++;
                 end=arr[i].e;
             }
         }
         return cnt;
     }
 }