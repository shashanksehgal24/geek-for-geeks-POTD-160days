//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        // taking input using class Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // taking total number of elements
            int k = Integer.parseInt(br.readLine());
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
            int res = new Solution().countSubarrays(arr, k);

            System.out.print(res);
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    public int countSubarrays(int[] arr, int k) {
        // HashMap to store the prefix sums and their frequencies
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int prefixSum = 0; // Initialize prefix sum
        int count = 0; // To store the count of subarrays
        
        // Initialize the map with prefix sum 0 occurring once
        prefixSumMap.put(0, 1);
        
        // Traverse the array
        for (int num : arr) {
            // Update the prefix sum
            prefixSum += num;
            
            // Check if prefixSum - k exists in the map
            if (prefixSumMap.containsKey(prefixSum - k)) {
                count += prefixSumMap.get(prefixSum - k);
            }
            
            // Update the frequency of the current prefix sum in the map
            prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 0) + 1);
        }
        
        return count;
    }
}
