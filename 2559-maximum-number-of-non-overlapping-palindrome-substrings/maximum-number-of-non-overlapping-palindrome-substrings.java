class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int cnt = 0;
        int lastEnd = 0;

        for(int r = k - 1; r < n; r++) {
            int l = r - k + 1;
            boolean add = (l >= lastEnd && isPalindrome(s,l,r)) || 
                (l > lastEnd && isPalindrome(s,l-1,r));

            if(add) {
                cnt++;
                lastEnd = r + 1;
            }
        }
        return cnt;
    }

    private boolean isPalindrome(String s, int l, int r) {
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }
}