import java.util.*;
import java.io.*;

class CodeBreaker {
  public static int[] mergeSort(int [] list) {
    if (list.length <= 1) {
        return list;
    }
    // Split the array in half
    int[] first = new int[list.length / 2];
    int[] second = new int[list.length - first.length];
    System.arraycopy(list, 0, first, 0, first.length);
    System.arraycopy(list, first.length, second, 0, second.length);
    mergeSort(first);
    mergeSort(second);
    merge(first, second, list);
    return list;
  }

  private static void merge(int[] first, int[] second, int [] result) {
      // Next element to consider in the first array
      int iFirst = 0;
      // Next element to consider in the second array
      int iSecond = 0;
      // Next open position in the result
      int j = 0;
      // As long as neither iFirst nor iSecond is past the end, move the
      // smaller element into the result.
      while (iFirst < first.length && iSecond < second.length) {
          if (first[iFirst] < second[iSecond]) {
              result[j] = first[iFirst];
              iFirst++;
              } else {
              result[j] = second[iSecond];
              iSecond++;
          }
          j++;
      }
      // copy what's left
      System.arraycopy(first, iFirst, result, j, first.length - iFirst);
      System.arraycopy(second, iSecond, result, j, second.length - iSecond);
  }
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
  String alphabetSoup(String str){
    char[] arr = str.toCharArray();
    Arrays.sort(arr);
    str = str.copyValueOf(arr);
    return str;
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
  boolean palindromCaseSensitive(String str){
    int length = str.length();
    for(int i=0 ;i<length/2;i++){
      if(str.charAt(i)!=str.charAt(length-i-1)) return false;
    }
    return true;
  }
  boolean palindrom(String str){
    int length = str.length();
    for(int i=0 ;i<length/2;i++){
      if(str.charAt(i)!=str.charAt(length-i-1) && str.charAt(i)-32!=str.charAt(length-i-1) && str.charAt(i)+32!=str.charAt(length-i-1)) return false;
    }
    return true;
  }
  String arithGeo(double[] arr){
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
  String letterCountI(String str){
    String answer="";
    String currentWord="";
    int current_max=0;
    int max=0;
    int[] letters = new int[26];
    for(int i=0; i<str.length();i++){
      if(str.charAt(i)==32){
        letters = new int[26];
        if(current_max>max) {
          answer=currentWord;
          max=current_max;
        }
        current_max=0;
        currentWord="";
      }
      int letter_index=str.charAt(i);
      if(letter_index>=65 && letter_index<=90) letter_index -=65;
      else if(letter_index>=97 && letter_index<=122) letter_index -=97;
      else continue;
      currentWord+=str.charAt(i);
      letters[letter_index]++;
      if(letters[letter_index]>current_max) current_max++;
    }
    if(max<=1) return "-1";
    return answer;
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
  String divisionStringified(int num1, int num2){
    String temp = Integer.toString((num1/num2));
    String result="";
    if(temp.length()<3) return temp;
    for(int i=0; i<temp.length(); i+=3){
      if(i+3<temp.length())result= ","+temp.substring(i,i+3)+result;
      else result = temp.substring(i) + result;
    }
    return result;
  }
  int countingMinutes(String str) {
    int time1=0;
    int time2=0;
    int dash=6;
    int difference=0;
    if (str.charAt(1)>=48 && str.charAt(1)<=57){
      time1=((str.charAt(0)-48)*10)+(str.charAt(1)-48);
      dash++;
    }
    else time1=str.charAt(0)-48;
    if (str.charAt(dash+2)>=48 && str.charAt(dash+2)<=57) time2=((str.charAt(dash+1)-48)*10)+(str.charAt(dash+2)-48);
    else time2=str.charAt(dash+1)-48;
    difference=Math.abs(time1-time2);
    if(str.charAt(dash-2)!=str.charAt(str.length()-2)) difference+=12;
    return difference*60;
  }
  boolean meanMode(int[] arr){
    int maxCount=0;
    int mode=arr[0];
    int sum=0;
    for (int i = 0; i < arr.length; ++i) {
        int count = 0;
        sum+=arr[i];
        for (int j = 0; j < arr.length; ++j) {
            if (arr[j] == arr[i]) ++count;
        }
        if (count > maxCount) {
            maxCount = count;
            mode = arr[i];
        }
    }
    return mode==(sum/arr.length);
  }
  String dashInsert(String str){
    String result="";
    for(int i=0; i<str.length(); i++){
      if(!(str.charAt(i)>=48 && str.charAt(i)<=57)) return "An element of the string is not a number.";
      else if(str.charAt(i)%2==1 && i+1<str.length() && str.charAt(i+1)%2==1) result+= str.charAt(i) + "-";
      else result += str.charAt(i);
    }
    return result;
  }
  String swapCase(String str){
    char container;
    String result = "";
    for(int i=0; i<str.length(); i++){
      container = str.charAt(i);
      if(container>=65 && container<=90) result+= (char) (container+32);
      if(str.charAt(i)>=97 && str.charAt(i)<=122) result+=(char)(container-32);
    }
    return result;
  }
  int numberAddition(String str){
    int power=0;
    int result=0;
    for(int i=str.length()-1; i>=0; i--){
      if(str.charAt(i)>=48 && str.charAt(i)<=57){
        result+=Math.pow(10,power)*(str.charAt(i)-48);
        if(i-1>=0 && str.charAt(i-1)>=48 && str.charAt(i-1)<=57) power++;
        else power=0;
      }
    }
    return result;
  }
  String thirdGreatest(String[] arr){
    String first=arr[0];
    String second="";
    String third="";
    for(int i=1; i<arr.length;i++){
      if(arr[i].length()>third.length())third = arr[i];
      if(arr[i].length()>second.length()){
        third=second;
        second=arr[i];
      }
      if(arr[i].length()>first.length()){
        second=first;
        first=arr[i];
      }
    }
    return third;
  }
  boolean powerOfTwo(double num){
    if(num==0) return true;
    if(num==1) return true;
    if(num%2==0) return powerOfTwo(num/2);
    return false;
  }
  int additivePersistence(int num){
    int times=0;
    while(num/10!=0){
      int sum=0;
      times++;
      while (num > 0) {
        sum+=num % 10;
        num/= 10;
      }
      num=sum;
    }
    return times;
  }
  int multiplicativePersistence(int num){
    int times=0;
    while(num/10!=0){
      int sum=1;
      times++;
      while (num > 0) {
        sum*=num % 10;
        num/= 10;
      }
      num=sum;
    }
    return times;
  }

/******************************************************************************************************
MEDIUM DIFFICULTY
******************************************************************************************************/

  //Brute force method
  //Would be interesting to look into more efficient ways to do this
  Boolean primeTime(int n){
    if(n<2) return false;
    for(int i=2; i<n; i++){
      if(i!=n && n%i==0) return false;
    }
    return true;
  }
  String runLength(String str){
    String result = "";
    int iterator=1;
    for(int i=0; i<str.length()-1;i++){
      if(str.charAt(i)==str.charAt(i+1)){
        iterator++;
        if(i+1==str.length()-1) result+=iterator+""+str.charAt(i+1);
      }
      if(str.charAt(i)!=str.charAt(i+1)){
        result+=iterator + "" + str.charAt(i);
        iterator=1;
        if(i+1==str.length()-1) result+=iterator+""+str.charAt(i+1);
      }
    }
    return result;
  }
  int commonFactor(int n, int m){
    int result=1;
    ArrayList<Integer> dividors = new ArrayList<Integer>();
    for(int i=1; i<=n; i++){
      if(n%i==0) dividors.add(i);
    }
    for(Integer dividor : dividors){
      if(m%dividor==0 && dividor>result) result=dividor;
    }
    return result;
  }
  //Continuing with the brute force approach
  int primeMover(int n){
    int index=0;
    int prime=0;
    for(int i=2; i<10000; i++){
      if(index==n) return prime;
      if(primeTime(i)){
        index++;
        prime=i;
      }
    }
    return prime;
  }
  boolean palindrom2(String str){
    String str2="";
    char container;
    for(int i=0 ;i<str.length();i++){
      container = str.charAt(i);
      if((container>=65 && container<=90) || (container>=97 && container<=122)) str2+=container; ;
    }
    return palindrom(str2);
  }
  boolean stringScramble(String goal, String start){
    ArrayList<Character> chars = new ArrayList<Character>();
    for (char c : start.toCharArray()) {
      chars.add(c);
    }
    return stringScrambleHelper(goal,"",chars);
  }
  boolean stringScrambleHelper(String result, String container, ArrayList<Character> remainder){
    if(result.equals(container)  && remainder.isEmpty()) return true;
    for(int i=0; i<remainder.size(); i++){
      ArrayList<Character> strings = new ArrayList<Character>(remainder);
      strings.remove(remainder.get(i));
      if(stringScrambleHelper(result,container+remainder.get(i),strings)) return true;
    }
    return false;
  }
  //It's the exact same instructions I don't get it...
  String ArithGeoII(double[] arr) {
    return arithGeo(arr);
  }
  boolean arrayAddittionII(double[] arr){
    return arrayAddittion(arr);
  }
  int binaryConverter(int num) {
    int sum=0;
    int pow=0;
    while(num!=0){
      sum+=num%10*Math.pow(2,pow);
      pow++;
      num/=10;
    }
    return sum;
  }
  String letterCountII(String str){
    return letterCountI(str);
  }
  //fitst commit
  String caesarCipher(String str, int num){
    String result = "";
    char container;
    for(int i=0; i<str.length();i++){
      container=str.charAt(i);
      if((container>=65 && container<=90 && container+(num%26)>90) || (container>=97 && container<=122 && container+(num%26)>122)) result+=(char)(container+(num%26)-26);
      else if((container>=65 && container<=90 && container+(num%26)<65) || (container>=97 && container<=122 && container+(num%26)<97)) result+=(char)(container+(num%26)+26);
      else result+=(char)(container+(num%26));
    }
    return result;
  }
  int simpleMode(int[] arr){
    int maxCount=0;
    int mode=arr[0];
    for (int i = 0; i < arr.length; ++i) {
        int count = 0;
        for (int j = 0; j < arr.length; ++j) {
            if (arr[j] == arr[i]) ++count;
        }
        if (count > maxCount) {
            maxCount = count;
            mode = arr[i];
        }
    }
    return mode;
  }
  int consecutive(int[] arr){
    mergeSort(arr);
    int prev = arr[0];
    int result=0;
    for(int i=1; i<arr.length; i++){
      if(prev!=arr[i]) result+=arr[i]-prev-1;
      prev=arr[i];
    }
    return result;
  }
  String formattedDivision(int num1, int num2) {
    return (divisionStringified(num1,num2) + "." + Integer.toString((num1*10000)/num2-num1/num2));
  }
  int countingMinutes2(String str) {
    int time1=0;
    int time2=0;
    int dash=6;
    int difference=0;
    if (str.charAt(1)>=48 && str.charAt(1)<=57){
      time1=((str.charAt(0)-48)*10)+(str.charAt(1)-48);
      dash++;
    }
    else time1=str.charAt(0)-48;
    if (str.charAt(dash+2)>=48 && str.charAt(dash+2)<=57) time2=((str.charAt(dash+1)-48)*10)+(str.charAt(dash+2)-48);
    else time2=str.charAt(dash+1)-48;
    difference=Math.abs(time1-time2);
    if(str.charAt(dash-2)!=str.charAt(str.length()-2)) difference+=12;
    return difference*60;
  }
  int permutation(int num){
    if(num<0) return -1;
    int length = (int)(Math.log10((double) num)+1);
    int digit1;
    int digit2;
      for(int j=1; i+j<length; j++){
        digit1 = ((num - (num/ (int) Math.pow(10,j))* (int) Math.pow(10,j))/ (int) Math.pow(10,j-1));
        digit2 = ((num - (num/ (int) Math.pow(10,j+1))*(int) Math.pow(10,j+1))/ (int) Math.pow(10,j));
        if(digit1<digit2) break;
        int temp;
        int smallestValue=-1;
        while(j>0){
          temp = ((num - (num/ (int) Math.pow(10,j))* (int) Math.pow(10,j))/ (int) Math.pow(10,j-1));
          if(digit1>temp){
            digit1=temp;
            smallest=j;
          }
        }
        int temp =(int) (num + (digit2-digit1)*Math.pow(10,j-1) + (digit1-digit2)*Math.pow(10,j+i-1));
        if(temp>num) return temp;
      }
    return -1;
  }
  public static void main(String[] args){
    Scanner  s = new Scanner(System.in);
    CodeBreaker c = new CodeBreaker();
    String[] arr = {"coder","byte","code"};
    int[] arrNum = {-2,10,4};
    System.out.println(c.permutation(s.nextInt()));
  }
}
