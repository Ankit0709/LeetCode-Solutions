//MaximumSubarray
//Problem LInk :https://leetcode.com/problems/maximum-subarray/
class MaximumSubarray {
   public int maxSubArray(int[] nums) {
        int max_sum=nums[0],curr_sum=nums[0];
        for(int i=1;i<nums.length;i++){
            curr_sum=Math.max(curr_sum+nums[i],nums[i]);
        	if(max_sum<curr_sum){
        		max_sum=curr_sum;
        	}
        }
        return max_sum;
    }
}