/*
遍历wordDict来找s中的字符串来加速
String.join(" ", backStr)
*/
class Solution {
    List<String> res;
    List<String> wordDict;
    List<String> backStr = new LinkedList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        res = new ArrayList<>();
        this.wordDict = wordDict;
        dp(s, 0);
        return res;
    }
    public void dp(String s, int l){
        if(l == s.length()){
            res.add(String.join(" ", backStr));
            return;
        }
        for(String word : wordDict){
            int e = l + word.length();
            if(e > s.length()) continue; // 长度过了
            if(s.substring(l, l+word.length()).equals(word)){
                backStr.add(word);
                dp(s, e);
                backStr.remove(backStr.size()-1);
            }
        }
    }
}
