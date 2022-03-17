package StringAndArray;

import java.util.Scanner;

public class NegativeSumSubArray {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("");
        int[] arr = {1 ,3, -1, 2, -3};
        int count = arr.length;
        int res = 0;
        int m = 0;
        for(int i:arr){
            int sum =arr[m];
            for(int j=m+1; j<count;j++){
                int tempsum = arr[m] + arr[j];
                sum += arr[j];
                if(tempsum<0){
                    res++;
                    System.out.printf("%d %d \n", arr[m], arr[j]);
                }
//                if(sum <0 && m!=j)
//                    res++;
            }
            System.out.println("res"+res);
            m++;
        }
        System.out.print(res);

    }
}

