//MergeIntervals
//Problem LInk : https://leetcode.com/problems/merge-intervals/ 
class MergeIntervals {
   public int[][] merge(int[][] intervals) {
       LinkedList<Pair> x= new LinkedList<>();
       Arrays.sort(intervals,(x1,x2)->{
           return x1[0]-x2[0];
       });
       x.add(new Pair(intervals[0][0],intervals[0][1]));

       for(int i=1;i<intervals.length;i++){
       	 if(x.getLast().s>=intervals[i][0]){
       	 	Pair rp = x.removeLast();
       		 x.add(new Pair(rp.f,Math.max(intervals[i][1],rp.s)));
       	 }
        else{
           x.add(new Pair(intervals[i][0],intervals[i][1]));
         }
       }
       int[][] ans=new int[x.size()][2];
       for(int i=0;i<x.size();i++){
       		Pair rp=x.get(i);
       		ans[i][0]=rp.f;
       		ans[i][1]=rp.s;
       }
       return ans;
    }

}
class Pair{
	int f,s;
	Pair(int x,int y){
		f=x;s=y;
	}
}