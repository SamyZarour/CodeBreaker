import java.util.*;
import java.io.*;

class CodeBreaker {
  String firstReverse(String str) {
    String result ="";
    for(int i= str.length()-1; i>=0; i--){
      result += str.charAt(i);
    }
    return result;
  }

  int firstFactorial(int num) {
      if(num==0) return 1;
      return num*firstFactorial(num-1);
  }
  String longestWord(String sen) {
      if(sen.length()==0) return "";
      char temp;
      int i;
      for(i= 0; i<sen.length(); i++){
        System.out.println(i +" : " +sen);
        temp = sen.charAt(i);
        if(temp<65 || (temp>90 && temp<97) || temp>122) break;
      }
      System.out.println("out");
      if(i==sen.length()) return sen;
      System.out.println("before");
      String result = longestWord(sen.substring(i+1));
      System.out.println("after");
      if(i>=result.length()) result = sen.substring(0,i);
      return result;
    }
  public static void main(String[] args){
    Scanner  s = new Scanner(System.in);
    CodeBreaker c = new CodeBreaker();
    System.out.print(c.longestWord(s.nextLine()));
  }

}
