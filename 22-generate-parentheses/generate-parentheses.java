class Solution {
    static void backtrack(String curr,int open, int close, int n, List<String> res) {
        if(curr.length() == n * 2) {
            res.add(curr);
            return;
        }

        if (open < n) backtrack(curr + "(", open + 1, close, n, res);
        if (close < open) backtrack(curr + ")" , open, close + 1, n , res);
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack("", 0, 0, n, res);
        return res;
    }
}