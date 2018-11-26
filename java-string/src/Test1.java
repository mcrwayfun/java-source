/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/11/27
 * @description
 */
public class Test1 {

    public static void main(String[] args) {
        String str1 = new String("mcr");
        String str2 = new String("mcr");
        // false
        System.out.println(str1 == str2);
        // false
        System.out.println(str1.equals(str2));
    }

}
