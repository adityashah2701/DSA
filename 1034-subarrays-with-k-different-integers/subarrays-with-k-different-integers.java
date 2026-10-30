class Solution {
    private static int countSubArrays(int[] nums, int k) {
        int l = 0 , r = 0 , n = nums.length , count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (r < n) {
            map.put(nums[r],map.getOrDefault(nums[r],0) + 1);
            if(map.get(nums[r]) == 1) {
                k--;
            }
            while (k < 0) {
                map.put(nums[l] , map.get(nums[l])-1);
                if(map.get(nums[l]) == 0) {
                    k++;
                }
                l++;
            }
            count += (r - l + 1);
            r++;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countSubArrays(nums,k) - countSubArrays(nums,k-1);
    }
}