class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int startIndex = 0;
        int currentGas = 0;
        int n = gas.length;
        for(int i = 0; i<n; i++){
            int diff = gas[i] - cost[i];
            totalGas+=diff;
            currentGas+=diff;
            if(currentGas<0){
                currentGas = 0;
                startIndex = i+1;
            }
                
        }

        return totalGas>=0?startIndex:-1;
    }
}
