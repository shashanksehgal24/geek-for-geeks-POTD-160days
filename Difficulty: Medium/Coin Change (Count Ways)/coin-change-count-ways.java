//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String inputLine[] = read.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int sum = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.count(arr, sum));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int count(int[] coins, int sum) {
        int n = coins.length;
        long[][] dp = new long[n + 1][sum + 1];
        
        // Initialization
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1; // There's one way to make sum 0: by using no coins.
        }
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = 0; // No ways to make a non-zero sum with 0 coins.
        }
        
        // Main logic
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return (int) dp[n][sum]; // Converting the result back to int.
    }
}
