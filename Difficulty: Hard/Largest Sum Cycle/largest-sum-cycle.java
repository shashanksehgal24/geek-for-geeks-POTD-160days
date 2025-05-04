//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;


class GFG{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }

        Long nextLong(){
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws IOException
    {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t-- > 0){
            int N = sc.nextInt();
            int Edge[] = new int[N];
            for(int i = 0; i < N; i++)
                Edge[i] = sc.nextInt();
            Solution ob = new Solution();
            long ans = ob.largesSumCycle(N, Edge);
            out.println(ans);            
        
out.println("~");
}
        out.flush();
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public long largesSumCycle(int N, int Edge[]) {
        boolean[] visited = new boolean[N];
        boolean[] pathVisited = new boolean[N];
        int[] nodeToStep = new int[N];
        long maxCycleSum = -1;

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                Map<Integer, Integer> pathMap = new HashMap<>();
                dfs(i, Edge, visited, pathVisited, nodeToStep, 0, pathMap);

                if (cycleSum > maxCycleSum) {
                    maxCycleSum = cycleSum;
                }
                cycleSum = -1; // reset after each DFS
            }
        }

        return maxCycleSum;
    }

    long cycleSum = -1;

    private void dfs(int node, int[] Edge, boolean[] visited, boolean[] pathVisited,
                     int[] nodeToStep, int step, Map<Integer, Integer> pathMap) {
        visited[node] = true;
        pathVisited[node] = true;
        pathMap.put(node, step);

        int next = Edge[node];
        if (next != -1) {
            if (!visited[next]) {
                dfs(next, Edge, visited, pathVisited, nodeToStep, step + 1, pathMap);
            } else if (pathVisited[next]) {
                // Cycle detected
                long sum = 0;
                for (Map.Entry<Integer, Integer> entry : pathMap.entrySet()) {
                    if (entry.getValue() >= pathMap.get(next)) {
                        sum += entry.getKey();
                    }
                }
                cycleSum = Math.max(cycleSum, sum);
            }
        }

        pathVisited[node] = false;
    }
}
