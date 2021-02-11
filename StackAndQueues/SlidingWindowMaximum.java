// /SlidingWindowMaximum
//Problem LInk : https://leetcode.com/problems/sliding-window-maximum/

class SlidingWindowMaximum {
     public int[] maxSlidingWindow(int[] nums, int k) {
        //find next greater element of all elements
        Stack<Integer> stack=new Stack<>();
        int len=nums.length;
        int[] greater=new int[len];
        for(int i=len-1;i>=0;i--){
        	while(!stack.isEmpty()&&nums[i]>=nums[stack.peek()]){
        		stack.pop();
        	}
           
        	if(stack.isEmpty()){
        		greater[i]=len;
        	}
        	else{
        		greater[i]=stack.peek();
        	}
            stack.push(i);
        }
        int j=0;
        int[] ans=new int[len-k+1];
        for(int i=0;i<=len-k;i++){
        	if(j<i){
        		j=i;
        	}
        	//if next greater lies in same window then go to that
        	while(greater[j]<i+k){
        		j=greater[j];
        	}
        	ans[i]=nums[j];
        }
      return ans;
    }
}