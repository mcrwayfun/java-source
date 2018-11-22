import java.io.Closeable;
import java.io.IOException;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/11/20
 */
public class Example2 {

    public static void main(String[] args) {
        try(MyAutoCloseAble myAutoCloseAble = new MyAutoCloseAble()){

        }catch (Exception e){

        }
    }
    
    private static class CloseAble implements Closeable {
        @Override
        public void close() throws IOException {
            System.out.println("AutoCloseAble close resources");
        }
    }

    private static class MyAutoCloseAble implements AutoCloseable {
        @Override
        public void close() throws Exception {
            System.out.println("MyAutoCloseAble close resources");
        }
    }
}
