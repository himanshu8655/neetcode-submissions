class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagrams = new HashMap<>();

        for(String str : strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            anagrams.computeIfAbsent(new String(arr), k-> new ArrayList<String>()).add(str);
        }

        return new ArrayList<List<String>>(anagrams.values());
    }
}
