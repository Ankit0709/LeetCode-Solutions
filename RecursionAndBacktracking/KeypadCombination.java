//KeypadCombination
//Problem Link : https://leetcode.com/problems/letter-combinations-of-a-phone-number/
class KeypadCombination {
	List<String> ans=new ArrayList<>();
	HashMap<Character,String> map=new HashMap<>(){{		
		put('2',"abc");
		put('3',"def");
		put('4',"ghi");
		put('5',"jkl");
		put('6',"mno");
		put('7',"pqrs");
		put('8',"tuv");
		put('9',"wxyz");
	}};
	public void letterCombinationsUtil(String digits,int len,int indx,String str){
		if(str.length()==len){
			ans.add(str);
			return;
		}
		for(int i=indx;i<len;i++){
			char ch=digits.charAt(i);
			String x=map.get(ch);
			for(int j=0;j<x.length();j++){
				letterCombinationsUtil(digits,len,i+1,str+x.charAt(j));
			}
		}
	}
    public List<String> letterCombinations(String digits) {
        int len=digits.length();
        if(len==0){
        	return ans;
        }
        letterCombinationsUtil(digits,len,0,"");
        return ans;

    }
}