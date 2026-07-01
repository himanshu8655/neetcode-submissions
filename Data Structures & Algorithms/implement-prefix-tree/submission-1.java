class PrefixTree {
    Trie head;
    class Trie{
        HashMap<Character, Trie> nodes;
        boolean isEnd;

        Trie(){
        nodes = new HashMap<>();
        isEnd = false;
        }

        public void insert(String word){
            Trie head = this;
            if(word == null || word == "")
                return;
            
            for(char c : word.toCharArray()){
                head.nodes.putIfAbsent(c, new Trie());
                    head = head.nodes.get(c);
            }
            head.isEnd = true;
        }

        

        public boolean search(String word, boolean isFullSearch){
            Trie head = this;
            if(word == null || word == "")
                return true;
            
            for(char c : word.toCharArray()){
                if(head.nodes.containsKey(c)){
                    head = head.nodes.get(c);
                }
                else{
                    return false;
                }
            }
            return isFullSearch ? head.isEnd : true;
        }
    }

    public PrefixTree() {
       
        head = new Trie();
    }

    public void insert(String word) {
        head.insert(word);
    }

    public boolean search(String word) {
        return head.search(word, true);
    }

    public boolean startsWith(String prefix) {
        return head.search(prefix, false);
    }
}
