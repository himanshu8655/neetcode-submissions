class Solution {
    public boolean checkValidString(String s) {
        return helper(0, s, 0);
    }

    public boolean helper(int i, String s, int openBrackets){
        if(i == s.length())
            return openBrackets == 0;
        
        char c = s.charAt(i);
        if(c == '('){
            return helper(i+1, s, openBrackets+1);
        }
        if(c == ')'){
            if(openBrackets<1)
                return false;
            else return helper(i+1, s, openBrackets-1);
        }
        else{
            return helper(i+1, s, openBrackets+1)
            || helper(i+1, s, openBrackets-1)
            || helper(i+1, s, openBrackets);
            
        }

            
    }
}
