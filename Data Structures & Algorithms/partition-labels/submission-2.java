class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        HashMap<Character, Integer> hmp = new HashMap<>();
        for(int i = n-1; i>=0; i--){
            hmp.putIfAbsent(s.charAt(i), i);
        }

        for(char c : s.toCharArray()){
            
        }
    }
}
