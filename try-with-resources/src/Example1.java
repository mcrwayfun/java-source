/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/11/20
 */
public class Example1 {

    public static void main(String[] args) {
        System.out.println("after return " + count(2));
    }

    private static int count(int num) {
        try {
            System.out.println("before return " + num);
            return num;
        } finally {
            return -1;
        }
    }
}
