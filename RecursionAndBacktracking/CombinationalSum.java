//CombinationalSum
//Problem LInk : https://leetcode.com/problems/combination-sum/
class CombinationalSum {
	List<List<Integer>> ans=new ArrayList<>();
	ArrayList<Integer> x=new ArrayList<>();
	public void combinationalSumUtil(int[] candidates,int indx,int sum,int target){
        if(sum>target){
            return;
        }
		//base case
		if(sum==target){
			ans.add((ArrayList<Integer>)x.clone());
			return;
		}
		for(int i=indx;i<candidates.length;i++){
			if(candidates[i]<=target-sum){
				x.add(candidates[i]);				
				combinationalSumUtil(candidates,i,sum+candidates[i],target);
				//backtrack
				x.remove(x.size()-1);
			}
		}

	}
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationalSumUtil(candidates,0,0,target);
        return ans;
    }
}