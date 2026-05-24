class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        Set<Integer> set = new HashSet<>();
        int result = 1;
        for(int num : nums){
            set.add(num);
        }

        for(int num : nums){
            if(set.contains(num - 1))
                continue;
            int curr_max = 1;
            while(set.contains(num + 1)){
                curr_max++;
                num++;
            }
            result = Math.max(curr_max, result);
            
        }
        return result;
    }
}
