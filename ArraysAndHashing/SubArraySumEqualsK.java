//SubArraySumEqualsK
//Problem LInk :https://leetcode.com/problems/subarray-sum-equals-k/ 
class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int ans=0;
      	Map<Integer,Integer> map=new HashMap<>();
   
      	int curr_sum=0;
      	for(int i=0;i<nums.length;i++){
      		curr_sum+=nums[i];
      		if(map.containsKey(curr_sum-k)){
      			ans+=map.get(curr_sum-k);
      		}
      		if(curr_sum==k){
      			ans++;
      		}      		
      		map.put(curr_sum,map.getOrDefault(curr_sum,0)+1);
      	}
      	return ans;
    }
}