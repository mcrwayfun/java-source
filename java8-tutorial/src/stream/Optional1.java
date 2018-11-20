package stream;

import java.util.Optional;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/11/5
 */
public class Optional1 {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("bam");

        // true
        boolean present = optional.isPresent();
        System.out.println("optional.isPresent():" + present);

        // "bam"
        String res = optional.get();
        System.out.println("optional.get():" + res);

        // "bam"
        String fallback = optional.orElse("fallback");
        System.out.println("optional.orElse(\"fallback\"):" + fallback);

        // "b"
        optional.ifPresent((s) -> System.out.println(s.charAt(0)));
    }
}
