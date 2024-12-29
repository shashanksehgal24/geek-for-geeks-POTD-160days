//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int k = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution();
            int ans =
                ob.lenOfLongestSubarr(nums, k); // Call the function and store result
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int lenOfLongestSubarr(int[] arr, int k) {
        // HashMap to store the first occurrence of each prefix sum
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int prefixSum = 0; // Cumulative sum
        int maxLength = 0; // Length of the longest subarray

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i]; // Update the cumulative sum

            // Check if the current prefix sum equals k
            if (prefixSum == k) {
                maxLength = i + 1; // Update maxLength for subarray starting from index 0
            }

            // Check if prefixSum - k exists in the map
            if (prefixSumMap.containsKey(prefixSum - k)) {
                maxLength = Math.max(maxLength, i - prefixSumMap.get(prefixSum - k));
            }

            // Store the prefix sum if it's not already present
            if (!prefixSumMap.containsKey(prefixSum)) {
                prefixSumMap.put(prefixSum, i);
            }
        }

        return maxLength;
    }
}

