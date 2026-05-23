class Solution {
    String[] map = {"", "", "abc", "def","ghi", "jkl", "mno","pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        fnc(digits, ans, 0, "");
        return ans;
    }

    private void fnc(String digits,List<String> ans,int ind, String ds){
        if(ind == digits.length()){
            ans.add(ds);
            return;
        }

        String s = map[digits.charAt(ind) - '0'];

        for(int i=0; i<s.length(); i++){
            fnc(digits,ans,ind+1,ds + s.charAt(i));
        }
    }
}