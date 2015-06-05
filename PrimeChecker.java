public class PrimeChecker{
	boolean found;
	public int check(int n){
		found=false;
		findPrime(n,0,0);
		int result = (found) ? 1 : 0;
		return result;
	}
	public void findPrime(int n, int sofar, int step){
		if(isPrime(n* (int) Math.pow(10,step)+sofar) || found) {
			found=true;
			System.out.println( (n* (int) Math.pow(10,step)+sofar) + "is prime.");
			return;
		}
		System.out.println( (n* (int) Math.pow(10,step)+sofar) +" is not prime.");
		int i=0;
		int container1;
		int container2;
		while(Math.pow(10,i)<(double) n){
			container1 = deleteDigit(n,i);
			container2 = sofar + (int) ( n % (int) Math.pow(10,i+1)/ (int) Math.pow(10,i))* (int) Math.pow(10,step);
			findPrime(container1, container2, step+1);
			if(found) return;
			i++;
		}
		return;
	}
	public int deleteDigit(int n, int i){
		return (n/ (int) Math.pow(10,i+1))* (int) Math.pow(10,i)+n% (int) Math.pow(10,i);
	}
	public boolean isPrime(int n){
		for(int i=2; i<n-1; i++){
			if(n%i==0) return false;
		}
		return true;
	}
	public static void main(String[] args){
		PrimeChecker myChecker = new PrimeChecker();
		System.out.println(myChecker.check(985));
	}
}