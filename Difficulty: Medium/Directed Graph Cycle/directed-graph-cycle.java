//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.isCyclic(V, edges);
            System.out.println(ans ? "true" : "false");
        }
        sc.close();
    }
}
// } Driver Code Ends

//il.*;

class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
        
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        // visited and recursion stack
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        // Perform DFS from each unvisited node
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, recStack))
                    return true; // cycle found
            }
        }

        return false; // no cycle
    }

    private boolean dfs(int node, List<List<Integer>> adj, boolean[] visited, boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, adj, visited, recStack))
                    return true;
            } else if (recStack[neighbor]) {
                return true; // cycle found
            }
        }

        recStack[node] = false; // backtrack
        return false;
    }
}
