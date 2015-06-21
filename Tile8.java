import java.util.*;

public class Tile8{
  String expectedAnswer = "12345678 ";
  String answer ="No answer";
  char[] moves = {'U','D','L','R'};
  public void underNMoves(String sequence, int n){
    ArrayList<Character> myMoves = new ArrayList<Character>();
    findAnswer(sequence,0,n,' ', myMoves);
    return;
  }
  public void findAnswer(String sequence, int steps, int n, char prev, ArrayList<Character> myMoves){
    if(sequence.equals(expectedAnswer)) answer=sequence;
    if(answer.equals(expectedAnswer) || n==steps || sequence.equals("invalid")) return;
    for(char move : moves){
      if(move!=prev){
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
    System.out.println("Entered direction: " + direction + ", space position: " + space);
    switch (direction) {
      case 'U': System.out.println("Moving " + direction);
                if(space>5 && space<9) return "invalid";
                else return switchLetters(sequence, space,space+3);
      case 'D': System.out.println("Moving " + direction);
                if(space<3 && space>=0) return "invalid";
                else return switchLetters(sequence, space,space-3);
      case 'L': System.out.println("Moving " + direction);
                if(space%3==2) return "invalid";
                else return switchLetters(sequence, space,space+1);
      case 'R': System.out.println("Moving " + direction);
                if(space%3==0) return "invalid";
                else return switchLetters(sequence, space,space-1);
      default:  System.out.println("Moving " + direction);
                return "invalid";
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
    myTile.underNMoves("1234567 8",20);
  }
}
