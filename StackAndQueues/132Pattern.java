// /132Pattern
//Problem LInk : https://leetcode.com/problems/132-pattern/

class 132Pattern {
	//Naive Approach
	 public boolean find132pattern(int[] nums) {
	 	int[] minVal=new int[nums.length];
	 	minVal[0]=nums[0];
	 	for(int i=1;i<nums.length;i++){
	 		minVal[i]=Math.min(minVal[i-1],nums[i]);
	 	}
	 	for(int j=1;j<nums.length-1;j++){	 		
	 		for(int k=j+1;k<nums.length;k++){
	 			if(nums[k]<nums[j]&&minVal[j-1]<nums[k]){
	 				return true;
	 			}
	 		}
	 	}
	 	return false;
	 }
	 //Linear Time Compelexity T(n)->O(n)
    public boolean find132pattern(int[] nums) {
     	Stack<Integer> stack=new Stack<>();
        int n=nums.length;
		int[] minVal=new int[n];
	 	minVal[0]=nums[0];
	 	for(int i=1;i<n;i++){
	 		minVal[i]=Math.min(minVal[i-1],nums[i]);
	 	}
     	//push positions in stack
     	for(int j=n-1;j>0;j--){
     		while(!stack.isEmpty()&&nums[stack.peek()]<nums[j]){
     			int top=nums[stack.pop()];
     			if(top>minVal[j-1]){
     				return true;
     			}			

     		}
     		stack.add(j);
     	}
     	return false; 


    }
}