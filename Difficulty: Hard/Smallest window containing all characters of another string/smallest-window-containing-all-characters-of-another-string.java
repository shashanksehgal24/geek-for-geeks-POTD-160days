//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();
        scan.nextLine(); // Consume the newline character after the integer input

        while (test > 0) {
            String s1 = scan.nextLine(); // Read first string on a new line
            String s2 = scan.nextLine(); // Read second string on a new line

            Solution obj = new Solution();
            String str = obj.smallestWindow(s1, s2);

            if (str.isEmpty()) {
                System.out.println("\"\"");
            } else {
                System.out.println(str);
            }
            // System.out.println("~");
            test--;
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the smallest window in the string s1 consisting
    // of all the characters of string s2.
    public static String smallestWindow(String s1, String s2) {
        if (s1.length() < s2.length()) return "";

        // Frequency map for s2
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s2.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, minLen = Integer.MAX_VALUE, start = -1;
        int required = map.size();
        int formed = 0;
        HashMap<Character, Integer> windowCounts = new HashMap<>();

        while (right < s1.length()) {
            char c = s1.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            // Check if the current character satisfies the frequency requirement
            if (map.containsKey(c) && windowCounts.get(c).intValue() == map.get(c).intValue()) {
                formed++;
            }

            // Try to contract the window
            while (left <= right && formed == required) {
                c = s1.charAt(left);

                // Update the minimum window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                // Remove the leftmost character from the window
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (map.containsKey(c) && windowCounts.get(c).intValue() < map.get(c).intValue()) {
                    formed--;
                }

                left++;
            }

            // Expand the window
            right++;
        }

        return start == -1 ? "" : s1.substring(start, start + minLen);
    }

   
}
