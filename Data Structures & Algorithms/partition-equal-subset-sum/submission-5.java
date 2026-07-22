class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int target = Arrays.stream(nums).max().getAsInt();
        if(target%2 == 1)
            return false;
            target=target/2;
        Set<Integer> set1 = new HashSet<>();
        set1.add(0);
        for(int num : nums){
            Set<Integer> set2 = new HashSet<>();
            for(int a : set1){
                set2.add(a);
                set2.add(a + num);
                if(a + num == target)
                    return true;
            }
            set1 = set2;
        }
        return false;
    }
}
