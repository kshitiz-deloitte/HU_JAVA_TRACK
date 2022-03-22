package Main_Assignment;

import DatabaseHelper.DatabaseHelper;
import Exception_handling_assigment.PasswordException;
import Exception_handling_assigment.PasswordValidation;
import Exceptions.Exceptions;

import java.sql.SQLException;
import java.util.Scanner;

public class UserDatabase {

    private static final Scanner sc = new Scanner(System.in);
    private static String username;
    private static String password;
    private static String repass;
    private static final String DBNAME= "employee";
    private static final String TABLE_NAME = "user_credentials";

    static DatabaseHelper dbHelper = new DatabaseHelper(DBNAME);

    static void login(){
        boolean flag = true;
        while(flag){
            try{
                System.out.println("--Welcome to Login Page--");
                System.out.print("Enter Username: ");
                username = sc.next();
                System.out.print("Enter Password: ");
                password = sc.next();
                if(!dbHelper.checkUser(TABLE_NAME,username)){
                    DetailsValidation.ExceptionHandling("User doesn't exist.");
                    System.out.println("Login unsuccessful");
                }else if(!dbHelper.checkPassword(username,password)){
                    DetailsValidation.ExceptionHandling("Incorrect Password.");
                    System.out.println("Login unsuccessful");
                }else{
                    System.out.println("Login successful");
                    new MainMenu(sc);
                    flag=false;
                }
            }catch (Exception exception){
                System.out.println(exception.getMessage());
            }
        }


    }

    static void signup() {
        try {
            System.out.println("--Welcome to Registration Page--");
            System.out.print("Enter Username: ");
            username = sc.next();
            System.out.print("Enter Password: ");
            password = sc.next();
            System.out.print("Re-Enter Password: ");
            repass = sc.next();
            if (!PasswordValidation.validatePassword(password, repass)) {
                System.out.println("Registration unsuccessful");
            } else if (!PasswordValidation.validatePassword(password)) {
                System.out.println("Registration unsuccessful");
            } else if (dbHelper.checkUser("user_credentials", username)) {
                DetailsValidation.ExceptionHandling("User already exist. Proceed To login.");
                System.out.println("Registration unsuccessful");
            } else {
                dbHelper.addUser(TABLE_NAME, new String[]{username, password});
                System.out.println("Registration successful");
            }
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public static void main(String[] args) throws InterruptedException, PasswordException, Exceptions, SQLException {
        boolean flag = true;
        while (flag){
            System.out.println("******Welcome to User Database*******");
            System.out.println("1.Login \n2.Registration\n3.Exit");
            System.out.print("Enter: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 ->
                    login();

                case 2 ->
                    signup();

                case 3 ->
                    flag = false;

                default -> {
                    System.out.println("Please Enter Valid Number");
                    Thread.sleep(1000);
                }
            }
        }
    }
}
