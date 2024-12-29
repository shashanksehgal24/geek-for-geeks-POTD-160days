//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int R = Integer.parseInt(read.readLine());
            int C = Integer.parseInt(read.readLine());
            int matrix[][] = new int[R][C];
            int c = 0;
            for (int i = 0; i < R; i++) {
                String line[] = read.readLine().trim().split(" ");
                for (int j = 0; j < C; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    int median(int mat[][]) {
        int rows = mat.length;
        int cols = mat[0].length;

        // Define the search range for the binary search
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            minValue = Math.min(minValue, mat[i][0]); // Smallest element in the matrix
            maxValue = Math.max(maxValue, mat[i][cols - 1]); // Largest element in the matrix
        }

        int desiredCount = (rows * cols) / 2 + 1; // Position of the median in sorted order

        // Perform binary search
        while (minValue < maxValue) {
            int mid = minValue + (maxValue - minValue) / 2;

            // Count elements less than or equal to mid
            int count = 0;
            for (int i = 0; i < rows; i++) {
                count += countLessOrEqual(mat[i], mid);
            }

            if (count < desiredCount) {
                minValue = mid + 1; // Move the lower bound up
            } else {
                maxValue = mid; // Move the upper bound down
            }
        }

        return minValue; // The median value
    }

    // Helper function to count elements <= mid in a sorted row
    private int countLessOrEqual(int[] row, int target) {
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (row[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low; // Number of elements <= target
    }
}
