/*
res = 10 * res + (s.charAt(idx++) - '0');
The idx++ indicates that the value of idx is used first (to get the character), 
and then it is incremented by 1.

Characters for digits ('0' to '9') are represented by their corresponding ASCII values.
Subtracting '0' from a digit character ('1', '2', etc.) gives its numeric value.
 For example:
'5' - '0' = 53 (ASCII of '5') - 48 (ASCII of '0') = 5.

First Part: res > Integer.MAX_VALUE / 10
This checks if multiplying res by 10 will cause it to exceed Integer.MAX_VALUE.
For example:
If res is 214748364 (just below the threshold), multiplying by 10 will make it 2,147,483,640, which is still valid.
But if res is greater than 214748364, multiplying it by 10 would cause an overflow.


Second Part: (res == Integer.MAX_VALUE / 10 && s.charAt(ind) - '0' > 7)
If res equals 214748364 (exactly at the threshold), adding another digit might still cause an overflow.
The digit at s.charAt(ind) is converted to its integer equivalent using s.charAt(ind) - '0'.
The largest valid digit that can be appended in this scenario is 7. Adding any digit greater than 7 will cause an overflow.

*/
 class Solution {
  public int myAtoi(String s) {
        
        // Your code here
        int sign=1,ind=0,res=0;
        int n=s.length();
        
        // check blank
        while(ind<n && (s.charAt(ind)==' ')) {ind++;}
        
        // checking sign
        if(ind<n && (s.charAt(ind)=='-' || s.charAt(ind)=='+')){
           
           if(s.charAt(ind++)=='-') sign=-1;
        }
        
        //construct number
        while(ind<n && s.charAt(ind)>='0' && s.charAt(ind)<='9' ){
            
            //checking range
            if(res>Integer.MAX_VALUE/10 || (res==Integer.MAX_VALUE/10 && s.charAt(ind)-'0'>7))
            return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
        
        
        res=res*10+s.charAt(ind++)-'0';
        }
        
        return res*sign;
        
    }
}