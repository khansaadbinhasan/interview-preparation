package codingBlocks.arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class CountOfSmallerNumberAfterSelfTest {

    CountOfSmallerNumberAfterSelf countOfSmallerNumberAfterSelf;
    private Integer[] inputArray;
    private List<Integer> expectedResult;

    @Before
    public void setup() {
        countOfSmallerNumberAfterSelf = new CountOfSmallerNumberAfterSelf();
    }

    public CountOfSmallerNumberAfterSelfTest(Integer[] inputArray, List<Integer> expectedResult){
        this.inputArray = inputArray;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection inpArrayAndCountsArray(){

        return Arrays.asList( new Object[][]{
                {new Integer[]{5,2,6,1}, Arrays.asList(2,1,1,0)},
                {new Integer[]{-1}, Arrays.asList(0)},
                {new Integer[]{-1,-1}, Arrays.asList(0,0)}
        });
    }

    @Test
    public void testCountSmallerSuccess(){

//        int[] inpArr = new int[inputArray.length];
//
//        for(int i = 0; i < inputArray.length; i++) inpArr[i] = inputArray[i];
//
////        List<Integer> countList = countOfSmallerNumberAfterSelf.countSmaller(inpArr);
//
//        Assert.assertEquals(countList, expectedResult);
    }
}
