//Permutations2
//https://leetcode.com/problems/permutations-ii/
class Solution {
	 List<List<Integer>> ans=new ArrayList<>();
	ArrayList<Integer> x=new ArrayList<>();
	public void permutations(HashMap<Integer,Integer> map,int n){
		//base case
		if(x.size()==n){
			ans.add((ArrayList)x.clone());
			return;
		}
        
		for(Map.Entry<Integer,Integer> entry:map.entrySet()){
			int val=entry.getValue();
			int ele=entry.getKey();
			if(val>0){
				x.add(ele);
				map.put(ele,map.get(ele)-1);
				permutations(map,n);
				x.remove(x.size()-1);
                map.put(ele,map.get(ele)+1);
			}
		}
	}
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer,Integer> ele=new HashMap<>();
        for(int i=0;i<nums.length;i++){
        	ele.put(nums[i],ele.getOrDefault(nums[i],0)+1);
        }

        permutations(ele,nums.length);
        return ans;
    }
}