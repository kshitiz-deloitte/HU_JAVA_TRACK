package DatabaseHelper;


import Main_Assignment.UserDetails;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseHelper {
    Connection conn;
    Statement stmt;
    String sql;
    ResultSet rs;
    public DatabaseHelper(String dbname) {

        try
        {
            String userName = "root";
            String password = "root123";
            String url = "jdbc:MySQL://localhost/"+dbname;
            conn = DriverManager.getConnection (url, userName, password);

        }
        catch(Exception ex)
        {
            System.err.println ("Cannot connect to database server");
            ex.printStackTrace();
        }
    }

    public boolean checkUser(String table, String user) throws SQLException {
        stmt = conn.createStatement();
        if (table.compareTo("employee_details")==0){
            sql = "SELECT DISTINCT 1 FROM "+table+" where userid=\""+user+"\";";
        }else{
            sql = "SELECT DISTINCT 1 FROM "+table+" where username=\""+user+"\";";
        }
        rs = stmt.executeQuery(sql);
        rs.next();
        try {
            return rs.getInt(1) == 1;
        }catch (Exception ex){
            return false;
        }finally {
            rs.close();
            stmt.close();
        }
    }
    public boolean checkPassword(String user, String password) throws SQLException {
        stmt = conn.createStatement();
        sql = "SELECT DISTINCT 1 FROM user_credentials WHERE username=\""+user+"\" AND password=\""+password+"\";";
        rs = stmt.executeQuery(sql);
        rs.next();
        try {
            return rs.getInt(1) == 1;
        }catch (Exception ex){
            return false;
        }finally {
            rs.close();
            stmt.close();
        }
    }

    public boolean addUser(String table, String[] data) throws SQLException {
        stmt = conn.createStatement();
        sql = "insert into "+table+" values('"+data[0]+"','"+data[1]+"');";
        stmt.executeUpdate(sql);
        return true;
    }
    public boolean addUser(String table, ArrayList<String> data) throws SQLException {
        stmt = conn.createStatement();
        sql = "insert into "+table+" values('"+data.get(0)+"','"+data.get(1)+"','"+data.get(2)+
                "','"+data.get(3)+"','"+data.get(4)+"','"+data.get(5)+"','"+data.get(6)+
                "','"+data.get(7)+"');";
        stmt.executeUpdate(sql);
        return true;
    }

    public ArrayList<UserDetails> getUserDetails(String table) throws SQLException {
        stmt = conn.createStatement();
        sql = "Select * from "+table+";";
        rs = stmt.executeQuery(sql);
        ArrayList<UserDetails> userDetails = new ArrayList<>();
        while (rs.next()){
            String userID = rs.getString("userid");
            String name = rs.getString("ename");
            int age = rs.getInt("age");
            String cname = rs.getString("company_name");
            String desg = rs.getString("desg");
            int salary = rs.getInt("salary");
            String address =  rs.getString("address");
            long phnum = rs.getLong("phnum");
            userDetails.add(new UserDetails(userID, name, cname, desg, address, age, salary, phnum));
        }
        return userDetails;
    }
    public void updateDetails(String table, String col,String data, String userid) throws SQLException {
        stmt = conn.createStatement();
        sql = "update "+table+" set "+col+"='"+data+"'where userid='"+userid+"';";
        stmt.executeUpdate(sql);
    }
    public void deleteDetails(String table, String userid) throws SQLException {
        stmt = conn.createStatement();
        sql = "delete from "+table+" where userid='"+userid+"';";
        stmt.executeUpdate(sql);

    }
}
