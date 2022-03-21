package Exception_handling_assigment;

import java.util.Scanner;

public class ArithmeticExceptionAssignment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        try{
            int res = num1/num2;
            System.out.println("The result is: "+res);
        }catch (ArithmeticException arithmeticException){
            System.out.println("Exception Occurred: "+ arithmeticException.getMessage());

        }finally {
            System.out.println("Thank You");
        }

    }
}
