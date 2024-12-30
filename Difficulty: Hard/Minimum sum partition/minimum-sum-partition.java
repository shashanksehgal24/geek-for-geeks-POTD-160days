//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends
// User function Template for Java
class Solution {

    public int minDifference(int arr[]) {
        int n = arr.length;
        int sumTotal = 0;
        
        // Calculate total sum of the array
        for (int num : arr) {
            sumTotal += num;
        }
        
        // DP array to track possible subset sums
        boolean[] dp = new boolean[sumTotal / 2 + 1];
        dp[0] = true; // Zero sum is always possible
        
        // Fill the DP array
        for (int num : arr) {
            for (int j = sumTotal / 2; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        
        // Find the largest subset sum closest to sumTotal / 2
        int sum1 = 0;
        for (int j = sumTotal / 2; j >= 0; j--) {
            if (dp[j]) {
                sum1 = j;
                break;
            }
        }
        
        // Return the minimum difference
        return Math.abs(sumTotal - 2 * sum1);
    }
}



//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            // int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.minDifference(arr);

            System.out.print(ans);

            System.out.println(); // New line after printing the results
        }
    }
}

// } Driver Code Ends