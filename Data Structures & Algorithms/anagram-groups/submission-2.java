class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hmp = new HashMap<>();

        for(String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            hmp.computeIfAbsent(new String(charArray),k->new ArrayList<>()).add(str);
        }

        return new ArrayList<List<String>>(hmp.values());
    }
}
