class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int n = gas.length;
        int result = -1;
        int gasCheck = 0;
        for(int i = 0; i<n; i++){
            totalGas+= gas[i] - cost[i];
            gasCheck+=gas[i] - cost[i];
            if(totalGas<0){
                totalGas = 0;
                result = i+1;
            }
                
        }
        if(gasCheck<0)
            return -1;
        return result == n ? -1 : result;
    }
}
