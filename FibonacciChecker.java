public class FibonacciChecker{
	public String check(int n){
		int temp;
		int f1=1;
		int f2=1;
		while(f2<=n){
			if(f2==n) return "yes";
			temp=f2;
			f2=f1+f2;
			f1=temp;
		}
		return "no";
	}
	public static void main(String[] args){
		FibonacciChecker myF = new FibonacciChecker();
		System.out.println(myF.check(54));
	}
}