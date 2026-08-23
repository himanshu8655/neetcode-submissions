class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str : strs){
            char[] sortedStr = str.toCharArray();
            Arrays.sort(sortedStr);
            String newString = new String(sortedStr);
            map.computeIfAbsent(newString, k-> new ArrayList<>()).add(str);
        }

        return new ArrayList<List<String>>(map.values());
    }
}
