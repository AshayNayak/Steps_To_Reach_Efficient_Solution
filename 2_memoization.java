class Solution {
    int n;
    int mem[];
    int decodeWays(String s,int idx){
        if(idx==s.length()) return 1; // if we reach to the end of string that means we have decoded the string successfully so return 1.
        
        if(mem[idx]!=-1)return mem[idx]; 
        
        if(s.charAt(idx)=='0')return mem[idx] = 0; // Case 1
        
        int count = decodeWays(s,idx+1); // Case 2.a, Case 3.a and Case 4. 
        
        if((idx<s.length()-1)&&((s.charAt(idx)=='1')||(s.charAt(idx)=='2'&&s.charAt(idx+1)>='0'&&s.charAt(idx+1)<='6'))){   // Case 2.b and Case 3.b
          
          count = count + decodeWays(s,idx+2);
        }
        
        return mem[idx] = count;
        
    }
    public int numDecodings(String s) {
       
        if(s.length()==0)return 0;
        n=s.length();
        mem = new int[n];
        Arrays.fill(mem,-1); // set it to -1 inititally. if it is other than -1 then we have already calculated the answer
        return decodeWays(s,0);
        
    }
}