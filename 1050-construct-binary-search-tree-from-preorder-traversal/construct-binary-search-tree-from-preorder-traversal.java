class Solution {
    public TreeNode bstFromPreorder(int[] pre) {
        return bstFromPreorder(pre,Integer.MAX_VALUE,new int[]{0});
    }

    public TreeNode bstFromPreorder(int[] A,int b, int[] i){
        if(i[0] == A.length || A[i[0]] > b) return null;
        TreeNode root = new TreeNode(A[i[0]++]);
        root.left = bstFromPreorder(A,root.val,i);
        root.right = bstFromPreorder(A,b,i);
        return root;
    }
}