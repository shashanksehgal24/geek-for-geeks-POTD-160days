//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxWater(int arr[]) {
        // code here
        // O(1) space solution
        int maxLeft = 0;
        int maxRight = 0;
        int total = 0;
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] <= arr[right]) {
                // if(arr[left] < maxLeft) {
                // total += maxLeft - arr[left];
                // }
                // else {
                // maxLeft = arr[left];
                // }
                total += Math.max(0, maxLeft - arr[left]);
                maxLeft = Math.max(maxLeft, arr[left]);
                left++;
            } else {
                // if(arr[right] < maxRight) {
                // total += maxRight-arr[right];
                // }
                // else {
                // maxRight = arr[right];
                // }
                total += Math.max(0, maxRight - arr[right]);
                maxRight = Math.max(maxRight, arr[right]);
                right--;
            }
        }

        return total;
    }
}