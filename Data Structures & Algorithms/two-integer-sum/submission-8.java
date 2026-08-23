class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hmp = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            int num = nums[i];
            if(hmp.containsKey(num))
                return new int[]{hmp.get(num), i};
            
            else hmp.put(target-num, i);
        }
        return new int[]{};
    }
}
