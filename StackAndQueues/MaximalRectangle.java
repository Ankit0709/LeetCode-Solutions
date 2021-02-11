// /MaximalRectangle
//Problem LInk : https://leetcode.com/problems/maximal-rectangle/
class Solution {
	public int maximalRectangle(char[][] matrix) {
        int rows=matrix.length;
        if(rows==0){
            return 0;
        }
        int cols=matrix[0].length;
        if(cols==0){
            return 0;
        }
        int[][] cnt=new int[rows][cols];
        int area=0;
        //build 2d matrix of heights
        for(int i=0;i<rows;i++){
        	for(int j=0;j<cols;j++){
        		for(int k=i;k<rows;k++){
        			if(matrix[k][j]=='0'){
        				break;
        			}
        			cnt[i][j]+=Integer.parseInt(matrix[k][j]+"");
        		}
        	}
        }
        //largest historam area of every rows
        for(int i=0;i<rows;i++){
        	area=Math.max(area,histogramArea(cnt,i,cols));
        }
        return area;
    }
    public int histogramArea(int[][] cnt,int row,int cols){
    	Stack<Integer> stack=new Stack<>();
    	int area=0;
    	for(int j=0;j<cols;j++){
    		int curr=cnt[row][j];
    		//element at stack top is greater than curr so we need to pop them
    		while(!stack.isEmpty()&&cnt[row][stack.peek()]>=curr){
    			int top=cnt[row][stack.pop()];
    			if(stack.isEmpty()){
    				area=Math.max(area,top*j);
    			}	
    			else{
    				area=Math.max(area,top*(j-stack.peek()-1));
    			}
    		}
            stack.push(j);    				
    	}
        while(!stack.isEmpty()){
            int top=cnt[row][stack.pop()];
            if(stack.isEmpty()){
                area=Math.max(area,top*cols);
            }
            else{
                area=Math.max(area,top*(cols-stack.peek()-1));
            }
        }    
        return  area;
    }    
}