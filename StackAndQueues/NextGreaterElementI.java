// /NextGreaterElementI
// LInk : https://leetcode.com/problems/next-greater-element-i/
class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack=new Stack<>();
        stack.push(nums2[0]);
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=1;i<nums2.length;i++){
        	int curr=nums2[i];
        	//this means curr is my next greater of stack elements
        	while(!stack.isEmpty()&&curr>stack.peek()){
        		map.put(stack.pop(),curr);        		
        	}
        	stack.push(curr);
        }
        //rest elements in stack will have -1 as next greater
        while(!stack.isEmpty()){
        	map.put(stack.pop(),-1);
        }
        int[] ans=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
        	ans[i]=map.get(nums1[i]);
        }
        return ans;
    }
}