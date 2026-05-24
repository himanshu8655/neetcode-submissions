class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> hmp = new HashMap<>();
        for(int i = 0; i<n; i++){
            int num = nums[i];
            if(hmp.containsKey(num))
                return new int[]{hmp.get(num), i};
            int diff = target - num;
            hmp.put(diff, i);
        }
        return new int[]{};
    }
}
