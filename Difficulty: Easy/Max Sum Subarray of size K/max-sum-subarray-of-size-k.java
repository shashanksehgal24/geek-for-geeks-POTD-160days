class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        
        int windowSum = 0;

        for(int i = 0; i < k; i++){
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        for(int i = k; i < arr.length; i++){
            windowSum = windowSum + arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}