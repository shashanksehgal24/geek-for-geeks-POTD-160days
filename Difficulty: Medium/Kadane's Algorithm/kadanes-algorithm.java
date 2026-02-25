class Solution {
    int maxSubarraySum(int[] arr) {
        // Code here
       int a=arr[0];
        int b=arr[0];
        for(int i=1;i<arr.length;i++){
        a=Math.max(arr[i],a+arr[i]);
        b=Math.max(a,b);
           
           
        }
        return b;
    }
}
