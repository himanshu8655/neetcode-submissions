class Solution {
  public String foreignDictionary(String[] words) {
      HashMap<Character, Set<Character>> map = new HashMap<>();
      Set<Character> set = new HashSet<>();
      int n = words.length;

      for(String word : words){
        for(char c : word.toCharArray()){
          map.putIfAbsent(c, new HashSet<Character>());
          set.add(c);
        }
      }

      for(int i = 1; i<n; i++){
        String word1 = words[i-1];
        String word2 = words[i];
        int m = word1.length();
        
        for(int j = 0; j<m; j++){
          char c1 = word1.charAt(j);
          if(j == word2.length()){
            return "";  
          }
          char c2 = word2.charAt(j);

          if(c1!=c2){
            map.get(c1).add(c2);
            set.remove(c2);
            break;
          }
        }
      }
      Queue<Character> queue = new LinkedList<>(set);
      StringBuilder builder = new StringBuilder();
      while(!queue.isEmpty()){
        char c = queue.poll();
        builder.append(c);
        for(char newChar : map.get(c)){
          queue.add(newChar);
        }
      }
      

      return builder.toString();
    }
}
