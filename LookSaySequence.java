public class LookSaySequence{
	public int findNext(int n){
		int result=0;
		int length = String.valueOf(n).length();
		int count=1;
		int digit1;
		int digit2;
		for(int i=length-1; i>0; i--){
			digit1= n % (int) Math.pow(10,i+1)/ (int) Math.pow(10,i);
			digit2= n % (int) Math.pow(10,i)/ (int) Math.pow(10,i-1);
			if(digit1==digit2) count++;
			if(digit1!=digit2 || i==1){
				result=(result*10+count)*10+digit1;
				count=1;
			}
		}
		return result;
	}
	public static void main(String[] args){
		LookSaySequence myGenerator = new LookSaySequence();
		System.out.println(myGenerator.findNext(2466));
	}
}