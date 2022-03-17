package CollectionsAndConstructors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Anagrams {
    public static void main(String[] args) {
        ArrayList<Character> arr1 = new ArrayList<Character>();
        ArrayList<Character> arr2 = new ArrayList<Character>();
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        char[] char1 = str1.toLowerCase().toCharArray();
        char[] char2 = str2.toLowerCase().toCharArray();
        for(char i:char1){
            arr1.add(i);
        }
        for(char i:char2){
            arr2.add(i);
        }
        Collections.sort(arr1);
        Collections.sort(arr2);
        if(arr1.equals(arr2)){
            System.out.println("'"+str1+"'"+" and "+"'"+str2+"'"+ " are Anagrams");
        }else{
            System.out.println("'"+str1+"'"+" and "+"'"+str2+"'"+ " are not Anagrams");
        }
    }
}
