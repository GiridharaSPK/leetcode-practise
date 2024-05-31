class Solution {
    public List<String> generateParenthesis(int n) {
        
        // recursion/ backtracking apporach 
        // keep generating brackets but with check on num of open and close brackets
        List<String> ans = new ArrayList<String>();
        helper(n, "", 0, 0, ans);
        return ans;
        
        // dynamic programming approach - sumeet
        /*List<String>[] dp = new List[n+1]; // dont use List<Stirng>[n+1] 
        dp[0] = Arrays.asList("");
        dp[1] = Arrays.asList("()");
        
        for(int i = 2; i <= n; i++){
            dp[i] = new ArrayList();
            // inner string lengths i-1 to 0 
            // dp[i] has 1 paranthesis '()'X or '('X')' 
            // so inner len + outer len = i-1

            // outer string lengths 0 to i-1
            int inner = i-1;
            int outer = 0;
            while(inner>=0 && outer<= i-1){ 
                for(String in : dp[inner]){
                    for(String out: dp[outer]){
                        StringBuilder sb = new StringBuilder();
                        sb.append("(");
                        sb.append(in);
                        sb.append(")");
                        sb.append(out);
                        dp[i].add(sb.toString());   
                    }
                }
                
                inner--;
                outer++;
            }
        }
        
        return dp[n];*/
    }
    
    private void helper(int n, String str,
                                 int openCount, int closedCount, 
                                 List<String> ans){
        
        if(openCount == n && closedCount == n){
            ans.add(str);
            return;
        }
        
        if(openCount < n){
            // str = str + "(";// dont use same string variable in both recursive calls
            helper(n, str+"(", openCount+1, closedCount, ans);
        }
        if(closedCount < openCount){ // count of ) should be <= count of (
            // str = str + ")";
            helper(n, str+")", openCount, closedCount+1, ans);
        }
        
    }
    
}