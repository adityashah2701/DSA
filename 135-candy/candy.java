class Solution {
    public int candy(int[] r) {
        int n = r.length;
        int totalCandies = n;
        int i = 1;

        while (i < n) {
            if (r[i] == r[i - 1]) {
                i++;
                continue;
            }

            int peak = 0;
            while (i < n && r[i] > r[i - 1]) {
                peak++;
                totalCandies += peak;
                i++;
            }

            if (i == n) {
                return totalCandies;
            }

            int down = 0;
            while (i < n && r[i] < r[i - 1]) {
                down++;
                totalCandies += down;
                i++;
            }

            totalCandies -= Math.min(peak, down);
        }

        return totalCandies;        
    }
}