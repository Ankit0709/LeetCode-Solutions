// /FourSum
//////Problem link https://leetcode.com/problems/4sum/
class FourSum {
   public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        if(nums.length<=3){
        	return ans;
        }
        Arrays.sort(nums);
        int len=nums.length;
        for(int i=0;i<len-3;i++){
        	if(i==0||(i>0&&nums[i]!=nums[i-1])){        		
	        	for(int j=i+1;j<len-2;j++){
	                if((j!=(i+1))&&nums[j]==nums[j-1]){
	                	continue;
	                }
	        		int left=j+1;
	        		int right=nums.length-1;
	        		int target_diff=nums[i]+nums[j];
	        		while(left<right){
	        			int sum=nums[left]+nums[right];
	        			if(sum==target_diff){
	        				List<Integer> x=new ArrayList<>();
	        				x.add(nums[i]);
	        				x.add(nums[j]);
	        				x.add(nums[left]);
	        				x.add(nums[right]);
	        				ans.add(x);
	                        while(left<right&&nums[left]==nums[left+1]){left++;}
	                        while(left<right&&nums[right-1]==nums[right]){right--;}
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

        	}
        	
        return ans;

    }
}