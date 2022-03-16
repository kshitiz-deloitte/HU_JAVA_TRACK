package Oops_Assignment;

public class Animal {
    private String name;
    private String eat;
    private int count;

    public Animal(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getEat() {
        return eat;
    }

    public void setEat(String eat) {
        this.eat = eat;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Animal Details \n" +
                "Name = " + name +
                "\neat = " + eat +
                "\ncount = " + count ;
    }
}

