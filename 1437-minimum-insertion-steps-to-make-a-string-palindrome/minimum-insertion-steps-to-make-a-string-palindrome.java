class Solution {
    public int minInsertions(String s) {
          int n = s.length();
        String t = new StringBuilder(s).reverse().toString();
        int m = t.length();
        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];

        for (int j = 0; j < m; j++)
            prev[j] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    cur[j] = 1 + prev[j - 1];
                } else
                    cur[j] = Math.max(prev[j], cur[j - 1]);
            }
            int[] temp = prev;
            prev = cur;
            cur = temp;
        }
        
        return  n - prev[m];
    }
}