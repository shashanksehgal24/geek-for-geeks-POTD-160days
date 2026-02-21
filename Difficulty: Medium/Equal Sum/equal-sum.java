// User function Template for Java

class Solution {
    String equilibrium(int arr[]) {
        // code here
        int n=arr.length;
        int s=0;
        for(int i =0;i<n;i++){
            s=s+arr[i];
          
        }
        
        int l=0;
        int r=0;
        for(int i =0;i<n;i++){
            r=s-l-arr[i];
            if(l==r){
                return "true";
            }
            l+=arr[i];
          
        }
        return "false";
    }
}