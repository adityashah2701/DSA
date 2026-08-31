
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = -1 , last = -1;
        int prev = -1 , min = Integer.MAX_VALUE;
        int pos = 1;
        while(head.next != null) {
            if(prev != -1 &&  ((prev < head.val && head.val > head.next.val) || (prev > head.val && head.val < head.next.val))) {
                if(first == -1) {
                    first = pos;
                } else {
                    min = Math.min(min, pos-last);
                }
                last = pos;
            }
            prev = head.val;
            head = head.next;
            pos++;
        }
        if(first == last) return new int[]{-1,-1};

        return new int[]{min,last-first};
    }
}