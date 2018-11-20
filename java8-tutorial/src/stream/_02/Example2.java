package stream._02;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/11/5
 */
public class Example2 {

    public static void main(String[] args) {
        List<Dish> menu = GenDataUtil.getMenu();
        Stream<Dish> stream = menu.stream();
        stream.forEach(System.out::println);
        // throw IllegalStateException
        stream.forEach(System.out::println);
    }
}
