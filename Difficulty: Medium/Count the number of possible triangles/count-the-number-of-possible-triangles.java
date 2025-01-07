//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countTriangles(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// // User function Template for Java
// import java.util.Arrays;

class Solution {
    // Function to count the number of possible triangles.
    static int countTriangles(int arr[]) {
        // Sort the array
        Arrays.sort(arr);
        int n = arr.length;
        int count = 0;

        // Iterate over the array, treating arr[k] as the largest side.
        for (int k = n - 1; k >= 2; k--) {
            int i = 0;      // First pointer
            int j = k - 1;  // Second pointer
            
            while (i < j) {
                // Check if the sum of arr[i] and arr[j] is greater than arr[k].
                if (arr[i] + arr[j] > arr[k]) {
                    // If true, all elements between i and j can form triangles with arr[k].
                    count += (j - i);
                    j--; // Move the second pointer left
                } else {
                    i++; // Otherwise, move the first pointer right
                }
            }
        }
        return count;
    }
    
   
}
