// User function Template for Java
import java.util.*; 
class Solution {
    static int[] replaceWithRank(int arr[], int n) {
        // code here
        int [] a=arr.clone();
        Arrays.sort(a);
        
         HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        
        for (int value : a) {
            if (!rankMap.containsKey(value)) {
                rankMap.put(value, rank);
                rank++;
            }
        }
        for (int i = 0; i < n; i++) {
            arr[i] = rankMap.get(arr[i]);
        }

        return arr;
        
    }
}
