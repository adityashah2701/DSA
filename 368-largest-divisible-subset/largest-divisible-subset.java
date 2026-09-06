class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);

        int[] dp = new int[n];
        int[] parent = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int max = 1;
        int last = 0;

        for (int i = 0; i < n; i++) {

            for (int prev = 0; prev < i; prev++) {

                if (nums[i] % nums[prev] == 0 &&
                    dp[prev] + 1 > dp[i]) {

                    dp[i] = dp[prev] + 1;
                    parent[i] = prev;
                }
            }

            if (dp[i] > max) {
                max = dp[i];
                last = i;
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (last != -1) {
            ans.add(nums[last]);
            last = parent[last];
        }

        return ans;
    }
}