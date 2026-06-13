class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currentGas = 0;
        int startIndex = 0;
        for(int i = 0; i<gas.length; i++){
            currentGas+= gas[i] - cost[i];
            if(currentGas<0)
                startIndex = i+1;
        }
        return currentGas>=0 ? startIndex : -1;
    }
}
