class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hmp = new HashMap<>();

        for(String str : strs){
            char[] sortedArray = str.toCharArray();
            Arrays.sort(sortedArray);
            hmp.computeIfAbsent(String.valueOf(sortedArray), k-> new ArrayList<String>()).add(str);
        }

        return new ArrayList<List<String>>(hmp.values());
    }
}
