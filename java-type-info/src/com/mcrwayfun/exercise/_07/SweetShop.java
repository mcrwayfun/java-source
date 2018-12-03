package com.mcrwayfun.exercise._07;

class Candy {
    static {
        System.out.println("Loading Candy");
    }
}

class Gum {
    static {
        System.out.println("Loading Gum");
    }
}

class Cookie {
    static {
        System.out.println("Loading Cookie");
    }
}

public class SweetShop {
    public static void main(String[] args)throws Exception{
        for (String arg : args)
            Class.forName(arg);
    }
}
/* Output:
// command input Candy
Loading Candy
*///:~
