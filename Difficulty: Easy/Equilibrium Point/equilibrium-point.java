//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(
                    token)); // Use Integer.parseInt to parse int values
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            Solution obj = new Solution();

            // calling equilibriumPoint() function
            System.out.println(obj.findEquilibrium(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
     int totalSum = 0; // Total sum of the array
        int leftSum = 0;  // Sum of elements to the left of the current index

        // Calculate the total sum of the array
        for (int num : arr) {
            totalSum += num;
        }

        // Traverse the array to find the equilibrium point
        for (int i = 0; i < arr.length; i++) {
            // Exclude the current element from the total sum to get the right sum
            totalSum -= arr[i];

            // Check if left sum equals the right sum
            if (leftSum == totalSum) {
                return i; // Equilibrium index found
            }

            // Update left sum to include the current element
            leftSum += arr[i];
        }

        return -1;   
    }
}




