import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.PriorityQueue;

import java.util.stream.Stream;


import static org.junit.jupiter.api.Assertions.*;

class testPriorityQueueTest {

    private static Stream<Arguments> provideTestData()
    {
        return Stream.of(
                Arguments.of(new int[]{1 ,2, 4, 3}, new int[]{1, 2, 3, 4}),
                Arguments.of(new int[]{3, 8, 18, 32}, new int[]{3, 8, 18, 32}),
                Arguments.of(new int[]{31, 7, 8, 22}, new int[]{7, 8, 22, 31}),
                Arguments.of(new int[]{64, 54, 52, 37}, new int[]{37, 52, 54, 64}),
                Arguments.of(new int[]{9, 15, 3, 2}, new int[]{2, 3, 9, 15})
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void isRealPriorityQueue(int input[], int expected[])
    {
        PriorityQueue<Integer> TestQueue = new PriorityQueue<Integer>();

        for(int i=0; i<input.length; ++i)
        {
            TestQueue.add(input[i]);
        }

        for(int i=0; i<input.length; ++i)
        {
            assertEquals(expected[i], TestQueue.poll());
        }
    }

    @Test
    public void whenExceptionThrown_ClassCastException(){
        PriorityQueue<Object> ObjectQueue = new PriorityQueue<>();
        ObjectQueue.add(1);

        assertThrows(ClassCastException.class,
                ()->{System.out.println((String) ObjectQueue.poll());});


    }

    @Test
    public void whenExceptionThrown_NullPointerException()
    {
        PriorityQueue<Object> NullQueue = new PriorityQueue<>();

        assertThrows(NullPointerException.class,
                ()->{NullQueue.add(null);});
    }

    @Test
    public void whenExceptionThrown_IllegalArgumentException()
    {
        assertThrows(IllegalArgumentException.class,
                ()->{ PriorityQueue<Object> QQueue = new PriorityQueue<>(-1);;});
    }
}