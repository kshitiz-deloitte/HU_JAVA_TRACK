package Main_Assignment;

public class UserDetails {
    private String userid, name, companyName, desg, address;
    private int age, salary;
    private long phnum;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDesg() {
        return desg;
    }

    public void setDesg(String desg) {
        this.desg = desg;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public long getPhnum() {
        return phnum;
    }

    public void setPhnum(long phnum) {
        this.phnum = phnum;
    }

    public UserDetails(String userid, String name, String companyName, String desg, String address, int age, int salary, long phnum) {
        this.userid = userid;
        this.name = name;
        this.companyName = companyName;
        this.desg = desg;
        this.address = address;
        this.age = age;
        this.salary = salary;
        this.phnum = phnum;
    }
}
