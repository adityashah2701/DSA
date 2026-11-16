class Solution {
    public String digitSum(String s, int k) {
        
        while(s.length() > k){
            StringBuilder sb = new StringBuilder();
            int sum = 0;
            for(int i = 1; i <=s.length(); i++){
                sum += s.charAt(i-1) - '0';
                if(i % k == 0 || i == s.length()){
                    sb.append(sum);
                    sum=0;  
                }
            }
            s = sb.toString();
        }
        return s;
    }
}