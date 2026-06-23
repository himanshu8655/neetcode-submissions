class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        HashMap<Character, Integer> lastIndexMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i<n; i++){
            char c = s.charAt(i);
            lastIndexMap.put(c, i);
        }
        int maxTravel = 0;
        int left = 0;
        for(int i = 0; i<n; i++){
            char c = s.charAt(i);
            maxTravel = Math.max(maxTravel, lastIndexMap.get(c));
            if(maxTravel == i){
                result.add(i - left+1);
                left = i+1;
            }
        }

        return result; 
    }
}
