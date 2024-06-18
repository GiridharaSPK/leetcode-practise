class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        // Create an array of pairs
        Pair[] pairs = new Pair[difficulty.length];
        for (int i = 0; i < difficulty.length; i++) {
            pairs[i] = new Pair(difficulty[i], profit[i]);
        }
        
        Arrays.sort(pairs, Comparator.comparingInt(pair -> pair.profit));

        // Extract the sorted difficulties and profits
        for (int i = 0; i < difficulty.length; i++) {
            difficulty[i] = pairs[i].difficulty;
            profit[i] = pairs[i].profit;
        }

        Arrays.sort(worker);
        
        int p = 0;
        int w = worker.length-1; 
        int d = difficulty.length-1; 
        while(w >= 0 && d>=0){
            if(difficulty[d] <= worker[w]){
                p += profit[d];
                w--;
            }else{
                d--;
            }
        }
        return p;
    }
    
     class Pair {
            int difficulty;
            int profit;
            Pair(int difficulty, int profit) {
                this.difficulty = difficulty;
                this.profit = profit;
            }
        }
}