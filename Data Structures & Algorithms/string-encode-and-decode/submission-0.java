class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder("");
        for(String str : strs){
            res.append(str.length());
            res.append("%");
            res.append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int idx = 0;
        int len = 0;
        while(idx<str.length()){
            while(str.charAt(idx)!='%'){
                len = len*10 + (str.charAt(idx) - '0');
                idx++;
            }
            res.add(str.substring(idx+1,len+idx+1));
            idx+= len+1;
            len = 0;
        }
        return res;
    }
}
