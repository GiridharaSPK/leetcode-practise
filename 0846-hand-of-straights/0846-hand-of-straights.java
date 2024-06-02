class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;

        // to store count of each int
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        // to retrieve in consecutive order
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        // to store polled elements with > 0 count from pq
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < n; i++){
            if(count.containsKey(hand[i])){
                count.put(hand[i], count.get(hand[i])+1);
            }else{
                count.put(hand[i], 1);
                pq.offer(hand[i]);
            }
        }
        
        int c = 0;
        while(!pq.isEmpty() || !q.isEmpty()){
            c = 0;
            while(!q.isEmpty()){
                pq.offer(q.poll());
            }
            int prev = pq.peek()-1;
            while(c < groupSize){
                if(pq.isEmpty()) 
                    return false;
                int least = pq.poll();
                if(prev == least-1){
                    prev = least;
                    if(count.get(least) == 1){
                        count.remove(least); 
                    }else{
                        q.offer(least);
                        count.put(least, count.get(least)-1);
                    }
                }else{
                    return false;
                }
                c++;
            }
        }
        return true;
    }
}