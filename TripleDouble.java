public class TripleDouble{
	public int check(int num1, int num2){
		int digit1;
		int digit2;
		int length = String.valueOf(num2).length();
		for(int i=length-1; i>0; i--){
			digit1= num2 % (int) Math.pow(10,i+1)/ (int) Math.pow(10,i);
			digit2= num2 % (int) Math.pow(10,i)/ (int) Math.pow(10,i-1);
			if(digit1==digit2){
				if(checkTriple(num1,digit1)) return 1;
			}
		}
		return 0;
	}
	public boolean checkTriple(int num1, int digit){
		int digit1;
		int digit2;
		int digit3;
		int length = String.valueOf(num1).length();
		for(int i=length-1; i>1; i--){
			digit1= num1 % (int) Math.pow(10,i+1)/ (int) Math.pow(10,i);
			digit2= num1 % (int) Math.pow(10,i)/ (int) Math.pow(10,i-1);
			digit3= num1 % (int) Math.pow(10,i-1)/ (int) Math.pow(10,i-2);
			if(digit1==digit2 && digit2==digit3){
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args){
		TripleDouble myOject = new TripleDouble();
		System.out.println(myOject.check(67844,66237));
	}
}