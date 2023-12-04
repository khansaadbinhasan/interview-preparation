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
public class MedianOfSortedArraysTest {


    private MedianOfSortedArrays medianOfSortedArrays;
    private Integer[][] inputArrays;
    private Double expectedResult;

    @Before
    public void setup(){

        medianOfSortedArrays = new MedianOfSortedArrays();
    }

    public MedianOfSortedArraysTest(Integer[][] inputArrays, Double expectedResult) {
        this.inputArrays = inputArrays;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection numbersAndReversedNumber() {
        return Arrays.asList(new Object[][] {
                { new Integer[][]{{1,3}, {2}}, 2.0 },
                { new Integer[][]{{1,2}, {3,4}}, 2.5 },
                { new Integer[][]{{}, {1}}, 1.0 },
                { new Integer[][]{{2}, {}}, 2.0 },
                { new Integer[][]{{1,2,3}, {4,5,6}}, 3.5 }
        });
    }

    @Test
    public void testFindMedianSortedArraysSuccess(){

        int[] inpArr0 = new int[inputArrays[0].length];
        int[] inpArr1 = new int[inputArrays[1].length];

        for (int i = 0; i < inpArr0.length; i++) inpArr0[i] = inputArrays[0][i];
        for (int i = 0; i < inpArr1.length; i++) inpArr1[i] = inputArrays[1][i];

        Double medianOfArrays = medianOfSortedArrays.findMedianSortedArrays( inpArr0, inpArr1 );

        Assert.assertEquals(expectedResult, medianOfArrays);
    }

    @After
    public void tearDown(){

    }


}
