class Solution {
   
    public int numDecodings(String s) {
       
        if(s.length()==0)return 0;
        int n=s.length();
        int dp[] = new int[n+1];
        
        dp[n] = 1;
       
            
        for(int idx=n-1;idx>=0;idx--){
             if(s.charAt(idx)=='0') {dp[idx] = 0;continue;} // Case 1
        
            int count = dp[idx+1]; // Case 2.a, Case 3.a and Case 4. 

            if((idx<s.length()-1)&&((s.charAt(idx)=='1')||(s.charAt(idx)=='2'&&s.charAt(idx+1)>='0'&&s.charAt(idx+1)<='6'))){   // Case 2.b and Case 3.b

              count = count + dp[idx+2];
            }
            
            dp[idx] = count;
            
        }
        
        return dp[0];
        
        
    }
}