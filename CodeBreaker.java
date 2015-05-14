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
        temp = sen.charAt(i);
        if(temp<65 || (temp>90 && temp<97) || temp>122) break;
      }
      if(i==sen.length()) return sen;
      String result = longestWord(sen.substring(i+1));
      if(i>=result.length()) result = sen.substring(0,i);
      return result;
    }
    String letterChanges(String str) {
      char[] arr = str.toCharArray();
      for(int i=0; i<str.length(); i++){
        if(arr[i]==90 || arr[i]==122) arr[i]=65;
        else if((arr[i]>=65 && arr[i]<90) || (arr[i]>=97 && arr[i]<122)) arr[i]++;
        if(arr[i]==101) arr[i]=69;
        if(arr[i]==105) arr[i]=73;
        if(arr[i]==111) arr[i]=79;
        if(arr[i]==117) arr[i]=85;
      }
      str = str.copyValueOf(arr);
      return str;
    }
    int simpleAdding(int num) {
      if(num==0) return 0;
      return num+simpleAdding(num-1);
    }
    String firstLetterCapitalize(String str) {
      char[] arr = str.toCharArray();
      if((arr[0]>=65 && arr[0]<90) || (arr[0]>=97 && arr[0]<122)) arr[0]-=32;
      for(int i=0; i<str.length(); i++){
        if(arr[i]==32 && i<str.length()-1 && arr[i+1]!=32 && ((arr[i+1]>=65 && arr[i+1]<90) || (arr[i+1]>=97 && arr[i+1]<122))){
          arr[i+1]-=32;
          i++;
        }
      }
      str = str.copyValueOf(arr);
      return str;
    }
    boolean simpleSymbols(String str) {
      boolean answer=true;
      for(int i=0; i<str.length();i++){
        if(((str.charAt(i)>=65 && str.charAt(i)<90) || (str.charAt(i)>=97 && str.charAt(i)<122)) && (i==0 || i==str.length()-1 || str.charAt(i-1)!='+' || str.charAt(i+1)!='+')) {
          answer=false;
          break;
        }
      }
      return answer;
    }
  public static void main(String[] args){
    Scanner  s = new Scanner(System.in);
    CodeBreaker c = new CodeBreaker();
    System.out.print(c.simpleSymbols(s.nextLine()));
  }

}
