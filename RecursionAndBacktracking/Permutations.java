//Permutations
//Problem link : https://leetcode.com/problems/permutations/
class Permutations {
	List<List<Integer>> ans=new ArrayList<>();
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
	public void permutations(int[] nums,int i,int r){
		if(i==r){
			List<Integer> permu=new ArrayList<>();
			for(int x=0;x<nums.length;x++){
				permu.add(nums[x]);
			}
			ans.add(permu);
			return;
		}
		for(int j=i;j<=r;j++){
			swap(nums,i,j);
			permutations(nums,i+1,r);
			//backtrack
			swap(nums,i,j);
		}
	}
    public List<List<Integer>> permute(int[] nums) {
       permutations(nums,0,nums.length-1);
       return ans;
    }
}