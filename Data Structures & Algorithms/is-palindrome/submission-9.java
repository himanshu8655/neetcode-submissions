class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder strBuilder = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c) || Character.isAlphabetic(c)){
                strBuilder.append(Character.toLowerCase(c));
            }
        }

        String newString = strBuilder.toString();

        int left = 0;
        int right = newString.length() - 1;

        while(left<right){
            if(newString.charAt(left) != newString.charAt(right))
                return false;
            left++;
            right--;
        }  
        return true;
    }
}
