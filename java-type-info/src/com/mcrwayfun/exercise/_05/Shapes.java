package com.mcrwayfun.exercise._05;

abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }

    abstract public String toString();
}

class Circle extends Shape {
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape {
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape {
    public String toString() {
        return "Triangle";
    }
}

class Rhomboid extends Shape {
    public String toString() {
        return "Rhomboid";
    }
}

public class Shapes {
    public static void main(String[] args) {
        rotate(new Rhomboid());
        rotate(new Circle());
    }

    public static void rotate(Shape shape){
        if(shape instanceof Circle)
            System.out.println("shape is rotating");
        else
            System.out.println("shape is not a Circle");
    }
}

/* Output:
shape is not a Circle
shape is rotating
*/
