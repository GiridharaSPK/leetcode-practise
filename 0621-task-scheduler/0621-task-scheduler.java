class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < tasks.length; i++){
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> b - a);
        for(char key : map.keySet()){
            pq.offer(map.get(key));
        }
        
        int max_freq = pq.poll();
        int idle = (max_freq-1) * n;
        while(!pq.isEmpty()){
            idle -= Math.min(pq.poll(), max_freq-1);
        }
        if(idle < 0) return tasks.length;
        return idle + tasks.length;
    }
}