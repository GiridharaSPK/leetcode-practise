class Solution {
    public int[] frequencySort(int[] ar) {
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for(int i = 0; i < ar.length; i++){
            freq.put(ar[i], freq.getOrDefault(ar[i], 0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->
                                (freq.get(a) == freq.get(b) ? b-a : freq.get(a)-freq.get(b)));
        pq.addAll(freq.keySet());
        
        int[] ans = new int[ar.length];
        int i = 0;
        while(!pq.isEmpty()){
            int num = pq.poll();
            int count = freq.get(num);
            while(count > 0){
                ans[i] = num;
                count--;
                i++;
            }
        }
        return ans;
    }
}