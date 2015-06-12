public class StringReduction{
	public int reduce(String str){
		int prev=-1;
		int temp=-1;
		while(str.length()<prev || prev==-1){
			prev=str.length();
			str=reductionStep(str);
		}
		return str.length();
	}
	public String reductionStep(String str){
		System.out.println(str);
		String answer="";
		for(int i=0; i<str.length(); i++){
			if(i==str.length()-1) answer+=str.charAt(i);
			else if((str.charAt(i)=='a' && str.charAt(i+1)=='b') ||(str.charAt(i+1)=='a' && str.charAt(i)=='b')){
				answer+='c';
				i++;
			}
			else if((str.charAt(i)=='a' && str.charAt(i+1)=='c') || (str.charAt(i+1)=='a' && str.charAt(i)=='c')){
				answer+='b';
				i++;
			}
			else if((str.charAt(i)=='b' && str.charAt(i+1)=='c') || (str.charAt(i+1)=='b' && str.charAt(i)=='c')){
				answer+='a';
				i++;
			}
			else answer+=str.charAt(i);
		}

		if(answer=="") return str;
		return answer;
	}
	public static void main(String[] args){
		StringReduction myReduct = new StringReduction();
		System.out.println(myReduct.reduce("cccc"));
	}
}