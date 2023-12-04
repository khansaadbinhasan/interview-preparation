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
public class TwoSumTest {

    private TwoSum twoSum;
    private Integer[] inputArr;
    private Integer target;
    private Integer[] outputArr;

    @Before
    public void setup(){
        twoSum = new TwoSum();
    }

    public TwoSumTest(Integer[] inputNums, Integer target, Integer[] outputArr) {
        this.inputArr = inputNums;
        this.target = target;
        this.outputArr = outputArr;
    }

    @Parameterized.Parameters
    public static Collection inputNumsAnsArr() {
        return Arrays.asList(new Object[][] {
                { new Integer[]{1,3,5,7,10,11,6,8}, 10, new Integer[]{1,3} },
                { new Integer[]{2,7,11,15}, 9, new Integer[]{0,1} },
                { new Integer[]{3,2,4}, 6, new Integer[]{1,2} },
                { new Integer[]{3,3,6}, 6, new Integer[]{0,1} }
        });
    }

    @Test
    public void testTwoSumSuccess(){

        int[] inputArr = new int[this.inputArr.length];

        for (int i = 0; i < inputArr.length; i++) {
            inputArr[i] = this.inputArr[i];
        }

        int[] outputNums = this.twoSum.twoSum(inputArr, this.target);

        Integer[] outputArr2 = new Integer[]{outputNums[0], outputNums[1]};

        System.out.println(outputArr[0] + " " + outputArr[1]);
        System.out.println(outputArr2[0] + " " + outputArr2[1]);

        Assert.assertArrayEquals(outputArr, outputArr2);
    }

    @After
    public void tearDown(){

    }

}
