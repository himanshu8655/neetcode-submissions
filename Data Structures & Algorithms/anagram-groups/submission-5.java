class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagram = new HashMap<>();

        for(String str : strs){
            char[] sortedStringArray = str.toCharArray();
            Arrays.sort(sortedStringArray);
            String sortedString = new String(sortedStringArray);
            if(anagram.containsKey(sortedString)) anagram.get(sortedString).add(str);
            else anagram.put(sortedString, new ArrayList<String>(Arrays.asList(str)));
        }

        return new ArrayList<List<String>>(anagram.values());
    }
}
