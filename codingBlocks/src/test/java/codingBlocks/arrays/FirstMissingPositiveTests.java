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
public class FirstMissingPositiveTests {

    private FirstMissingPositive firstMissingPositive;
    private Integer[] inputArray;
    private Integer expectedResult;

    @Before
    public void setup(){

        firstMissingPositive = new FirstMissingPositive();
    }

    public FirstMissingPositiveTests(Integer[] inputArrays, Integer expectedResult) {
        this.inputArray = inputArrays;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection arrayAndMissingInteger() {
        return Arrays.asList(new Object[][] {
                { new Integer[]{1,2,0},3 },
                { new Integer[]{3,4,-1,1}, 2},
                { new Integer[]{7,8,9,11,12}, 1},
                { new Integer[]{-7,1,3,5}, 2},
                { new Integer[]{-3,9,16,4,5,16,-4,9,26,2,1,19,-1,25,7,22,2,-7,14,2,5,-6,1,17,3,24,-4,17,15}, 6}

        });
    }

    @Test
    public void testFindMedianSortedArraysSuccess(){

        int[] inputArr = new int[inputArray.length];

        for (int i = 0; i < inputArr.length; i++) {
            inputArr[i] = inputArray[i];
        }

        int missingInteger = this.firstMissingPositive.firstMissingPositive(inputArr);

        Assert.assertEquals(expectedResult.intValue(), missingInteger);
    }

    @After
    public void tearDown(){

    }


}
