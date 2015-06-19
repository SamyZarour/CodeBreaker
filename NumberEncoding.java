public class NumberEncoding{
	public String encode(String str){
		String answer="";
		char current;
		for(int i=0; i<str.length(); i++){
			current=str.charAt(i);
			if(current>64 && current<91) answer+= (int) (current-64);
			else if(current>96 && current<123) answer+= (int) (current-96);
			else answer+=current;
		}
		return answer;
	}
	public static void main(String[] args){
		NumberEncoding myEncode = new NumberEncoding();
		System.out.println(myEncode.encode("jaj-a"));
	}
}