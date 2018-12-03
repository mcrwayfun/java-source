package com.mcrwayfun.exercise._04;

import java.util.Arrays;
import java.util.List;

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

        // 向上转型为Shape成功
        Shape shape = new Rhomboid();
        // 向下转型为Rhomboid成功
        Rhomboid rhomboid = (Rhomboid)shape;

        Circle circle = null;
        if(shape instanceof Circle)
            circle = (Circle) shape;
        else
            System.out.println("shape is not a Circle");
    }
}
/* Output:
shape is not a Circle
*/
