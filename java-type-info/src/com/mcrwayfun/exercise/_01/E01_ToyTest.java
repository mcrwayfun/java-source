package com.mcrwayfun.exercise._01;

interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

class Toy {
    // Comment out the following default constructor
    // to see NoSuchMethodError from (*1*)
    // Toy() {
    // }

    Toy(int i) {
    }
}

class FancyToy extends Toy
        implements HasBatteries, Waterproof, Shoots {
    FancyToy() {
        super(1);
    }
}


public class E01_ToyTest {
    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() +
                " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name : " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("com.mcrwayfun.exercise._01.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for (Class face : c.getInterfaces())
            printInfo(face);
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            // Requires default constructor:
            obj = up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("Cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}
/*
Class name: com.mcrwayfun.exercise.FancyToy is interface? [false]
Simple name: FancyToy
Canonical name : com.mcrwayfun.exercise.FancyToy
Class name: com.mcrwayfun.exercise.HasBatteries is interface? [true]
Simple name: HasBatteries
Canonical name : com.mcrwayfun.exercise.HasBatteries
Class name: com.mcrwayfun.exercise.Waterproof is interface? [true]
Simple name: Waterproof
Canonical name : com.mcrwayfun.exercise.Waterproof
Class name: com.mcrwayfun.exercise.Shoots is interface? [true]
Simple name: Shoots
Canonical name : com.mcrwayfun.exercise.Shoots
Cannot instantiate
 */