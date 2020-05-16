import java.util.*;
class Workers implements Comparable<Workers>{
	int quality;
	int wage;
	double ratio;
	Workers(int q,int w){
		quality=q;
		wage=w;
		ratio=(double)(q/w);
	}
	public int compareTo(Workers w1){
		if(this.ratio<w1.ratio) return 1;
		if(this.ratio>w1.ratio) return -1;
		return 0;
	}
}
class MinCostToHireKWorkers{
	public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int n=quality.length;
        Workers arr[]=new Workers[n];
        for(int i=0;i<n;i++){
        	arr[i]=new Workers(quality[i],wage[i]);
        }
        Arrays.sort(arr);
        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
        double ans=100000001;
        int sum=0;
        for(int i=0;i<n;i++){
        	max_heap.add(arr[i].quality);
        	sum+=arr[i].quality;
        	if(max_heap.size()>K){
        		sum-=max_heap.peek();
        		max_heap.poll();
        	}
        	else if(max_heap.size()==K){
        		ans=Math.min(ans,sum*arr[i].ratio);
        	}
        }
        return ans;
    }
	public static void main(String[] args) {
	   }
	}