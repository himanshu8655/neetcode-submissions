class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^0-9a-zA-Z]", "");
        char[] charArray = s.toCharArray();
        System.out.println(s);
        int left = 0;
        int right = charArray.length - 1;
        while(left<right){
            if(charArray[left] != charArray[right])
                return false;
            left++;
            right--;
        }
    return true;
    }
}
