public class BracketMatcher{
	public int check(String str){
		int count=0;
		char current=' ';
		for(int i=0; i<str.length(); i++){
			current=str.charAt(i);
			if(current==40) count++;
			if(current==41) count--;
		}
		if(count==0)return 1;
		return 0;
	}
	public static void main(String[] args){
		BracketMatcher myChecker = new BracketMatcher();
		System.out.println(myChecker.check("(c(oder)) b(yte)"));
	}
}