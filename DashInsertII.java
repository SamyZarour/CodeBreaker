public class DashInsertII{
	public String format(int n){
		String answer="";
		int digit1;
		int digit2;
		int length = String.valueOf(n).length();
		for(int i=length-1; i>0; i--){
			digit1= n % (int) Math.pow(10,i+1)/ (int) Math.pow(10,i);
			answer+=digit1;
			digit2= n % (int) Math.pow(10,i)/ (int) Math.pow(10,i-1);
			System.out.println("First digit no" + i + ": "+ digit1 + ".  Second digit no"+(i-1)+": "+digit2);
			if((digit1-digit2)%2==0){
				if(digit1==0 || digit2==0) continue;
				if(digit1%2==0) answer+="*";
				if(digit1%2==1) answer+="-";
			}
		}
		answer+=n%10;
		return answer;
	}
	public static void main(String[] args){
		DashInsertII myDash = new DashInsertII();
		System.out.println(myDash.format( 56647304));
	}
}