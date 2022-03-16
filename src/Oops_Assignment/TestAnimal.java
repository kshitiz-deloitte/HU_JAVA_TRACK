package Oops_Assignment;

public class TestAnimal {
    public static void main(String[] args){
        Animal animals = new Animal("Cow");
        animals.setEat("Grass");
        animals.setCount(15);
        System.out.println(animals.toString());
    }
}
