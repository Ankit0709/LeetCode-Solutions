// /LargestRectangleInHistogram
//Problem Link : https://leetcode.com/problems/largest-rectangle-in-histogram/
class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack<>();
        int len=heights.length;
        if(len==1){
        	return heights[0];
        }
        int ans=0;
        for(int i=0;i<heights.length;i++){
        	int curr=heights[i];
        	while(!stack.isEmpty()&&heights[stack.peek()]>=curr){
        		int top=heights[stack.pop()];
        		if(stack.isEmpty()){
        			ans=Math.max(ans,top*i);
        		}
        		else{
        			ans=Math.max(ans,top*(i-stack.peek()-1));
        		}
        	}
        	stack.push(i);
        }
        while(!stack.isEmpty()){
        	int top=heights[stack.pop()];
        	if(stack.isEmpty()){
        		ans=Math.max(ans,top*len);
        	}	
        	else{
        		ans=Math.max(ans,top*(len-stack.peek()-1));
        	}
        }
        return ans;
    }
}


//Divide and Conquer Approach O(nLogn)
class Solution{
	public int largestRectangleArea(int[] heights) {
		return largestArea(heights,0,heights.length-1);
	}
	public int largestArea(int[] heights,int start,int end){
		if(start>end){
			return 0;
		}
		int minIndex=start;
		for(int i=start;i<=end;i++){
			if(heights[minIndex]>heights[i]){
				minIndex=i;
			}
		}
		return Math.max(heights[minIndex]*(end-start+1),
			Math.max(largestArea(heights,start,minIndex-1),
				largestArea(heights,minIndex+1,end)));
	}
}