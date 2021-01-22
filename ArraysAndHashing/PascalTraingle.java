//PascalTraingle
//Problem LInk :https://leetcode.com/problems/pascals-triangle/ 
class PascalTraingle {
	List<List<Integer> ans=new ArrayList<>();
    public List<List<Integer>> generate(int numRows) {
    	List<Integer> l1=new ArrayList<>();
		l1.add(1);
		ans.add(l1);		
    	if(numRows==1){
    		return ans;
    	}    	
        for(int i=2;i<=numRows;i++){
        	List<Integer> x=new ArrayList<>();
        	 x.add(1);
        	 List<Integer> prev=ans.get(ans.size()-1);
        	 for(int j=2;j<numRows;j++){
        	 	x.add(prev.get(j-2)+prev.get(j-1));
        	 }
        	 x.add(1);
        	 ans.add(x);
        }
        return ans;
    }
}