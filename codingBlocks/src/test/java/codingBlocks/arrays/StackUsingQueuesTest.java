package codingBlocks.arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackUsingQueuesTest {

    StackUsingQueues stack = new StackUsingQueues();

    @Before
    public void setup(){

    }

    @Test
    public void testIsEmptySuccess(){
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPushSuccess(){

        stack.push(1);
        stack.push(2);
        stack.push(3);

        int x = 4;

        int[] newStack = new int[stack.stack.length+1];
        System.arraycopy(stack.stack, 0, newStack, 0, newStack.length-1);
        newStack[newStack.length-1] = x;

        stack.push(x);

        assertArrayEquals(newStack, stack.stack);
    }

    @Test
    public void testPopSuccess(){

        stack.push(1);
        stack.push(2);
        stack.push(3);

        int x = stack.pop();

        assertEquals(x, 3);
        assertArrayEquals(new int[]{1,2}, stack.stack);
    }

    @Test
    public void testTopSuccess(){

        stack.push(1);
        stack.push(2);
        stack.push(3);

        int x = stack.top();

        assertEquals(x, 3);
        assertArrayEquals(new int[]{1,2,3}, stack.stack);
    }


    @After
    public void destroy(){

    }

}
