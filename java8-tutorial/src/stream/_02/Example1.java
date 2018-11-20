package stream._02;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/11/5
 */
public class Example1 {

    public static void main(String[] args) {
        List<Dish> menu = GenDataUtil.getMenu();
        List<String> threeHighCaloricDishNames =
                menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());

        System.out.println(threeHighCaloricDishNames);
    }
}
