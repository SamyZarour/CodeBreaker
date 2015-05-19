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
  String checkNums(int num1, int num2) {
    String result = "true";
    if (num1==num2) result="-1";
    else if(num1>num2) result="false";
    return result;
  }
  String timeConvert(int num) {
    return ""+num/60+":"+num%60;
  }
  Boolean abCheck(String str) {
    boolean result = false;
    for(int i=0; i<str.length();i++){
      if(str.charAt(i)=='a' && i+3<str.length() && str.charAt(i+4)=='b') result= true;
    }
    return result;
  }
  int vowelCount(String str) {
    int result=0;
    for(int i=0; i<str.length();i++){
      if(str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='o' || str.charAt(i)=='i' || str.charAt(i)=='y' || str.charAt(i)=='u' || str.charAt(i)=='A' || str.charAt(i)=='E' || str.charAt(i)=='O' || str.charAt(i)=='I' || str.charAt(i)=='Y' || str.charAt(i)=='U') result++;
    }
    return result;
  }
  int wordCount(String str){
    int i=0;
    int result = 0;
    while(str.charAt(i)==' ' && i<str.length()){
      i++;
    }
    if(i<str.length()) result=1;
    for(;i<str.length();i++){
      if(str.charAt(i)==' ' && i<str.length()-1 && str.charAt(i+1)!=' ') result++;
    }
    return result;
  }
  boolean palindrom(String str){
    int length = str.length();
    for(int i=0 ;i<length/2;i++){
      if(str.charAt(i)!=str.charAt(length-i-1)) return false;
    }
    return true;
  }
  String ArithGeo(double[] arr){
    boolean zero = false;
    boolean arithmetic = false;
    boolean geometric = false;
    if(arr[0]==0 && arr[1]==0 && arr[2]==0) zero = true;
    if(arr[1]!=0 && arr[2]!=0 && arr[0]/ arr[1]==arr[1]/arr[2]) geometric=true;
    if(arr[0]-arr[1]==arr[1]-arr[2]) arithmetic=true;
    for(int i=1; i<arr.length-2;i++){
      if(arithmetic && arr[i]-arr[i+1]!=arr[i+1]-arr[i+2]) arithmetic=false;
      if((geometric && arr[i]/arr[i+1]!=arr[i+1]/arr[i+2]) || arr[2]==0) geometric=false;
      if(arr[i+2]!=0) zero = false;
    }
    if((geometric || zero) && arithmetic) return "Arithmetic and Geometric";
    if(geometric) return "Geometric";
    if(arithmetic) return "Arithmetic";
    return "None";
  }
  boolean arrayAddittion(double[] arr){
  	double max=arr[0];
  	for(int i=1; i<arr.length;i++){
  		if(arr[i]>max) max = arr[i];
  	}
  	double[] copy = new double[arr.length-1];
  	int j=0;
	for(int i=0; i<copy.length;i++){ 
		if(arr[i]==max) j++;
		copy[i]=arr[j];
		j++;
	}
  	return arrayAdd(copy, 0, max);
  }
  boolean arrayAdd(double[] arr, double result, double expected){
  	if(result==expected) return true;
  	//It is faster to use an ArrayList but whatever let's use an array and remove an element manually
  	for(int i=0; i<arr.length; i++){
  		double[] copy = new double[arr.length-1];
  		int k=0;
  		for(int j=0; j<copy.length;j++){
  			if(i==j) k++; 
  			copy[j]=arr[k];
  			k++;
  		}
  		if(arrayAdd(copy, result+arr[i], expected)) return true;
  	}
  	return false;
  }
  void secondGreatLow(double[] arr){
  	double max=arr[0];
  	double low=arr[0];
  	double max2=arr[0];
  	double low2=arr[0];
  	for(int i=1; i<arr.length;i++){
  		if(i==1){
  			low2=arr[i];
  			max2=arr[i];
  		}
  		if(arr[i]>max){
  			max2=max;
  			max=arr[i];
  		}
  		if(arr[i]<low){
  			low2=low;
  			low=arr[i];
  		}
  	}
  	System.out.println("2nd Lowest : " + low2 + ", 2nd Highest : "+ max2);
  }
  public static void main(String[] args){
    Scanner  s = new Scanner(System.in);
    CodeBreaker c = new CodeBreaker();
    double[] arr = { 8,3,16,4,1,24};
    c.secondGreatLow(arr);
  }

}
