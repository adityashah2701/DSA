class Solution {
    public static boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static int helper(int i, int n, String s, Integer[] dp) {
        if (i == n)
            return 0;
        if (dp[i] != null)
            return dp[i];
        int minCost = Integer.MAX_VALUE;

        for (int j = i; j < n; j++) {
            if (isPalindrome(i, j, s)) {
                int cost = 1 + helper(j + 1, n, s, dp);
                minCost = Math.min(cost, minCost);
            }
        }

        return dp[i] = minCost;
    }

    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int minCost = Integer.MAX_VALUE;

            for (int j = n - 1; j >= i; j--) {
                if (isPalindrome(i, j, s)) {
                    int cost = 1 + dp[j + 1];
                    minCost = Math.min(cost, minCost);
                }
            }

             dp[i] = minCost;
        }

        return dp[0] - 1;
    }
}