//FractionalKnapsack
//link : https://www.geeksforgeeks.org/fractional-knapsack-problem/
class FractionalKnapsack{
	public  int knapsack(int[] value,int weight[],int capacity){
		ArrayList<Pair> list=new ArrayList<>();
		for(int i=0;i<value.length;i++){
			list.add(new Pair(value[i],weight[i],i));
		}
		Collections.sort(list,(p1,p2)->{
			int r1=p1.v/p1.w;
			int r2=p2.v/p2.w;
			return r2-r1;
		});
		int max_profit=0;
		for(Pair x:list){
			if(capacity==0){
				break;
			}
			if(x.w<=capacity){
				capacity-=x.w;
				max_profit+=x.v;
			}
			else{
				double ratio=capacity/x.w;
				max_profit+=(int)(ratio*x.v);
				capacity=0;
			}
		}
		return max_profit;
	}
}
class Pair{
	int v,w,i;
	Pair(int x,int y,int z){
		v=x;w=y;i=z;
	}
}