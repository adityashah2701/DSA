class Solution {
    public int minimumDifference(int[] nums) {

        int n = nums.length / 2;
        List<List<Integer>> leftSide = calculateSubsetSum(0, n - 1, nums, n);
        List<List<Integer>> rightSide = calculateSubsetSum(n, 2 * n - 1, nums, n);
        int totalSum = 0;
        for (int num : nums)
            totalSum += num;
        int halfSum = totalSum / 2;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            for (int S1 : leftSide.get(i)) {
                int target = halfSum - S1;

                int S2 = binary(rightSide.get(n - i), target);

                int sum = S1 + S2;

                res = Math.min(res, Math.abs(2 * sum - totalSum));
            }
        }

        return res;
    }

    List<List<Integer>> calculateSubsetSum(int left, int right, int[] nums, int n) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            res.add(new ArrayList<>());

        int len = right - left + 1;

        int total = 1 << len;

        for (int mask = 0; mask < total; mask++) {
            int sum = 0;

            int bits = 0;

            for (int j = 0; j < len; j++) {
                if ((mask & (1 << j)) != 0) {
                    sum += nums[left + j];
                    bits++;
                }
            }
            res.get(bits).add(sum);
        }

        for (int i = 0; i <= n; i++)
            Collections.sort(res.get(i));

        return res;
    }

    int binary(List<Integer> list, int target) {
        Integer r1 = binaryUp(list, target);

        Integer r2 = binaryDown(list, target);

        if (r1 == null)
            return r2;
        if (r2 == null)
            return r1;

        return Math.abs(target - r1) > Math.abs(target - r2) ? r2 : r1;
    }

    Integer binaryUp(List<Integer> list, int target) {
        int low = 0;

        int high = list.size() - 1;

        Integer ans = null;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) >= target) {
                ans = list.get(mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    Integer binaryDown(List<Integer> list, int target) {
        int low = 0;

        int high = list.size() - 1;

        Integer ans = null;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) <= target) {
                ans = list.get(mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}