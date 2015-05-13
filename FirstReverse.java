import java.util.*;
import java.io.*;

class FirstReverse {
  String reverse(String str) {
    String result ="";
    for(int i= str.length()-1; i>=0; i--){
      result += str.charAt(i);
    }
    return result;
  }

  public static void main (String[] args) {
    // keep this function call here
    Scanner  s = new Scanner(System.in);
    FirstReverse c = new FirstReverse();
    System.out.print(c.reverse(s.nextLine()));
  }

}
