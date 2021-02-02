//TwoCityScheduling
//Problem LInk : https://leetcode.com/problems/two-city-scheduling/

class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
         Arrays.sort(costs,(x1,x2)->{
        	int diff1=x1[1]-x1[0];
        	int diff2=x2[1]-x2[0];
        	return diff2-diff1;
        });
        int len=costs.length;
        int ans=0,i=0;
        while(i<len/2){
        	ans+=costs[i][0];
        	i++;
        }
        while(i<len){
        	ans+=costs[i][1];
        	i++;
        }
        return ans;
    }
}