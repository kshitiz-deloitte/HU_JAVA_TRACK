package Exception_handling_assigment;

import java.util.Scanner;

public class PasswordValidation {

    static void ExceptionHandling(String msg) throws PasswordException{
        throw new PasswordException(msg);
    }
    static void validatePassword(String pass) throws PasswordException {
        if(!(pass.matches(".{5,10}"))){
            String msg = "Password should be in a range of 5 to 10";
            ExceptionHandling(msg);
        }else if(!(pass.matches("^.*[A-Z].*$"))){
            String msg = "At least one Uppercase alphabet";
            ExceptionHandling(msg);
        }else if(!(pass.matches("^.*[a-z].*$"))){
            String msg = "At least one Lowercase alphabet";
            ExceptionHandling(msg);
        }else if(pass.matches("^[^0-9]*$")){
            String msg = "At least one digit 1,2,3,….";
            ExceptionHandling(msg);
        }else if(!(pass.matches("^.*[@#&%*!].*$"))){
            String msg = "At least one special characters “@ #  &  % * !";
            ExceptionHandling(msg);
        }

    }
    public static void main(String[] args) throws PasswordException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password = sc.nextLine();
        try{
            validatePassword(password);
            System.out.println("Valid Password");
        }catch (PasswordException passwordException){
            System.out.println("Invalid Password");
            passwordException.printStackTrace();
        }


    }
}

//Password should be in a range of 5 to 10 characters with below combination
//     At least one Uppercase alphabet
//     At least one Lowercase alphabet
//     At least one special characters “@ #  &  % * ! ”
//     At least one digit 1,2,3,….