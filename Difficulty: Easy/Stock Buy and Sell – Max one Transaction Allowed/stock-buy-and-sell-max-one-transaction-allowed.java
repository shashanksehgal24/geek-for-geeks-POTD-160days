class Solution {
    public int maxProfit(int[] arr) {
        // Code here
        int a=0;
        for(int i=0;i<arr.length;i++){
            int max=0;
            for(int j=i;j<arr.length;j++){
                max=arr[j]-arr[i];
                a=Math.max(max,a);
            }
        }
    return a;}
}