class Solution {
    public int[][] merge(int[][] intervals) {
         Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        ArrayList<int[]> res = new ArrayList<>();

        for(int[] interval : intervals){
            if(res.isEmpty()){
                res.add(interval);
                continue;
            }
            int[] prev = res.get(res.size() - 1);
            if(interval[0]>prev[1]){
                res.add(interval);
            }
            else{
                res.remove(res.size() - 1);
                res.add(new int[]{Math.min(prev[0], interval[0]), Math.max(prev[1], interval[1])});
            }
        }

        int[][] arr = new int[res.size()][2];
        for(int i = 0; i<res.size(); i++){
            arr[i] = res.get(i);
        }

        return arr;
    }
}
