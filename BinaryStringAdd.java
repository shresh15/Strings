class Solution {
    public String addBinary(String s1, String s2) {
        // code here
        s1=TrimZeros(s1);
        s2=TrimZeros(s2);
        int n=s1.length();
        int m=s2.length();
        
        if(n<m) return addBinary(s2,s1);
        
        int j=m-1;
        int carry=0;
        //int sum=0
        StringBuilder res=new StringBuilder();
        
        for(int i=n-1;i>=0;i--){
            int bit1=s1.charAt(i)-'0';
            int sum=bit1 + carry;
            
            if(j>=0){
                int bit2=s2.charAt(j)-'0';
                sum=sum+bit2;
                j--;
            }
            int bit=sum%2;
            carry=sum/2;
            
            res.append((char)(bit+'0'));
        }
            if(carry>0) res.append('1');
            
            
        
        return res.reverse().toString();
    }
    
     String TrimZeros(String s){
        int i= s.indexOf('1');
        return (i==-1)? "0": s.substring(i);
    }
}