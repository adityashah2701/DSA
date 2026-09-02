class Solution {
    public int maxProfit(int[] arr) {
        int min = arr[0];
        int profit = 0;
        int n = arr.length;
        for(int i = 1; i < n ; i++){
            if(min > arr[i]) {
                min = arr[i];
            }
            profit = Math.max(profit , arr[i] - min);
        }
        return profit;
    }
}