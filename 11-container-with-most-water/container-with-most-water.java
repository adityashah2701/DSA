class Solution {
    public int maxArea(int[] height) {
       int n = height.length;
       int l = 0 , r = n - 1;
       int area = 0;

       while (l < r) {
            int width = r - l;
            int waterHeight = Math.min(height[l],height[r]);
            area = Math.max(area,width * waterHeight);
            if (height[l] < height[r]) l++;
            else r--;
       }

       return area;
    }
}