package source.chapter2;

import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/09/20
 * @description
 */
public class Chapter2 {

    @Test
    public void test() {

        List mockedList = mock(List.class);

        //stubbing
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        //following prints "first"
        System.out.println(mockedList.get(0));

        //following throws runtime exception
        System.out.println(mockedList.get(1));

        //following prints "null" because get(999) was not stubbed
        System.out.println(mockedList.get(999));

        //Although it is possible to verify a stubbed invocation, usually it's just redundant
        //If your code cares what get(0) returns, then something else breaks (often even before verify() gets executed).
        //If your code doesn't care what get(0) returns, then it should not be stubbed. Not convinced? See here.
        verify(mockedList).get(0);
    }
}
