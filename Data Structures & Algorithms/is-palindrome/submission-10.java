class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder strBuilder = new StringBuilder("");

        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isAlphabetic(c) || Character.isDigit(c)){
                strBuilder.append(c);
            }
        }

        String trimmedString = strBuilder.toString().toLowerCase();
        System.out.println(trimmedString);
        int left = 0;
        int right = trimmedString.length() - 1;

        while(left<right){
            if(trimmedString.charAt(left) != trimmedString.charAt(right))
                return false;
            left++;
            right--;
        }

        return true;
    }
}
