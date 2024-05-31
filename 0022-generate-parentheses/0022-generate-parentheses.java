class Solution {
    public List<String> generateParenthesis(int n) {
        // dynamic programming approach - sumeet
        List<String>[] dp = new List[n+1]; // dont use List<Stirng>[n+1] 
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
        
        return dp[n];
    }
}