//MinSwapsToMakeStringEqual
//Problem LInk : https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/
class MinSwapsToMakeStringEqual {
   public int minimumSwap(String s1, String s2) {
        int len=s1.length();
        int cnt1=0,cnt2=0;
        for(int i=0;i<len;i++){
        	if(s1.charAt(i)==s2.charAt(i)){
        		continue;
        	}
        	else if(s1.charAt(i)=='x'){
        		cnt1++;
        	}
        	else{
        		cnt2++;
        	}
        }
       if((cnt1+cnt2)%2==1){
           return -1;
       }
        return cnt1/2+cnt2/2+(cnt1%2+cnt2%2);
    }
}