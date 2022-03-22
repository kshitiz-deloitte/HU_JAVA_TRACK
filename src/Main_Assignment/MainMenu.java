package Main_Assignment;

import DatabaseHelper.DatabaseHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
//    private String userID, name, age, companyName, designation, salary, address, phNum;
    private int ch, salary, age;
    private long phone;
    private String[] opt = {"User-ID", "Name", "Age", "Company-Name", "Designation", "Salary", "Address", "Phone Number"};
    private String[] tc = {"userid", "ename", "age", "company_name", "desg", "salary", "address", "phnum"};
    private static final String DBNAME= "employee";
    private static final String TABLE_NAME = "employee_details";

    static DatabaseHelper dbHelper = new DatabaseHelper(DBNAME);
    MainMenu(Scanner sc) throws InterruptedException, SQLException {
        boolean flag = true;
        while (flag){
            System.out.println("******Welcome to User Database*******");
            System.out.print("""
                1.Add User Data\s
                2.List User Data\s
                3.Update User Data\s
                4.Delete User Data\s
                5.Exit\s
                """);
            System.out.print("Enter: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1 ->{
                    System.out.println("Enter user Details");
                    ArrayList<String> userDetails = new ArrayList<>();
                    for (String s : opt) {
                        System.out.print(s + ": ");
                        String input = sc.next();
                        userDetails.add(input);
                        if(s.compareTo("Age")==0){
                            try {
                                assert s != null;
                                age = Integer.parseInt(input);
                                DetailsValidation.validateAge(age);
                            }catch (Exception e){
                                System.out.println(e.getMessage());
                                break;
                            }

                        }else if(s.compareTo("Salary")==0){
                            try {
                                assert s != null;
                                salary = Integer.parseInt(input);
                                DetailsValidation.validateSalary(salary);
                            }catch (Exception e){
                                System.out.println(e.getMessage());
                                break;
                            }

                        }else if(s.compareTo("Phone Number")==0){
                            try {
                                assert s != null;
                                phone = Long.parseLong(input);
                                DetailsValidation.validatePhone(phone);
                            }catch (Exception e){
                                System.out.println(e.getMessage());
                                break;
                            }
                        }

                    }
                    dbHelper.addUser(TABLE_NAME, userDetails);
                }
                case 2 -> {
                    System.out.println("----------- User database records ------------------");
//                    String[] userDetails = {"User-ID", "Name", "Age", "Company-Name", "Designation", "Salary", "Address", "Phone Number"};
                    ArrayList<UserDetails> userDetails = dbHelper.getUserDetails(TABLE_NAME);
                    for (UserDetails user: userDetails){
                        System.out.println(opt[0]+":"+user.getUserid());
                        System.out.println(opt[1]+":"+user.getName());
                        System.out.println(opt[2]+":"+user.getAge());
                        System.out.println(opt[3]+":"+user.getCompanyName());
                        System.out.println(opt[4]+":"+user.getDesg());
                        System.out.println(opt[5]+":"+user.getSalary());
                        System.out.println(opt[6]+":"+user.getAddress());
                        System.out.println(opt[7]+":"+user.getUserid());

                    }
                }
                case 3 ->{
                    System.out.println("User Id to make update: ");
                    String userid = sc.next();
                    boolean check = dbHelper.checkUser(TABLE_NAME, userid);
                    if(check){
                        for (int i =1; i<=7; i++){
                            System.out.println(i+":"+opt[i]);
                        }
                        System.out.println("Select field to make update");
                        ch = sc.nextInt();
                        System.out.println(opt[ch]+": ");
                        String update = sc.next();
                        dbHelper.updateDetails(TABLE_NAME, tc[ch],update, userid);

                    }

                }


                case 4 -> {
                    System.out.println("Please Enter UserId of user you want to delete");
                    String userid = sc.next();
                    dbHelper.deleteDetails(TABLE_NAME, userid);
                }
                case 5 ->
                        flag = false;

                default -> {
                    System.out.println("Please Enter Valid Number");
                    Thread.sleep(1000);
                }
            }

        }

    }
}
