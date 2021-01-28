//ValidPalindrome
//Problem LInk : https://leetcode.com/problems/valid-palindrome/
class Solution {
    public boolean isPalindrome(String str) {
        int len=str.length();
        int i=0,j=len-1;
        
        while(i<j){
            char begChar=Character.toLowerCase(str.charAt(i));
            char lastChar=Character.toLowerCase(str.charAt(j));
            if((begChar>='a'&&begChar<='z')||(begChar>='0'&&begChar<='9')){                
                if((lastChar>='a'&&lastChar<='z')||(lastChar>='0'&&lastChar<='9')){
                    if(begChar!=lastChar){
                        return false;
                    }
                    i++;
                    j--;
                }
                else{
                    j--;
                }
            }
            else{
                i++;
            }           
                
        }
        return true;
    }
}