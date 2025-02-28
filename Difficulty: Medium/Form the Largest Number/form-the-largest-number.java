//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] numbers = input.split(" ");
            int[] arr = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                arr[i] = Integer.parseInt(numbers[i]);
            }

            Solution ob = new Solution();
            String ans = ob.findLargest(arr);
            System.out.println(ans);
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String findLargest(int[] arr) {
        // Convert the integers to strings
        String[] arrStr = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrStr[i] = String.valueOf(arr[i]);
        }

        // Sort strings based on the concatenated result
        Arrays.sort(arrStr, new Comparator<String>() {
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });

        // Handle the case when all numbers are zeros
        if (arrStr[0].equals("0")) {
            return "0";
        }

        // Build the largest number from the sorted array
        StringBuilder largestNumber = new StringBuilder();
        for (String str : arrStr) {
            largestNumber.append(str);
        }

        return largestNumber.toString();
    }
}
