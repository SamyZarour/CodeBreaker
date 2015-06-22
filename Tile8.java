import java.util.*;

public class Tile8{
  String expectedAnswer = "12345678 ";
  char[] moves = {'U','D','L','R'};
  int minNumMoves=-1;
  ArrayList<Character> minMoves = new ArrayList<Character>();

  public ArrayList<Character> underNMoves(String sequence, int n){
    ArrayList<Character> myMoves = new ArrayList<Character>();
    findAnswer(sequence,0,n,' ', myMoves);
    return minMoves;
  }
  public void findAnswer(String sequence, int steps, int n, char prev, ArrayList<Character> myMoves){
    if(sequence.equals(expectedAnswer) && (minNumMoves>steps || minNumMoves==-1)){
      minNumMoves=steps;
      minMoves=myMoves;
      return;
    }
    if(n==steps || sequence.equals("invalid") || (steps>=minNumMoves && minNumMoves!=-1)) return;
    for(char move : moves){
      if(move!=opposite(prev)){
        ArrayList<Character> container = clone(myMoves);
        container.add(move);
        findAnswer(move(sequence,move), steps++, n, move, container);
      }
    }
    return;
  }
  public int findSpace(String sequence){
    for(int i=0; i<sequence.length(); i++){
      if(sequence.charAt(i)==' ') return i;
    }
    return -1;
  }
  public String move(String sequence, char direction){
    int space = findSpace(sequence);
    switch (direction) {
      case 'U': if(space>5 && space<9) return "invalid";
                else return switchLetters(sequence, space,space+3);
      case 'D': if(space<3 && space>=0) return "invalid";
                else return switchLetters(sequence, space,space-3);
      case 'L': if(space%3==2) return "invalid";
                else return switchLetters(sequence, space,space+1);
      case 'R': if(space%3==0) return "invalid";
                else return switchLetters(sequence, space,space-1);
      default:  System.out.println("Moving " + direction);
                return "invalid";
    }
  }
  public char opposite(char dir){
    switch(dir){
      case 'U': return 'D';
      case 'L': return 'R';
      case 'R': return 'L';
      case 'D': return 'U';
      default: return ' ';
    }
  }
  public String switchLetters(String sequence, int i, int j){
    char[] c = sequence.toCharArray();
    char temp = c[i];
    c[i] = c[j];
    c[j] = temp;
    return new String(c);
  }
  public static ArrayList<Character> clone(ArrayList<Character> list) {
      ArrayList<Character> clone = new ArrayList<Character>(list.size());
      for(Character i: list) clone.add(i);
      return clone;
  }
  public static void main(String[] args){
    Tile8 myTile = new Tile8();
    System.out.println(myTile.underNMoves("1234 6758",5));
  }
}
