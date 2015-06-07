public class SwapII{
	public String swap(String str){
		String answer="";
		char current;
		boolean boolFirst=true;
		int prev=0;
		for(int i=0; i<str.length(); i++){
			current=str.charAt(i);
			if(current==32){
				answer+=current;
				if(boolFirst==true) continue;
				answer=insertChar(answer,prev,str.charAt(prev));
				boolFirst=true;
			}
			else if(current>47 && current<58){
				if(boolFirst==true){
					prev=i;
					boolFirst=false;
				}
				else {
					answer+=str.charAt(prev);
					answer=insertChar(answer,prev,current);
					boolFirst=true;
				}
			}
			else if(current>64 && current<91) answer+= (char) (current+32);
			else if(current>96 && current<123) answer+= (char) (current-32);
			else answer+=current; 
		}
		return answer;
	}
	public String insertChar(String str, int i, char current){
		return str.substring(0,i)+ current + str.substring(i);
	}
	public static void main(String[] args){
		SwapII mySwap = new SwapII();
		System.out.println(mySwap.swap("This 5word8 4example This 5would6 not"));
	}
}