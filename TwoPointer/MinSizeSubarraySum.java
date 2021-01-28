//MinSizeSubarraySum
//Problem LINk : https://leetcode.com/problems/minimum-size-subarray-sum/
class MinSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int len=nums.length;
        if(len==0){
        	return 0;
        }
        int min_len=Integer.MAX_VALUE;
        int start=0,end=0,sum=0;
        while(end<len){           
        	while(end<len&&sum<s){
        		sum+=nums[end];
        		end++;
                flag1=true;
        	}
        	while(start<end&&sum>=s){
        		min_len=Math.min(min_len,end-start);
        		sum-=nums[start];
        		start++;
                flag2=true;
        	}            
        }
        if(min_len==Integer.MAX_VALUE){
        	return 0;
        }
        else{
        	return min_len;
        }

    }
}