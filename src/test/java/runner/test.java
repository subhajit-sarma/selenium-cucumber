package runner;

import java.util.ArrayList;
import java.util.HashMap;

public class test {

    public static char[] reverseString(String str){
        StringBuffer str1 = new StringBuffer();
        char[] str2 = new char[10];
        int j=0;

        for(int i=str.length()-1; i>=0; i--){
            str1.append(str.charAt(i));
            str2[j] = str.charAt(i);
            j++;
        }
        return str2;
    }

    public static ArrayList<String> findDuplicateWords(String str){

        String[] strArray = str.split(" ");
        ArrayList<String> duplicateList = new ArrayList<>();

        for(int i=0; i<strArray.length; i++){
            for(int j=0; j<strArray.length; j++){
                if(i!=j){
                    if(strArray[i].equals(strArray[j])){
                        if(!duplicateList.contains(strArray[i])){
                            duplicateList.add(strArray[i]);
                        }
                        break;
                    }
                }
            }
        }
        return duplicateList;
    }

    public static Boolean palindromeCheck(String str){

        int start = 0;
        int end = str.length()-1;

        while (start<end) {
            if(str.charAt(start)==str.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    
    }

    public static void swap(int a, int b){
        a = a+b;
        b=a-b;
        a=a-b;
        System.out.println("After swap a="+a+ " and b="+b);
    }

    public static void countNoOfWords(String str){
        String[] strArray = str.split(" ");
        HashMap<String, Integer> strHashMap = new HashMap<>();

        for(int i=0; i<strArray.length-1; i++){
            if(!strHashMap.containsKey(strArray[i])){
                strHashMap.put(strArray[i], 1);
            }else{
                int val = strHashMap.get(strArray[i]);
                val++;
                strHashMap.put(strArray[i], val);
            }
        }
        System.out.println(strHashMap);
    }

    public static void fibonacciSeries(int limit){

        int first = 0;
        int second= 1;
        int temp = 0;
        for(int i=0; i< limit; i++){
            System.out.println(first);
            temp = first;
            first=first+second;
            second = temp;
        }

    }

    public static ArrayList<Character> duplicateChar(String str){

        ArrayList<Character> duplicateChar = new ArrayList<>();

        for(int i=0; i<str.length()-1; i++){
            for(int j=0; j<str.length()-1; j++){
                if(i!=j){
                    if(str.charAt(i)==str.charAt(j) && !duplicateChar.contains(str.charAt(i))){
                        System.out.print("Executing for :"+str.charAt(i)+"\n");
                        duplicateChar.add(str.charAt(i));
                        break;
                    }
                }
            }

        }
            return duplicateChar;
    }

    public static int secondHighetsNumber(int[] numbers){

        int first = numbers[0];
        int second = numbers[1];
        for(int i=2; i<numbers.length; i++){
            if(first<second){
                swap(first, second);
            }
            if(numbers[i]>first){
                second  = first;
                first = numbers[i];
            }else if(numbers[i]>second){
                second = numbers[i];
            }
        }

        return second;

    }


    public static void main(String[] args){
        // System.out.println(reverseString("subhajit"));
        // String findDuplicateWordsString = "java tutorial is a very good tutorial book for java";
        // ArrayList<String> duplicate = findDuplicateWords(findDuplicateWordsString);
        // System.out.println(duplicate);
        // System.out.println(palindromeCheck("56861"));
        // swap(8, 9);
        // countNoOfWords("This is a sample string to count the number of sample words");
        // fibonacciSeries(10);
        // System.out.println(duplicateChar("aaaaakkkkksadfsx"));
        int[] num = {12, 43, 67, 23, 12, 56, 89};
        System.out.println(secondHighetsNumber(num));
    }
}
