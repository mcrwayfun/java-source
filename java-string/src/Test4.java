/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/11/27
 */
public class Test4 {


    public static void main(String[] args) {

        // 10W
        int count = 100000;
        double time1 = useString(count);
        System.out.println("String cost:" + time1 + " s");

        double time2 = useStringBuffer(count);
        System.out.println("StringBuffer cost:" + time2 + " s");

        double time3 = useStringBuilder(count);
        System.out.println("StringBuilder cost:" + time3 + " s");
    }

    public static double useString(int count) {
        long startTime = System.nanoTime();

        String str = "abc";
        for (int i = 0; i < count; i++)
            str = str + "abc";

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static double useStringBuffer(int count) {
        long startTime = System.nanoTime();

        StringBuffer sb = new StringBuffer("abc");
        for (int i = 0; i < count; i++)
            sb.append("abc");

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static double useStringBuilder(int count) {
        long startTime = System.nanoTime();

        StringBuilder sb = new StringBuilder("abc");
        for (int i = 0; i < count; i++)
            sb.append("abc");

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}
