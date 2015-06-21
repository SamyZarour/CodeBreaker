import java.util.*;

public class OptimalAssignments{
	ArrayList<Integer> answer = new ArrayList<Integer>();
	int[][] jobList;
	int sum=Integer.MAX_VALUE;
	public ArrayList<Integer> generateAnswer(int[][] jobList){
		this.jobList = jobList;
		ArrayList<Integer> currentAnswer = new ArrayList<Integer>();
		findPositions(jobList.length, currentAnswer,0,0);
		return this.answer;
	}
	public void findPositions(int n, ArrayList<Integer> currentAnswer, int row, int mySum){
		if(row==n && mySum<sum){
			answer=currentAnswer;
			sum=mySum;
			return;
		}
		for(int i=0; i<n; i++){
			if(isLegal(currentAnswer,row,i)){
				ArrayList<Integer> container = cloneArrayList(currentAnswer);
				container.add(i);
				findPositions(n,container, row+1, mySum+jobList[row][i]);
			}
		}
		return;
	}
	public boolean isLegal(ArrayList<Integer> currentAnswer, int row, int column){
		for(int i=0; i<currentAnswer.size(); i++){
			if(currentAnswer.get(i)==column) return false;
		}
		return true;
	}
	public ArrayList<Integer> cloneArrayList(ArrayList<Integer> toClone){
		ArrayList<Integer> newArray = new ArrayList<Integer>();
		for(int i=0 ;i<toClone.size(); i++){
			newArray.add(toClone.get(i));
		}
		return newArray;
	}
	public void displayResult(){
		if(answer.isEmpty()){
			System.out.println("-1");
			return;
		}
		for(int i=0; i<answer.size(); i++){
			System.out.print("("+(i+1)+","+(answer.get(i)+1)+") ");
		}
		System.out.println();
	}
	public static void main(String[] args){
		OptimalAssignments myPuzzle = new OptimalAssignments();
		int[][] test = {{13,4,7,6},{1,11,5,4},{6,7,2,8},{1,3,5,9}};
		myPuzzle.generateAnswer(test);
		myPuzzle.displayResult();
	}
}