//CombinationalSum3
//Problem Link :https://leetcode.com/problems/combination-sum-iii/
class CombinationalSum3 {
	 List<List<Integer>> ans=new ArrayList<>();
	public void combinationUtil(int k,int n,ArrayList<Integer> x,int num){
		if(n==0&&k==0){
			ans.add((ArrayList<Integer>)x.clone());
			return;
		}
		if(n<0||k<0){
			return;
		}		
		for(int i=num;i<=9;i++){            
			if(i<=n){                
				x.add(i);
				combinationUtil(k-1,n-i,x,i+1);
				x.remove(x.size()-1);
			}
            else{
                break;
            }
		}
		
	}
    public List<List<Integer>> combinationSum3(int k, int n) {
        combinationUtil(k,n,new ArrayList<>(),1);
        return ans;
    }
}