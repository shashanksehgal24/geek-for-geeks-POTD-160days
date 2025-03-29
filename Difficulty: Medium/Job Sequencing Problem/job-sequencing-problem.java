//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

class Solution {
     private int find(int parent[], int i) {
         if (parent[i] == i) return i;
         return parent[i] = find(parent, parent[i]);  // Path compression
     }
 
     public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
         int n = deadline.length;
         int maxDeadline = 0;
 
         // Create jobs array to store deadline & profit together
         int[][] jobs = new int[n][2];
         for (int i = 0; i < n; i++) {
             jobs[i][0] = deadline[i];
             jobs[i][1] = profit[i];
             maxDeadline = Math.max(maxDeadline, deadline[i]);
         }
 
         // Sort jobs by profit in descending order
         Arrays.sort(jobs, (a, b) -> b[1] - a[1]);
 
         // Create parent array for Disjoint Set (Union-Find)
         int[] parent = new int[maxDeadline + 1];
         for (int i = 0; i <= maxDeadline; i++) {
             parent[i] = i; // Each slot points to itself initially
         }
 
         int countJobs = 0, totalProfit = 0;
 
         for (int[] job : jobs) {
             int d = job[0]; // Deadline of the job
             int availableSlot = find(parent, d); // Find latest available slot
 
             if (availableSlot > 0) { // If slot is available
                 countJobs++;
                 totalProfit += job[1];
                 parent[availableSlot] = find(parent, availableSlot - 1); // Union to previous slot
             }
         }
 
         return new ArrayList<>(Arrays.asList(countJobs, totalProfit));
     }
 }

//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());

        while (t-- > 0) {
            String[] deadlineInput = sc.nextLine().trim().split("\\s+");
            int[] deadline =
                Arrays.stream(deadlineInput).mapToInt(Integer::parseInt).toArray();

            String[] profitInput = sc.nextLine().trim().split("\\s+");
            int[] profit =
                Arrays.stream(profitInput).mapToInt(Integer::parseInt).toArray();
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.jobSequencing(deadline, profit);
            System.out.println(result.get(0) + " " + result.get(1));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends