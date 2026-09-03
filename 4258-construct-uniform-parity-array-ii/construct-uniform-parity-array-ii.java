class Solution {
    public boolean uniformArray(int[] nums1) {
        int oddMin = Integer.MAX_VALUE;
        int evenMin = Integer.MAX_VALUE;

        for(int x : nums1) {
            if(x % 2 == 1) {
                oddMin = Math.min(oddMin,x); 
            } else {
                evenMin = Math.min(evenMin,x);
            }
        }

        if(oddMin == Integer.MAX_VALUE){
            return true;
        }

        return oddMin < evenMin;
    }
}