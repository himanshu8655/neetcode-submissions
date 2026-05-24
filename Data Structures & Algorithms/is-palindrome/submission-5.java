class Solution {
    public boolean isPalindrome(String s) {
        s = s.replace(" ", "");
        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        char[] charArray = s.toCharArray();
        int n = charArray.length;

        for(int i = 0; i<n/2; i++){
            if(charArray[i] != charArray[n - 1 - i])
                return false;
        }
        return true;
    }
}
