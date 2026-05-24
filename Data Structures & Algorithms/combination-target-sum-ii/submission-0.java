class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(0,0,new ArrayList<Integer>(), candidates,target,res);
        return res;
    }
    public void combinationSum2(int index, int sum, ArrayList<Integer> soln,int[] candidates,int target, List<List<Integer>> res){
        if(sum == target)
        res.add(new ArrayList<>(soln));
        for(int i = index;i<candidates.length;i++){
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            soln.add(candidates[i]);
            combinationSum2(i + 1,sum + candidates[i],soln, candidates,target,res);
            soln.remove(soln.size() - 1);
        }
    }
}