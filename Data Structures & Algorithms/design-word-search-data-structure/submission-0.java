class WordDictionary {

    class Trie{
        HashMap<Character, Trie> nodes;
        boolean isEnd;
        Trie(){
            this.isEnd = false;
            this.nodes = new HashMap<>();
        }

        public void addWord(String s){
            Trie temp = this;
            for(char c :s.toCharArray()){
                if(!temp.nodes.containsKey(c))
                    temp.nodes.put(c, new Trie());
                temp = temp.nodes.get(c);
            }
            temp.isEnd = true;
        }

    }

    Trie head;

    public WordDictionary() {
        head = new Trie();
    }

    public void addWord(String word) {
        head.addWord(word);
    }

    public boolean search(String word) {
        return helper(0, word, head);
    }

    public boolean helper(int i, String word, Trie head){
        if(i>=word.length())
            return head.isEnd;
        
        char c = word.charAt(i);
        if(c == '.'){
            for(Trie newNode : head.nodes.values()){
                if(helper(i+1, word, newNode))
                    return true;
            }
        }

        else if(!head.nodes.containsKey(c)){
            return false;
        }

        else{
            return helper(i+1, word, head.nodes.get(c));
        }
        return false;
    }
}
