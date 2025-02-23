//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str =
                (br.readLine()).trim().split(" "); // Reading input as a string array
            int arr[] = new int[str.length]; // Creating integer array from the input
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            // Getting the result from the Solution class
            ArrayList<Integer> result = new Solution().nextLargerElement(arr);

            // Printing the result in the required format
            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (int i = 0; i < result.size(); i++) {
                    if (i != 0) System.out.print(" ");
                    System.out.print(result.get(i));
                }
                System.out.println();
                System.out.println("~");
            }
        }
    }
}

// } Driver Code Ends

class Solution {

  public ArrayList<Integer> nextLargerElement(int[] arr) {
    ArrayList<Integer> result = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < arr.length; i++)
      result.add(-1);

    for (int i = arr.length - 1; i >= 0; i--) {

      // Step 1: Pop all the elements which are smaller
      // than arr[i] so we can reach the next greater
      // element in order of appearance.
      //
      // Since we are going in reverse mode, order of
      // appereance is maintained.
      while (!stack.isEmpty() && stack.peek() <= arr[i])
        stack.pop();

      // If the stack is not empty
      // that is the next greater
      // element
      if (!stack.isEmpty())
        result.set(i, stack.peek());

      // Push arr[i] as we
      // visit the elements
      stack.push(arr[i]);

    }

    return result;
  }

}