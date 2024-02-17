class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> f = new HashMap<Integer,Integer>();
        for(int i : arr){
            f.put(i, f.getOrDefault(i, 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(f.values());
        while(k > 0){
            k = k - pq.poll();
        }
        return k < 0? pq.size()+1 : pq.size();
    }
}