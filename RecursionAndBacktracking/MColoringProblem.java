//MColoringProblem
//Problem Link : https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
class solve {
	public static boolean isSameColor(List<Integer>[] G,int[] col,int i,int color){
		for(Integer x:G[i]){
			if(col[x]==color){
				return false;
			}
		}
		return true;
	}
    public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int C) {
        // Your code here
        if(i==G.length){
        	return true;
        }
        for(int col=1;col<=C;col++){
        	if(isSameColor(G,color,i,col)){        		
        		color[i]=col;
        		boolean graphColoredHoRhaYaNhi= graphColoring(G,color,i+1,C);
        		if(graphColoredHoRhaYaNhi){
        			return true;
        		}
        		//backtrack
        		color[i]=0;
        	}
        }
        return false;
    }
}
