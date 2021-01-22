//MajorityElement2
//Problem LInk :https://leetcode.com/problems/majority-element-ii/
class MajorityElement2 {
     public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        int n=nums.length;
        int first=nums[0],second=Integer.MAX_VALUE;
        int cnt1=1,cnt2=0;
        for(int i=1;i<nums.length;i++){
        	if(nums[i]==first){
        		cnt1++;
        	}
        	else if(nums[i]==second){
        		cnt2++;
        	}
        	else if(cnt1==0){
        		first=nums[i];
        		cnt1=1;
        	}
        	else if(cnt2==0){
        		second=nums[i];
        		cnt2=1;
        	}
        	else{
        		cnt1--;
        		cnt2--;
        	}
        }
       int count1=0,count2=0;
       for(int i=0;i<n;i++){
            if(nums[i]==first){
                count1++;
            }
           else if(nums[i]==second){
               count2++;
           }
       	      	
       }
       if(count1>n/3){
       	ans.add(first);
       }
       if(count2>n/3){
       	ans.add(second);
       }

        return ans;
    }
}