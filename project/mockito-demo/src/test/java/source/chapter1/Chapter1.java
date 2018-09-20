package source.chapter1;

import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/09/20
 * @description
 */
public class Chapter1 {

    @Test
    public void test(){
        //mock creation
        List mockedList = mock(List.class);

        //using mock object
        mockedList.add("one");
        mockedList.clear();

        //verification
        //verify the action mockedList.add("one") has done once
        verify(mockedList).add("one");
        verify(mockedList).clear();

    }
}
