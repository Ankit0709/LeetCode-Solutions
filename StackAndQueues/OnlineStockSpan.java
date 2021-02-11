//OnlineStockSpan
//Problem LInk : https://leetcode.com/problems/online-stock-span/
class StockSpanner {
    Stack<Pair> stack;
    int indx=0;
    public StockSpanner() {
        stack=new Stack<>();
    }
    
    public int next(int price) {       
        int w=1;
        while(!stack.isEmpty()&&stack.peek()<=price){
           w+=stack.pop().s;
        }
        stack.add(new Pair(price,w));
        return w;
    }
}
class Pair{
	int f,s;
	Pair(int x,int y){
		f=x;s=y;
	}
}
