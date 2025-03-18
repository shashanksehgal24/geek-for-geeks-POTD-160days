//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution ob = new Solution();

            if (ob.equalPartition(arr))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static boolean equalPartition(int arr[]) {
        int totalSum = 0;

        // Calculate the total sum of array elements
        for (int num : arr) {
            totalSum += num;
        }

        // If the total sum is odd, partitioning is not possible
        if (totalSum % 2 != 0) {
            return false;
        }

        int targetSum = totalSum / 2;
        int n = arr.length;

        // Create a DP array for the subset sum problem
        boolean[] dp = new boolean[targetSum + 1];
        dp[0] = true; // Base case: subset with sum 0 is always possible

        // Update DP array based on the elements in the array
        for (int num : arr) {
            for (int j = targetSum; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        // The result is whether a subset with sum equal to targetSum exists
        return dp[targetSum];
    }
}
