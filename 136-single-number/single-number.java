class Solution {
    public int singleNumber(int[] arr) {
        int n = arr.length;
        int ans = arr[0];

        for(int i = 1 ; i < n ; i++){
            ans ^= arr[i];
        }

        return ans; 

    }
}