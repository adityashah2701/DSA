class Solution {
    public void swap(int i , int j , int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int i = 0 , j = n - 1;

        while (i < j) {
            if (nums[i] % 2 == 0) i++;
            else if (nums[j] % 2 == 1) j--;
            else {
                swap(i,j,nums);
                i++;
                j--;
            } 
        }

        return nums;
    }
}