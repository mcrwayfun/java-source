package com.mcrwayfun.exercise._03;

import java.util.*;

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
        List<Shape> shapeList = Arrays.asList(
                new Circle(), new Square(), new Triangle(), new Rhomboid()
        );
        for (Shape shape : shapeList)
            shape.draw();

        // 向上转型为Shape成功
        Shape shape = new Rhomboid();
        // 向下转型为Rhomboid成功
        Rhomboid rhomboid = (Rhomboid)shape;
        // 向下转型为Circle，编译器不报错，运行期抛ClassCastException异常
        Circle circle = (Circle) shape;
    }
}
/* Output:
Circle.draw()
Square.draw()
Triangle.draw()
Rhomboid.draw()
*/
