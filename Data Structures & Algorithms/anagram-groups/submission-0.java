class Solution {
       public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> res = new HashMap<>();
        for(String s : strs){
            int[] freq = new int[26];
          char[] charArray = s.toCharArray();
          for(char c : charArray){
              freq[c - 'a']++;
          }
          res.computeIfAbsent(Arrays.toString(freq), k->new ArrayList<>()).add(s);
        }
        return new ArrayList<>(res.values());
      }
}
