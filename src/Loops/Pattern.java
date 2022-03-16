package Loops;

import java.util.Scanner;

public class Pattern {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows you want to print: ");
        int num = sc.nextInt();
        int temp = num;
        for (int i =0; i<num*2; i++){
            if(i<= num){
                for(int k =temp--; k>0; k--)
                    System.out.print(" ");

                for(int j = num-i; j<num; j++)
                    System.out.print("*");
                System.out.println();
            }else{
                for(int k =(num*2)-i; k<num; k++)
                    System.out.print(" ");
                for(int j = i; j<num*2; j++)
                    System.out.print("*");
                System.out.println();
            }
        }
    }
}
