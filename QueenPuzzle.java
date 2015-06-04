import java.util.*;

public class QueenPuzzle{
	public int step=0;
	public ArrayList<ArrayList<Integer>> queenPuzzle(int n){
		ArrayList<ArrayList<Integer>> free = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		for(int i=0; i<n; i++) row.add(i);
		for(int i=0; i<n; i++) free.add(cloneArrayList(row));
		return trim(dispositionList(n, free, n), n);
	}
	public ArrayList<ArrayList<Integer>> dispositionList(int n, ArrayList<ArrayList<Integer>> free, int max){
		this.step++;
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(free.isEmpty()) return result;
		ArrayList<Integer> row0 = free.get(0);
		ArrayList<ArrayList<Integer>> temp = cloneArrayList2(free);
		temp.remove(0);
		if(row0.isEmpty()) return result;
		for(int i=0; i<row0.size(); i++){
			ArrayList<ArrayList<Integer>> temp2 = cloneArrayList2(temp);
			removeColumn(temp2,row0.get(i));
			removeDiagonals(temp2,row0.get(i),max);
			ArrayList<ArrayList<Integer>> tempResult = dispositionList(n-1,temp2,max);
			if(tempResult.isEmpty()) tempResult.add(new ArrayList<Integer>());
			for(int j=0; j<tempResult.size();j++) (tempResult.get(j)).add(0,row0.get(i));
			result.addAll(tempResult);
		}
		return result;
	}
	public static ArrayList<Integer> cloneArrayList(ArrayList<Integer> list) {
	    ArrayList<Integer> clone = new ArrayList<Integer>(list.size());
    	for(Integer i: list) clone.add(i);
	    return clone;
	}
	public static ArrayList<ArrayList<Integer>> cloneArrayList2(ArrayList<ArrayList<Integer>> list) {
	    ArrayList<ArrayList<Integer>> clone = new ArrayList<ArrayList<Integer>>(list.size());
	    for(ArrayList<Integer> item: list){
	    	ArrayList<Integer> subList = new ArrayList<Integer>();
	    	for(Integer i: item) subList.add(i);
    		clone.add(subList);
	    }
	    return clone;
	}
	public void removeColumn(ArrayList<ArrayList<Integer>> temp, Integer column){
		for(int i=0; i<temp.size();i++){
			// ArrayList<Integer> tempRow = temp.get(j);
			// tempRow.remove(i);
			// temp.set(j, tempRow);
			(temp.get(i)).remove(column);
		}
	}
	public void removeDiagonals(ArrayList<ArrayList<Integer>> board, Integer num, int n){
		for(int i=0; i<board.size(); i++){
			if(num-i>0) (board.get(i)).remove((Integer) (num-i-1));
			if(num+i+1<n) (board.get(i)).remove( (Integer) (num+i+1));
		}
	}
	public ArrayList<ArrayList<Integer>> trim(ArrayList<ArrayList<Integer>> list, int n){
		ArrayList<ArrayList<Integer>> temp = cloneArrayList2(list);
		for(ArrayList<Integer> item : temp) if(item.size()<n) list.remove(item);
		return list;
	}
	public void printArray(ArrayList<Integer> list){
		System.out.print("{");
		for(int i=0; i<list.size(); i++){
			System.out.print(i + " ");
		}
		System.out.println("}");
	}
	public void printBoard(ArrayList<ArrayList<Integer>> board){
	   	for(ArrayList<Integer> item : board){
	   		System.out.print( " | ");
	    	for(Integer i : item) System.out.print( i + " ");
	      	System.out.println("| ");
	   	}
      	System.out.println("\n");
	}
	public static void main(String[] args){
		QueenPuzzle puzzle = new QueenPuzzle();
		for(int i=0; i<10000; i++){
			System.out.println(i);
			puzzle.queenPuzzle(i);
		}
	}	
}
