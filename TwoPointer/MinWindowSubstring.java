//MinWindowSubstring
//Problem Link : https://leetcode.com/problems/minimum-window-substring/
class MinWindowSubstring {
    public String minWindow(String s, String t) {
        int len1=s.length();
        int len2=t.length();
        int[] freq1=new int[128];
        int[] freq2=new int[128];
        String ans="";
        //store frequenecy of string t 
        for(int i=0;i<len2;i++){
        	freq2[t.charAt(i)]++;
        }
        int acquire=0,release=0,match_count=0,count=len2;
        
        while(true){
            boolean flag1=false,flag2=false;
        	//acquire
            while(acquire<len1&&match_count<count){
                char ch=s.charAt(acquire);
                acquire++;
                freq1[ch]++;
                if(freq1[ch]<=freq2[ch]){
                    match_count++;
                }
                flag1=true;
            }
            
            //release
            while(release<acquire&&match_count==count){
                char ch=s.charAt(release);
                String potAns=s.substring(release,acquire);
                if(potAns.length()<ans.length()||ans.length()==0){
                    ans=potAns;
                }
                release++;
                freq1[ch]--;
                if(freq1[ch]<freq2[ch]){
                    match_count--;
                }
                 flag2=true;
            }
            if(flag1==false&&flag2==false){
                break;
            }
        }
        return ans;
    }
}