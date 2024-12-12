class Solution {
    public int firstUniqChar(String s) {
       int n=s.length();
        int vis[]=new int[26];
        Arrays.fill(vis,-1);
        for(int i=0;i<n;i++){
            
            if(vis[s.charAt(i)-'a']==-1) vis[s.charAt(i)-'a']=i;
            else vis[s.charAt(i)-'a']=-2;
            
        }
        int ind=Integer.MAX_VALUE;
        for(int i=0;i<26;i++)
       { if(vis[i]>=0)
            ind=Math.min(vis[i],ind);
       }
        return (ind==Integer.MAX_VALUE ? -1:ind);
     
    }
}