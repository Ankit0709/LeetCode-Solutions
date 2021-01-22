//LongestConsecutiveSeq
//Problem LInk :https://leetcode.com/problems/longest-consecutive-sequence/
class LongestConsecutiveSeq {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
        	return 0;
        }
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
        	set.add(nums[i]);
        }
        int max_len=0;
        for(int i=0;i<nums.length;i++){
        	if(set.contains(nums[i]-1)){
        		continue;
        	}
        	else{
        		int len=1;
        		int ele=nums[i]-1;
        		while(set.contains(ele)){
        			ele--;
        			len++;
        		}
        		max_len=Math.max(max_len,len);
        	}
        }
        return max_len;
    }
}