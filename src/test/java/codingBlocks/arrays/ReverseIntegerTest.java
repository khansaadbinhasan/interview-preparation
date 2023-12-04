package codingBlocks.arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ReverseIntegerTest {

    private ReverseInteger reverseInteger;
    private Integer inputNumber;
    private Integer expectedResult;

    @Before
    public void setup(){
        reverseInteger = new ReverseInteger();
    }

    public ReverseIntegerTest(Integer inputNumber, Integer expectedResult) {
        this.inputNumber = inputNumber;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection numbersAndReversedNumber() {
        return Arrays.asList(new Object[][] {
                { 2, 2 },
                { -1, -1 },
                { 1234, 4321 },
                { 2147483647, 0 },
                { -2147483647, 0 },
                {123, 321},
                {-123, -321},
                {120, 21},
                {0,0}
        });
    }

    @Test
    public void testReverseSuccess(){
        int reversedInteger = reverseInteger.reverse(inputNumber);

//        System.out.println(reversedInteger);

        Assert.assertEquals(expectedResult, Integer.valueOf(reversedInteger));
    }

    @After
    public void tearDown(){

    }

}
