class Node {
    int max;
    int min;
    int sum;

    Node(int min, int max, int sum) {
        this.min = min;
        this.max = max;
        this.sum = sum;
    }
}

class Solution {
    int ans = 0;

    Node helper(TreeNode root) {
        if (root == null) {
            return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        Node left = helper(root.left);
        Node right = helper(root.right);

        if (left.max < root.val && right.min > root.val) {
            int curSum = left.sum + right.sum + root.val;

            ans = Math.max(ans, curSum);

            return new Node(
                Math.min(root.val, left.min),
                Math.max(root.val, right.max),
                curSum
            );
        }

        return new Node(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }

    public int maxSumBST(TreeNode root) {
        helper(root);
        return ans;
    }
}