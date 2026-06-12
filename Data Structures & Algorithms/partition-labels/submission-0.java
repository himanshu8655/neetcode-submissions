class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> hmp = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int n = s.length();
        for(int i = n-1; i>=0; i--){
            char c = s.charAt(i);
            hmp.putIfAbsent(c, i);
        }
        //xyxxyzbzbbisl
        int idx = 0;
        int left = 0;
        int right = 1;
        while(idx<s.length()){
            char c = s.charAt(idx);//x
            right = Math.max(right, hmp.get(c)); //4
            if(idx >= right){
                result.add(right - left + 1);
                left = idx + 1;
            }
            idx++;
        }
        return result;
    }
}
