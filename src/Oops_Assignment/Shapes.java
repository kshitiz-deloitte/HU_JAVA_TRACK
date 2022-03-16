package Oops_Assignment;

class calArea{

    double calAreaI(double v) {
        return 3.14 * v * v;
    }

    float calAreaI(float l, float b){
        return l * b;
    }

    float calAreaI(float length){
        return length * length;
    }

    double calAreaI(double base, double height){
        return 0.5 * base * height;
    }
}

public class Shapes {
    public static void main(String[] args){
        calArea area = new calArea();
        System.out.println("Area of circle is: "+ area.calAreaI(7.0));
        System.out.println("Area of rectangle is: "+ area.calAreaI(4.0f, 5.0f));
        System.out.println("Area of square is: "+ area.calAreaI(7.0f));
        System.out.println("Area of triangle is: "+ area.calAreaI(5.0, 4.0));
    }
}


