class Solution {
    public String foreignDictionary(String[] words) {
        // Step 1: Initialize adjacency list and in-degree map for every unique char
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new ArrayList<>());
                inDegree.putIfAbsent(c, 0);
            }
        }

        // Step 2: Build edges by comparing adjacent word pairs
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());
            boolean foundDiff = false;

            for (int j = 0; j < minLen; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);

                if (c1 != c2) {
                    adj.get(c1).add(c2);
                    inDegree.put(c2, inDegree.get(c2) + 1);
                    foundDiff = true;
                    break; // ← only the FIRST difference gives ordering info
                }
            }

            // "apple" before "app" is invalid (prefix rule)
            if (!foundDiff && w1.length() > w2.length()) {
                return "";
            }
        }

        // Step 3: Kahn's BFS — enqueue all nodes with in-degree 0
        Queue<Character> queue = new LinkedList<>();
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        // Step 4: Process queue, build result
        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {
            char c = queue.poll();
            result.append(c);

            for (char neighbor : adj.get(c)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Step 5: Cycle check — if not all chars included, a cycle exists
        if (result.length() != inDegree.size()) {
            return "";
        }

        return result.toString();
    }
}