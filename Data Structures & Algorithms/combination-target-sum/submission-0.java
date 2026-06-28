class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(0, nums, 0, target, new ArrayList<Integer>());
        return result;
    }

    public void dfs(int i, int[] nums, int sum,  int target, List<Integer> list){
        if(sum == target){
            result.add(new ArrayList<>(list));
            return;
        }

        if(sum>target || i>=nums.length)
            return;

        
            list.add(nums[i]);
            dfs(i, nums, sum + nums[i], target, list);
            list.remove(list.size() - 1);
            dfs(i + 1, nums, sum, target, list);

    }
}
