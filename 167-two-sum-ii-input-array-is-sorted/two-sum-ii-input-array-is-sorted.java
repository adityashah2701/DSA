class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int arr[] = new int[2];
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                arr[0] = i + 1;
                arr[1] = j + 1;
                break;
            } else if (sum > target){
                j--;
            }
            else {
                i++;
            }
        }

        return arr;
    }
}