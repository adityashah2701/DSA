class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        int[][] a = new int[n][4];

        for(int i = 0; i < n; i++) {
            List<Integer> x = intervals.get(i);
            a[i] = new int[] {x.get(0),x.get(1),x.get(2),i};
        }

        Arrays.sort(a, (x , y) -> Integer.compare(x[1],y[1]));

        long[][] dp = new long[n + 1][5];

        List<Integer>[][] ans = new ArrayList[n + 1][5];

        for(int i = 0; i <= n; i++) 
            for(int k = 0; k <= 4; k++)
                ans[i][k] = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            int l = a[i - 1][0] , w = a[i-1][2],id = a[i-1][3];

            int p = 0, lo = 0, hi = i - 1;

            while(lo < hi) {
                int m = lo + (hi - lo)/2;
                if(a[m][1] < l) lo = m + 1;
                else hi = m;
            }

            p = lo;

            for(int k = 1; k <= 4; k++) {
                ans[i][k] = new ArrayList<>(ans[i-1][k]);
                dp[i][k] = dp[i-1][k];

                List<Integer> take = new ArrayList<>(ans[p][k-1]);
                take.add(id);
                Collections.sort(take);

                long score = dp[p][k-1]+w;

                if(score > dp[i][k] || 
                    score == dp[i][k] && compare(take,ans[i][k]) < 0) {
                        dp[i][k] = score;
                        ans[i][k] = take;
                    }
            }
        }

        return ans[n][4].stream().mapToInt(x -> x).toArray();
    }

    private int compare(List<Integer> a, List<Integer> b) {
        for(int i = 0; i < a.size(); i++) {
            if(!a.get(i).equals(b.get(i))) {
                return Integer.compare(a.get(i),b.get(i));
            }
        }
        return Integer.compare(a.size(),b.size());
    }
}