class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] a = new int[n][2];

        for (int i = 0; i < n; i++) {
            a[i][0] = nums[i];
            a[i][1] = i;
        }

        Arrays.sort(a, (x, y) -> x[0] - y[0]);

        for (int i = 0; i < n;) {
            int j = i;
            while (j + 1 < n && a[j + 1][0] - a[j][0] <= limit)
                j++;

            int[] idx = new int[j - i + 1];
            for (int k = i; k <= j; k++)
                idx[k - i] = a[k][1];

            Arrays.sort(idx);

            for (int k = i; k <= j; k++)
                nums[idx[k - i]] = a[k][0];

            i = j + 1;
        }

        return nums;
    }
}