// /ThreeSum
//Problem Link : https://leetcode.com/problems/3sum/
class ThreeSum {
	List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        int len=nums.length;
        if(len==0){
        	return ans;
        }
        Arrays.sort(nums);
        for(int i=0;i<=len-3;i++){
        	int j=i+1,k=len-1;
        	if(i==0||nums[i]!=nums[i-1]){
	        		while(j<k){
	        		int sum=nums[i]+nums[j]+nums[k];        		
	        		if(sum==0){
	        			List<Integer> x=new ArrayList<>();
	        			x.add(nums[i]);
	        			x.add(nums[j]);
	        			x.add(nums[k]);
                        ans.add(x);
	        			while(j<k&&nums[j]==nums[j+1]){
	        				j++;
	        			}
	        			while(j<k&&nums[k]==nums[k-1]){
	        				k--;
	        			}
	        			j++;
	        			k--;
	        		}
	        		else if(sum<0){
	        			j++;
	        		}
	        		else{
	        			k--;
	        		}
	        	}
        	}        	
        }
        return ans;
    }
}