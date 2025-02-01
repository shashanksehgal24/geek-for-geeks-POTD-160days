//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] mat = new char[n][m];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.next().charAt(0);
                }
            }

            String word = sc.next();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(mat, word);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends

class Solution {
    // Function to check if a word exists in a grid
    // starting from the first match in the grid
    // wIdx: index till which pattern is matched
    // x, y: current position in 2D array
    static boolean findMatch(char[][] mat, String word, int x, int y, int wIdx) {
        int wLen = word.length();
        int n = mat.length;
        int m = mat[0].length;
        // Pattern matched
        if (wIdx == wLen) return true;
        // Out of Boundary
        if (x < 0 || y < 0 || x >= n || y >= m) return false;
        // If grid matches with a letter while recursion
        if (mat[x][y] == word.charAt(wIdx)) {
            // Marking this cell as visited
            char temp = mat[x][y];
            mat[x][y] = '#';
            // finding subpattern in 4 directions
            boolean res = findMatch(mat, word, x - 1, y, wIdx + 1) ||
                          findMatch(mat, word, x + 1, y, wIdx + 1) ||
                          findMatch(mat, word, x, y - 1, wIdx + 1) ||
                          findMatch(mat, word, x, y + 1, wIdx + 1);
            // marking this cell as unvisited again
            mat[x][y] = temp;
            return res;
        }
        // Not matching then return false
        return false;
    }
    // Function to check if the word exists in the matrix or not
    static public boolean isWordExist(char[][] mat, String word) {
        int wLen = word.length();
        int n = mat.length;
        int m = mat[0].length;
        // if total characters in matrix is less than word length
        if (wLen > n * m) return false;
        // Traverse in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If first letter matches, then recur and check
                if (mat[i][j] == word.charAt(0)) {
                    if (findMatch(mat, word, i, j, 0)) return true;
                }
            }
        }
        return false;
    }
}
