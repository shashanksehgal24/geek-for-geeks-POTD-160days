//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class DriverClass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[][] = new int[k][n];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();
            }
            ArrayList<Integer> range = new Solution().findSmallestRange(arr);
            System.out.println(range.get(0) + " " + range.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    class Node {
        int value, row, col;
        Node(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    public ArrayList<Integer> findSmallestRange(int[][] arr) {
        int k = arr.length;
        int n = arr[0].length;

        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            minHeap.add(new Node(arr[i][0], i, 0));
            max = Math.max(max, arr[i][0]);
        }

        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;

        while (true) {
            Node curr = minHeap.poll();
            int min = curr.value;

            if (max - min < rangeEnd - rangeStart) {
                rangeStart = min;
                rangeEnd = max;
            }

            if (curr.col + 1 < n) {
                int nextVal = arr[curr.row][curr.col + 1];
                minHeap.add(new Node(nextVal, curr.row, curr.col + 1));
                max = Math.max(max, nextVal);
            } else {
                break;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(rangeStart);
        result.add(rangeEnd);
        return result;
    }
}
