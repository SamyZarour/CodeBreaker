import java.util.*;

public class QueenPuzzleMath{
	ArrayList<ArrayList<Integer>> answers = new ArrayList<ArrayList<Integer>>();
	public ArrayList<ArrayList<Integer>> generateAnswer(int n){
		ArrayList<Integer> currentAnswer = new ArrayList<Integer>();
		findPositions(n, currentAnswer,0);
		return answers;
	}
	public void findPositions(int n, ArrayList<Integer> currentAnswer, int row){
		if(row==n){
			answers.add(currentAnswer);
			return;
		}
		for(int i=0; i<n; i++){
			if(isLegal(currentAnswer,row,i)){
				ArrayList<Integer> container = cloneArrayList(currentAnswer);
				container.add(i);
				findPositions(n,container, row+1);
			}
		}
		return;
	}
	public boolean isLegal(ArrayList<Integer> currentAnswer, int row, int column){
		for(int i=0; i<currentAnswer.size(); i++){
			if(currentAnswer.get(i)==column) return false;
			if(i-row==currentAnswer.get(i)-column || row-i==currentAnswer.get(i)-column) return false;
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
	public static void main(String[] args){
		QueenPuzzleMath myPuzzle = new QueenPuzzleMath();
		System.out.println(myPuzzle.generateAnswer(14).size());
	}
}