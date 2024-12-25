#User function Template for python3

class Solution:
    def maxSubArraySum(self, arr):
        max_so_far = float('-inf')
        max_ending_here = 0
        
        for num in arr:
            max_ending_here += num
            if max_ending_here > max_so_far:
                max_so_far = max_ending_here
            if max_ending_here < 0:
                max_ending_here = 0
        
        return max_so_far

#{ 
 # Driver Code Starts
#Initial Template for Python 3

import math


def main():
    T = int(input())
    while (T > 0):

        arr = [int(x) for x in input().strip().split()]

        ob = Solution()

        print(ob.maxSubArraySum(arr))

        T -= 1


if __name__ == "__main__":
    main()

# } Driver Code Ends