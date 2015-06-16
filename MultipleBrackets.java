public class MultipleBrackets{
	int total=0;
	int count1=0;
	int count2=0;
	public String check(String str){
		compute(str);
		if(total==0) return "1";
		if(count1!=0 || count2!=0) return "0";
		return 1 + " " + total; 
	}
	public void compute(String str){
		char current=' ';
		for(int i=0; i<str.length(); i++){
			current=str.charAt(i);
			if(current==40) {
				count1++;
				total++;
			}
			else if(current==91) {
				count2++;
				total++;
			}
			else if(current==41) count1--;
			else if(current==93) count2--;
		}
		return;
	}
	public static void main(String[] args){
		MultipleBrackets myChecker = new MultipleBrackets();
		System.out.println(myChecker.check("(c([od]er)) b(yt[e])"));
	}
}