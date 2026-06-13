class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currentGas = 0;
        int startIndex = 0;
        int totalUsage = 0;
        for(int i = 0; i<gas.length; i++){
            currentGas+= gas[i] - cost[i];
            totalUsage+=gas[i] - cost[i];
            if(currentGas<0){
                startIndex = i+1;
                currentGas = 0;
            }
                
        }
        if(totalUsage<0)
            return -1;
        return currentGas>=0 ? startIndex : -1;
    }
}
