class Solution:
    def minFallingPathSum(self, grid: List[List[int]]) -> int:
        n = len(grid)
        
        # Start with the first row's elements
        dp = grid[0][:]
        
        # Iterate over each row starting from the second one
        for i in range(1, n):
            new_dp = [float('inf')] * n  # Initialize a new DP array for the current row
            
            for j in range(n):
                # Find the minimum value in the previous row excluding the current column
                min_val = float('inf')
                for k in range(n):
                    if k != j:
                        min_val = min(min_val, dp[k])
                
                # Update the current dp value
                new_dp[j] = grid[i][j] + min_val
            
            # Move to the next row, update dp
            dp = new_dp
        
        # The answer is the minimum value in the last dp array
        return min(dp)

# Example usage:
grid = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
solution = Solution()
result = solution.minFallingPathSum(grid)
print(result)  # Output should be 13
