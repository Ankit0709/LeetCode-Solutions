// /FourSum
//Problem LInk :https://leetcode.com/problems/4sum/
class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List> ans=new ArrayList<>();
        if(nums.length==0){
        	return ans;
        }
        Arrays.sort(nums);
        int i=0;
        while(i<nums.length){
        	int j=i+1;
        	while(j<nums.length){
        		int left=j+1;
        		int right=nums.length-1;
        		while(left<right){
        			int sum=nums[i]+nums[j]+nums[left]+nums[right];
        			if(sum==target){
        				List<Integer> x=new ArrayList<>();
        				x.add(nums[i]);
        				x.add(nums[j]);
        				x.add(nums[left]);
        				x.add(nums[right]);
        				ans.add(x);
        				left++;
        				right--;
        			}
        			else if(sum<target){
        				left++;
        			}
        			else{
        				right--;
        			}
        		}
        	}
        }
        return ans;

    }
}