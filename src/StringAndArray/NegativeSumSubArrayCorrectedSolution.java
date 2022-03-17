package StringAndArray;

import java.util.Arrays;
import java.util.Scanner;

public class NegativeSumSubArrayCorrectedSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++)
            arr[i]=sc.nextInt();
//        1 3 -1 2 -3
        Arrays.sort(arr);
        int count = arr.length;
        int fl = 0;
        int[] nArr;
        int[] pArr;
        for(int q:arr){
            if(q<0){
                fl++;
                continue;
            }
            break;
        }
        nArr = Arrays.copyOfRange(arr, 0, fl);
        pArr = Arrays.copyOfRange(arr, fl, count);
        int res = 0;
        int fin=0;
        for(int i=1; i<nArr.length;i++){
            res+=i;
            fin += res;
        }
        int count2 =0;
        int sum=0;
        for (int k: nArr){
            sum+= k;
            for (int o: pArr){
                if(sum+o<0){
                    count2++;
                }
                int tempSum = k+o;
                if(tempSum<0){
                    count2++;
                }else{
                    break;
                }

            }
        }
        System.out.println(fin+count2);
    }
}
