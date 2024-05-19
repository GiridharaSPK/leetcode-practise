- DP on Trees - Aditya verma approach
  - return solve(root​, res) // TreeNode root, int[] res // in the current code declared as max
  - not initialising res with [0] as it dominates if all the inputs are negative
  - res = {root.val} // this step has to be implementation specific
- the helper function (here solve()) does 3 things 
- 1) base case handling (root == null) return 0 // has to be implmentation specific
- 2) recursion over left and right nodes
- 3) check if node itself is the answer or just contributes to answer
  - 3.1) if node contributes to answer, only 1 child (max of left and right) and itself will be part of ans
            Math.max(curr, Math.max(left, right) + curr) // add left or right only if they are positively contributing
  - 3.2) if node can be the answer store, left+right+current node will be answer and store in the global state
  - 3.3) global state has to be the max of 3.1 and 3.2 Math.max(l+r+c, 1+Math.max(l,r))
         and itself Math.max(res[0], Math.max(l+r+c, cur)
- the final answer is the main function to check if res could be the answer or root node
