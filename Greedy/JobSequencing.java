//JobSequencing
//https://www.geeksforgeeks.org/job-sequencing-problem/
class JobSequencing{
	public void jobsSequencing(Pair[] jobs){
		Arrays.sort(jobs,(p1,p2)->{
			return p2.profit-p1.profit;
		});
		boolean[] slots=new boolean[jobs.length];
		int[] result=new int[jobs.length];
		for(int i=0;i<jobs.length;i++){
			for(int j=Math.min(jobs.length,jobs[i].d)-1;j>=0;j--){
				if(!slots[j]){
					slots[j]=true;
					result[j]=i;
					break;
				}
			}
		}
		for(int i=0;i<slots.length;i++){
			if(slots[i]){
				System.out.println(jobs[result[i]].id);
			}
		}	

	}
}
class Pair{
	char id;
	int d,profit;
	Pair(char x,int dead,int pro){
		id=x;d=dead;profit=pro;
	}
}