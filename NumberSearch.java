public class NumberSearch{
	public int sum(String str){
		char current=' ';
		int count=0;
		int sum=0;
		for(int i=0; i<str.length(); i++){
			current=str.charAt(i);
			if(current>47 && current<58) sum+=(current-48);
			if((current>64 && current<91) || (current>96 && current<123)) count++;
		}
		System.out.println("Sum: "+sum+", Length: "+count);
		return (int) Math.round((double)sum/count);
	}
	public static void main(String[] args){
		NumberSearch myNum = new NumberSearch();
		System.out.println(myNum.sum("One Number*1*"));
	}
}