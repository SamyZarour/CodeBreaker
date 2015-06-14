public class CoinDeterminer{
	int min=-1;
	public int makeChange(int n, int[] coins){
		combinations(n,0,0,coins);
		return min;
	}
	public void combinations(int goal, int sofar, int steps, int[] coins){
		if(sofar>goal) return;
		if(sofar==goal){
			if(steps<min || min==-1) min=steps;
			return;
		}
		for(int i=0; i<coins.length; i++){
			combinations(goal,sofar+coins[i], steps+1,coins);
		}
		return;
	}
	public static void main(String[] args){
		CoinDeterminer myDeterminater = new CoinDeterminer();
		int[] coins = {1,5,7,9,11};
		System.out.println(myDeterminater.makeChange(39,coins));
	}
}