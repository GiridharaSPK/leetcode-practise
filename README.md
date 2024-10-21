# leetcode-practise
Collection of LeetCode questions to ace the coding interview! - Created using [LeetHub] (https://github.com/QasimWani/LeetHub)  


## Arrays and Hashing:
1) [LC 1 - Two Sum](https://github.com/GiridharaSPK/leetcode-practise/tree/main/0001-two-sum) [EASY]  
   Approach 1 : In a nested loop, look for ar[i] = target - ar[j] [O(n^2) time + O(1) Space]  
   Approach 2 : Store (target - current) num in hashmap at each index return when found current number is in hashmap key [O(n) Time  + O(n) Space]   

## Strings:  

## Two Pointers:  

## Sliding Window:  

## Recursion:  
1) [LC 70 - Climbing Stairs](https://github.com/GiridharaSPK/leetcode-practise/tree/main/0070-climbing-stairs)
   handle base cases for n < 0 and n < 2, return sum of possibilities of n-1 and n-2   


## Dynamic Programming:   
1) [LC 70 - Climbing Stairs](https://github.com/GiridharaSPK/leetcode-practise/tree/main/0070-climbing-stairs)
  recursive to DP : dp[i-1] + dp[i-2], handle base cases dp[0]=1 and dp[1] = 1. dp array size is n+1 to return dp[n]


## Linked List:  

## Stacks:   

## Queues:   

## Trees:  

## Graphs:   

### Traversal  
1) [LC 200 - Number of Islands](https://github.com/GiridharaSPK/leetcode-practise/tree/main/0200-number-of-islands) [MEDIUM]  
   Approach 1 : DFS (visited array, directions array) [O(m * n) Time + O(m * n) Space (recursive stack)]  
   Approach 2 : BFS (visited array, directions array, Queue)[O(m * n) Time + O(m * n) Space]  
   If we can modify the matrix, instead of maintaining visited array, we can update value of matrix to save some space, but this still doesnt change the space complexity because the max length of an island can be m*n  

2) [LC 133 - Clone Graph](https://github.com/GiridharaSPK/leetcode-practise/tree/main/0133-clone-graph) [MEDIUM]  
   Approach 1 : DFS  
   Approach 2 : BFS  
   Clone each node (entirely) and put into a hashmap. Traverse and parallely link its connected nodes (* only add unvisited connected nodes to queue, but connect all neighbors)  
   Note that the node can be null as the graph can be empty.  
   [O(n) Time + O(n) Space]  

4) [LC 130 - Surrounded Regions](https://github.com/GiridharaSPK/leetcode-practise/tree/main/0130-surrounded-regions) [MEDIUM]  
DFS in the first and last rows and columns all Os to Vs (temp). And then convert all inner Os to Xs and then all Vs to Os. (Note : We can use same dfs function to update in all the convertions)  
    [O(n*m) Time + O(1) Space]   
    
5) [LC 967 - Numbers with Same Consecutive Differences](https://github.com/GiridharaSPK/leetcode-practise/tree/main/0967-numbers-with-same-consecutive-differences)  
  Disguised graphs question  
  Approach 1 : DFS - loop from 1 to 9 (0 causes stackoverflow) call dfs(n, d, k, set) add and substract k, validate and update num until num of digits required becomes 0 then add to answers set (convert to array later)  
  Approach 2 : BFS - adding 1 to 9 in queue. (level order traversal - save size in each iteration) - loop until 'level == n' { poll from queue and add valid +k and -k numbers to queue }  
(at each level, digit count of all numbers in the queue increase)  
Pitfall 1: * appending numbers can be 0 so use (lastDigit - k >= 0) instead of (lastDigit - k > 0)  
Pitfall 2: ** avoid adding duplicates when k = 0 -> lastDigit - k will be equal to lastDigit + k
[O(2^n) Time + O(2^n) Space]  
(a noob approach of keeping tracking of digit count is by comparing with > Math.pow(10, n-1) & < Math.pow(10,n))  
    
6) [LC  - Rotten Oranges](https://github.com/GiridharaSPK/leetcode-practise/blob/main/0994-rotting-oranges/0994-rotting-oranges.java)
   Edge cases to not miss:  
   (i) all cannot rotten -> return -1  
   (ii) no rotten -> return -1  
   (iii) no fresh -> return 0  

   Approach 1 : intial all rotten oranges to queue and maintain original fresh count + BFS + use a visited set to mark rotten oranges at each iteration  
   Approach 2 : intial all rotten oranges to queue and maintain original fresh count + BFS + updated grid - update cell to 2 when adding a position to queue  

   after initial processing - storing intial rotten oranges and count of fresh oranges - handle edge cases  
   ```
   // no rotten oranges  
     if(q.isEmpty()){  
         // no fresh oranges - already at solution  
         if(count == 0){  
             return 0;  
         }  
         // there are fresh oranges but no rotten oranges  
         return -1;  
     }  
   ```
 Optimizations: in bfs loop add check for current fresh count > 0 check to avoid the above code  
 Note 1: check if fresh count is 0 in the end, if not return -1 (all the fresh oranges cant be reached)  
 Note 2: update minutes(+1) count after each bfs iteration i.e. when size becomes 0 and queue isNotEmpty(size reduces in inner loop inside bfs) - need not have a seperate if condition - writing it after while loop should be sufficient  
     
## Tries:

## Bit Manipulation: 

## Math: 
[LC 31 - Next Permutation](https://github.com/GiridharaSPK/leetcode-practise/tree/main/0031-next-permutation)  
Math or logical question. 
1) look for pivot from the end. 2) and swap with next greater element than pivot from the end. 3) then reverse the pivot+1 to end subarray

- could also be done with recursion

## Miscellanious: 



