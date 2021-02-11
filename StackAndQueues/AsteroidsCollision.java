//AsteroidsCollision
//Problem LInk : https://leetcode.com/problems/asteroid-collision/
class AsteroidsCollision {
    public int[] asteroidCollision(int[] asteroids) {
       Stack<Integer> stack=new Stack<>();      
       for(int i=0;i<asteroids.length;i++){
         int curr=asteroids[i];
       	 while(!stack.isEmpty()&&stack.peek()>0&&curr<0){
       	    int top=stack.pop();
             if(top>Math.abs(curr)){
                 stack.push(top);
                 curr=0;
                 break;
             }
             else if(top==Math.abs(curr)){
                 curr=0;
                 break;
             }
       	 }
         if(curr!=0){
             stack.push(curr);
         }       	
       	
       }
        int[] ans=new int[stack.size()];
       	 int len=stack.size();
       	 while(!stack.isEmpty()){
       	 	ans[--len]=stack.pop();
       	 }
       	 return ans;
       }
}
