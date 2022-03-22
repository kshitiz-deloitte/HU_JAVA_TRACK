package Main_Assignment;

import Exceptions.Exceptions;

public class DetailsValidation {

    public static void ExceptionHandling(String msg) throws Exceptions {
        throw new Exceptions(msg);
    }

    public static void validateAge(int age) throws Exceptions {
            if(age<18 || age>90){
                String msg = "Age should be between 18 and 90.";
                ExceptionHandling(msg);
            }
    }

    public static void validateSalary(int salary) throws Exceptions{
            if(salary<=0){
                String msg = "Salary should be greater than 0.";
                ExceptionHandling(msg);
            }
    }

    public static void validatePhone(long phnum) throws Exceptions{
        if(String.valueOf(phnum).length()!=10){
            String msg = "Phone Number should consists of 10 digits only.";
            ExceptionHandling(msg);
        }
    }
}
