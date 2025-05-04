//{ Driver Code Starts
// Initial Template for Java
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            long N = Long.parseLong(br.readLine().trim());

            Solution ob = new Solution();
            System.out.println(ob.countStrings(N));
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    static final int MOD = 1_000_000_007;

    public int countStrings(long N) {
        long[][] base = {{1, 1}, {1, 0}};
        long[][] result = matrixPower(base, N + 1);
        return (int) result[0][0]; // Fib(N+2)
    }

    private long[][] matrixPower(long[][] matrix, long power) {
        long[][] result = {{1, 0}, {0, 1}}; // Identity matrix
        while (power > 0) {
            if ((power & 1) == 1) {
                result = multiply(result, matrix);
            }
            matrix = multiply(matrix, matrix);
            power >>= 1;
        }
        return result;
    }

    private long[][] multiply(long[][] A, long[][] B) {
        long[][] res = new long[2][2];
        res[0][0] = (A[0][0]*B[0][0] % MOD + A[0][1]*B[1][0] % MOD) % MOD;
        res[0][1] = (A[0][0]*B[0][1] % MOD + A[0][1]*B[1][1] % MOD) % MOD;
        res[1][0] = (A[1][0]*B[0][0] % MOD + A[1][1]*B[1][0] % MOD) % MOD;
        res[1][1] = (A[1][0]*B[0][1] % MOD + A[1][1]*B[1][1] % MOD) % MOD;
        return res;
    }
}
