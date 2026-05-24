class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;

        for(int num : nums){
            set.add(num);
        }

        for(int num : nums){
            if(set.contains(num - 1))
                continue;
            
            int currMax = 1;
            while(set.contains(num + 1)){
                num++;
                currMax++;
            }
            res = Math.max(res, currMax);
        }

        return res;
          
    }
}
