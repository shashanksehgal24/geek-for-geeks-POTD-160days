//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String s2 = br.readLine();

            Solution ob = new Solution();
            int ans = ob.editDistance(s1, s2);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // Create a DP table
        int[][] dp = new int[m + 1][n + 1];

        // Fill the DP table
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    // If s1 is empty, all characters of s2 need to be inserted
                    dp[i][j] = j;
                } else if (j == 0) {
                    // If s2 is empty, all characters of s1 need to be removed
                    dp[i][j] = i;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // Characters match, no additional cost
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Minimum of insert, remove, or replace
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], // Remove
                                    Math.min(dp[i][j - 1], // Insert
                                             dp[i - 1][j - 1])); // Replace
                }
            }
        }
        return dp[m][n];
    }
}
