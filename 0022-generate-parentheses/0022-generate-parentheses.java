class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        fnc(ans, n, 0, 0, "");
        return ans;
    }

    public void fnc(List<String> ans, int n, int open, int close, String curr_str) {
        //base case
        if (curr_str.length() == n * 2) {
            ans.add(curr_str);
            return;
        }

        if (open < n)
            fnc(ans, n, open + 1, close, curr_str + "(");
        if (close < open)
            fnc(ans, n, open, close + 1, curr_str + ")");

    }
}