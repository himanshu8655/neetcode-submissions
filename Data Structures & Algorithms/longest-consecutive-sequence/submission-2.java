class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;

        for(int num : nums){
            set.add(num);
        }
        
        for(int num : nums){
            int currMax = 1;
            if(set.contains(num - 1))
                continue;
            
            while(set.contains(num + 1)){
                currMax++;
                num++;
            }
            res = Math.max(res, currMax);
        }

        return res;
    }
}
