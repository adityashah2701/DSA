class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int max = -1, ans = 0, smax = 0;
        for(int i = 0; i < nums.length; i++) {
            smax = Math.max(smax,nums[i]);
            if(i == ans) max = smax;
            if(nums[i] < max - k) ans = i + 1;
        } 
        return ans < nums.length ? ans : -1;
    }
}