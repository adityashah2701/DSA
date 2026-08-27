class Solution {
    public int helper(int[] nums) {
        int prev2 = 0;
        int prev1 = 0;

        for (int money : nums) {
            int curr = Math.max(prev1, prev2 + money);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] temp1 = new int[n];
        int[] temp2 = new int[n];
        if(n == 1) return nums[0];

        for(int i = 0; i < n; i++) {
            if(i != 0) temp1[i] = nums[i];
            if(i != n - 1) temp2[i] = nums[i];
        }

        return Math.max(helper(temp1),helper(temp2));
    }
}