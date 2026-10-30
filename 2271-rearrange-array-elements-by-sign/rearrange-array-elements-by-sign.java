class Solution {
    public int[] rearrangeArray(int[] arr) {
        int pos = 0 , neg = 1;
        int[] ans = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                ans[pos] = arr[i];
                pos+=2;
            } else {
                ans[neg] = arr[i];
                neg+=2;
            }
        }

        return ans;
    }
}