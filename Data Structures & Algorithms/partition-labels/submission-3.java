class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        HashMap<Character, Integer> hmp = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i = n-1; i>=0; i--){
            hmp.putIfAbsent(s.charAt(i), i);
        }
        int currMax = -1;
        int left = 0;
        for(int i = 0; i<n; i++){
            char c = s.charAt(i);
            currMax = Math.max(currMax, hmp.get(c));
            if(i == currMax){
                list.add(i - left + 1);
                left = i+1;
            }
        }
        return list;
    }
}
