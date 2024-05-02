DFS:
- place where we mark visited is important - has to be in dfs function - at the first line of the code
- checking for grid[i][j] == '1' (char) has to be along with visited
​
BFS:
- prefer to use loop for bfs instead of recursion
- mark visited inside each iteration for current node
- queue has to be created for a particular bfs - in cases like this we run multiple bfs for different nodes