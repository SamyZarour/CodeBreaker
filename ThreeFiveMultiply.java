public class ThreeFiveMultiply{
	public int generate(int n){
		int i=0;
		int j=0;
		int sum=0;
		int num;
		while(3*i<n){
			num=0;
			while(num<n){
				num= 3*i*5*j;
				if(i==0) num=5*j;
				if(j==0) num=3*i;
				j++;
				if(num==1 || num>=n) continue;
				sum+=num;
				System.out.println("For (" + i + ", " + (j-1) +") : " + num);
			}
			j=0;
			i++;
		}
		return sum;
	}
	public static void main(String[] args){
		ThreeFiveMultiply myMultiply = new ThreeFiveMultiply();
		System.out.println(myMultiply.generate(10));
	}
}