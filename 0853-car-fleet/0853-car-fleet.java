class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
       /* int n = position.length;
        int[] time = new int[n];
        for(int i = 0; i < n; i++){
            time[i] = (target - position[i]) / speed[i]; // assuming all positions didnt reach target
        }
        // pos 
        // spe 2 4  1 1 3
        //time 1 1 12 7 3
        Stack<Integer> s = new Stack<Integer>();
        int fleet = 0;
        for(int i = n-1; i > 0; i--){
            if(s.isEmpty() || (s.peek() < time[i] && speed[i] <= speed[i-1])){
                fleet++;
            }
            s.push(time[i]);
        }
        return fleet;
    }*/
        
        int n = position.length;
        double[] time = new double[n];
        
        // Calculate time to reach the target for each car
        for (int i = 0; i < n; i++) {
            time[i] = (double)(target - position[i]) / speed[i];
        }
        
        // Create a pairs of position and time, then sort by position
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = time[i];
        }
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0])); // Sort by position descending
        
        // Count the fleets
        int fleets = 0;
        double prevTime = 0;
        
        for (int i = 0; i < n; i++) {
            if (cars[i][1] > prevTime) {
                fleets++;
                prevTime = cars[i][1]; // Update the previous time to current car's time
            }
        }
        
        return fleets;
    }
}