class Solution {
    public int[][] insert(int[][] intv, int[] newIntv) {
        int n = intv.length;
        List<int[]> ans = new ArrayList<>();

        int i = 0;

        while(i < n && intv[i][1] < newIntv[0]){
            ans.add(intv[i]);
            i++;
        }

        while(i < n && intv[i][0] <= newIntv[1]){
            newIntv[0] = Math.min(newIntv[0], intv[i][0]);
            newIntv[1] = Math.max(newIntv[1], intv[i][1]);
            i++;
        }
        ans.add(newIntv);

        while(i < n){
            ans.add(intv[i]);
            i++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
}