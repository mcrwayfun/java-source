/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/11/27
 */
public class Test3 {

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "ab" + "c";
        // true
        System.out.println(str1 == str2);
        // true
        System.out.println(str1.equals(str2));

        String str3 = new String("abc");
        // false
        System.out.println(str1 == str3);
        // true
        System.out.println(str1.equals(str3));
    }
}
