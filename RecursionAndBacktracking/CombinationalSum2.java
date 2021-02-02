//CombinationalSum2
//Problem Link : https://leetcode.com/problems/combination-sum-ii/
class CombinationalSum2 {
	  List<List<Integer>> ans=new ArrayList<>();
	ArrayList<Integer> x=new ArrayList<>();
	public void solve(int[] candidates,int sum,int indx,int target){
		if(sum==target){
			ans.add((ArrayList<Integer>)x.clone());
			return;
		}
        if(sum>target){
            return;
        }
         
		for(int i=indx;i<candidates.length;i++){
            if(i==indx||candidates[i]!=candidates[i-1]){
                if(candidates[i]<=target-sum){
                    x.add(candidates[i]);              
                    solve(candidates,sum+candidates[i],i+1,target);
                    x.remove(x.size()-1);
			    }
            }
			
		}
	}
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        solve(candidates,0,0,target);
        return ans;
    }
}