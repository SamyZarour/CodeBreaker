public class DistinctList{
	int sum=0;
	public int countDuplicates(int[] list){
		helper(list,0,0);
		return sum;
	}
	public void helper(int[] list, int element, int start){
		boolean first=true;
		for(int i=start; i<list.length;i++){
			if(list[i]==0 && element!=0) continue;
			if(element==list[i]){
				if(first){
					sum--;
					first=false;
				}
				list[i]=0;
				sum++;
			}
		}
		for(int i=0; i<list.length;i++){
			if(list[i]!=0) helper(list,list[i],i);
		}
	}
	public static void main(String[] args){
		int[] container = {0,-2,-2,5,5,5};
		DistinctList myList = new DistinctList();
		System.out.println(myList.countDuplicates(container));
	}
}