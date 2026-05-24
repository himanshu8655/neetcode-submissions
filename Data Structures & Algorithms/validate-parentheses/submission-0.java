class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(isOpenParantheses(c))
                stack.offerLast(c);
            else{
                if(stack.isEmpty())
                    return false;
                char lastBracket = stack.pollLast();
                if(c!=opposite(lastBracket))
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public boolean isOpenParantheses(char c){
        if(c == '(' || c == '{' || c == '[')
            return true;
        
        else return false;
    }

    public char opposite(char c){
        if(c == '{')
            return '}';
    
        else if(c == '(')
            return ')';
        
        else if(c == '[')
            return ']';
        
        else return 'a';
    }
}
