class Solution {
   
    public int numDecodings(String s) {
       
        if(s.length()==0)return 0;
        int n=s.length();
        
        
        int dp_next_to_next = -1;
        int dp_next = 1;
            
        for(int idx=n-1;idx>=0;idx--){
             if(s.charAt(idx)=='0') {  // Case 1
                 dp_next_to_next = dp_next;
                 dp_next = 0;
                 continue;
             } 
        
            int count = dp_next; // Case 2.a, Case 3.a and Case 4. 

            if((idx<s.length()-1)&&((s.charAt(idx)=='1')||(s.charAt(idx)=='2'&&s.charAt(idx+1)>='0'&&s.charAt(idx+1)<='6'))){   // Case 2.b and Case 3.b

              count = count + dp_next_to_next;
            }
            
            dp_next_to_next = dp_next;
            dp_next = count;
            
        }
        
        return dp_next;
        
        
    }
}