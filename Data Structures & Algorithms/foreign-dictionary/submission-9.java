class Solution {
  public String foreignDictionary(String[] words) {
      HashMap<Character, Set<Character>> map = new HashMap<>();
      HashMap<Character, Integer> indegree = new HashMap<>();
      int n = words.length;

      for(String word : words){
        for(char c : word.toCharArray()){
          map.putIfAbsent(c, new HashSet<Character>());
          indegree.putIfAbsent(c, 0);
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
            indegree.put(c2, indegree.get(c2)+1);
            break;
          }
        }
      }
      Queue<Character> queue = new LinkedList<>();
      for(Map.Entry<Character, Integer> entry : indegree.entrySet()){
        if(entry.getValue() == 0)
          queue.add(entry.getKey());
      }
      StringBuilder builder = new StringBuilder();
      while(!queue.isEmpty()){
        char c = queue.poll();
        builder.append(c);
        for(char newChar : map.get(c)){
          indegree.put(newChar, indegree.get(newChar) - 1);
          if(indegree.get(newChar) == 0)
          queue.add(newChar);
        }
      }
      if (builder.length() != indegree.size()) {
            return "";
        }
      return builder.toString();
    }
}
