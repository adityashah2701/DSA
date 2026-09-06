class Solution {
    public boolean check(String s1, String s2) {
        if(s1.length() != s2.length() + 1) return false;
        int i = 0, j = 0;

        while(i < s1.length() && j < s2.length()) {
            if(s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == s2.length();
    }
    public int longestStrChain(String[] words) {
        int n = words.length;
        int[] dp = new int[n];
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (check(words[i], words[prev])) {
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
                }
            }

            ans = Math.max(ans, dp[i]);
        }

    return ans;
}}