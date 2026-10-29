class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1 , n = nums.length;
        if (n == 0) return 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}