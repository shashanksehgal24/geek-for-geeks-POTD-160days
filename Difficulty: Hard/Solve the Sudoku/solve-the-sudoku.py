#User function Template for python3

class Solution:
    def solveSudoku(self, mat):
        self.backtrack(mat)
    
    def backtrack(self, mat):
        for i in range(9):
            for j in range(9):
                if mat[i][j] == 0:
                    for num in range(1, 10):
                        if self.is_valid(mat, i, j, num):
                            mat[i][j] = num
                            if self.backtrack(mat):
                                return True
                            mat[i][j] = 0
                    return False
        return True
    
    def is_valid(self, mat, row, col, num):
        for i in range(9):
            if mat[row][i] == num:
                return False
        for i in range(9):
            if mat[i][col] == num:
                return False
        start_row, start_col = 3 * (row // 3), 3 * (col // 3)
        for i in range(start_row, start_row + 3):
            for j in range(start_col, start_col + 3):
                if mat[i][j] == num:
                    return False
        return True
#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    import sys
    input = sys.stdin.read
    data = input().split()

    t = int(data[0])
    index = 1

    for _ in range(t):
        matrix = []
        n = 9
        for i in range(n):
            row = list(map(int, data[index:index + n]))
            matrix.append(row)
            index += n
        obj = Solution()
        obj.solveSudoku(matrix)
        for i in range(n):
            for j in range(n):
                print(matrix[i][j], end=" ")
            print()
        print("~")

# } Driver Code Ends