class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        // [[1,3],[6,9]] + [4,5] - insert bw
        // [[1,3],[6,9]] + [1,5]/[3,5] - update first
        // [[1,3],[6,9]] + [2,7]/[2,6] - merge both 
        // + [0,1]/[0,2]/[0,4]/[0,7] or [8,10]/[9,10]/[11,12]/[2,12]
        
        // divide the solution into 3 parts 
        // while before newInterval start 
        // while insert/merge happening - only 1 insertion
        // while after newInterval end
        // doing in order avoids additional conditions in if-elses
        
        ArrayList<int[]> list = new ArrayList();
        if(intervals.length == 0){
            list.add(newInterval);
        }else{
            int i = 0;
            while(i < intervals.length && intervals[i][1] < newInterval[0]){
                list.add(intervals[i]);
                i++;
            }
                // insert and merge - add only 1 element to list
            int[] temp = {newInterval[0], newInterval[1]};
            // while in overlapping intervals 
            // or end of newInterval is greater than start of traversing ptr
            while(i < intervals.length && intervals[i][0] <= newInterval[1]){
                temp[0] = Math.min(temp[0], intervals[i][0]);
                temp[1] = Math.max(temp[1], intervals[i][1]);
                i++;
            }
            list.add(temp);
            while(i < intervals.length && intervals[i][0] > newInterval[1]){
                list.add(intervals[i]);
                i+=1;
            }
        }
        return list.toArray(new int[list.size()][]);
        
        /* tried with binary search - newInterval w/out overlap logic fails - TODO try later
        ArrayList<int[]> list = new ArrayList(Arrays.asList(intervals));
        // binary search for start and end pos
        int startPos = search(list, newInterval[0]); 
        int endPos = search(list, newInterval[1]); 
        int min = newInterval[0];
        int max = newInterval[1];
        
        for(int i = startPos; i <= endPos; i++){
            min = Math.min(min, list.get(i)[0]);
            max = Math.max(max, list.get(i)[1]);
        }

        int count = 0;
        while(count < (endPos - startPos + 1)){
            list.remove(startPos);
            count++;
        }
        int[] temp = {min, max};
        list.add(startPos, temp);
        return list.toArray(new int[list.size()][]);  */
    }
    
    private int search(ArrayList<int[]> list, int key){
        int l = 0;
        int h = list.size()-1;
        if(list.get(l)[0] > key)
            return l;
        if(list.get(h)[1] < key)
            return h;
        
        int mid = 0;
        int[] cur;
        
        while(l < h){
            mid = l + (h-l)/2;
            cur = list.get(mid);
            if((cur[0] <= key && key <= cur[1])
               ||(cur[1] < key && key < list.get(mid+1)[0])
               ||(cur[0] > key && key > list.get(mid-1)[1])
              ){
                return mid;
            }else if(cur[0] < key && cur[1] < key){
                l = mid+1;
            }else if(cur[0] > key && cur[1] > key){
                h = mid-1;
            }else{
                //nothing
            }
        }
        if(l < list.size()){
            cur = list.get(l);
            if(cur[0] <= key && key < cur[1]){
                return l;
            }
        }
        if(h >= 0){
            cur = list.get(h);
            if(cur[0] <= key && key < cur[1]){
                return h;
            }
        }
        return -1;   
    }
    
}