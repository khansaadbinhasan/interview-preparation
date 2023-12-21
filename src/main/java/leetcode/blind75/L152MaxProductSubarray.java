package leetcode.blind75;

//[2,3,-2,4]
//[-2,0,-1]
//[1]
//[1,2,3,4,5]
//[-1,0,-1,0,-1,0,-1]
public class L152MaxProductSubarray {
    class Solution {
        public int maxProduct(int[] arr){

            //special cases
            if( arr[0] <= 0 && arr.length > 3)
            {
                int len0 = 0;

                for( int i = 1; i < arr.length-1; i++ ){
                    if( arr[i-1] == 0 && arr[i] <= 0 && arr[i+1] == 0 ) len0++;
                    else if( arr[i-1] <= 0 && arr[i] == 0 && arr[i+1] <= 0 ) len0++;
                }

                if( len0 == arr.length - 2 ) return 0;
            }


            if( arr.length <= 3 ){

                if( arr.length == 3 )
                    if( arr[0] <= 0 && arr[1] <= 0 && arr[2] <= 0)
                        if( arr[1] == 0 || (arr[0] == 0 && arr[2] == 0)) return 0;

                if( arr.length == 2 )
                    if( arr[0] <= 0 && arr[1] <= 0 )
                        if( arr[0] == 0 || arr[1] == 0 ) return 0;

                if( arr.length == 1 ) return arr[0];

            }



            int N = arr.length;

            int[] positiveProduct = new int[N];
            int[] negativeProduct = new int[N];

            if( arr[0] < 0 ){
                positiveProduct[0] = 1;
                negativeProduct[0] = arr[0];
            }

            else if( arr[0] > 0 ){
                positiveProduct[0] = arr[0];
                negativeProduct[0] = 1;
            }

            else if( arr[0] == 0 ){
                positiveProduct[0] = 1;
                negativeProduct[0] = 1;
            }

            int max = positiveProduct[0];

            for (int i = 1; i < N; i++) {
                if( arr[i] < 0 ){

                    if(positiveProduct[i - 1] > 0 && negativeProduct[i - 1] < 0){
                        positiveProduct[i] = negativeProduct[i-1] * arr[i];
                        negativeProduct[i] = positiveProduct[i-1] * arr[i];
                    }

                    else if( positiveProduct[i-1] > 0 && negativeProduct[i-1] > 0 ){
                        positiveProduct[i] = 1;
                        negativeProduct[i] = positiveProduct[i-1] * arr[i];
                    }
                }

                else if( arr[i] > 0 ){
                    if(positiveProduct[i - 1] > 0 && negativeProduct[i - 1] < 0){
                        positiveProduct[i] = positiveProduct[i-1] * arr[i];
                        negativeProduct[i] = negativeProduct[i-1] * arr[i];
                    }

                    else if( positiveProduct[i-1] > 0 && negativeProduct[i-1] > 0 ){
                        positiveProduct[i] = positiveProduct[i-1] * arr[i];
                        negativeProduct[i] = 1;
                    }
                }

                else if( arr[i] == 0 ){
                    positiveProduct[i] = 1;
                    negativeProduct[i] = 1;
                }

                if( positiveProduct[i] > max ) max = positiveProduct[i];
            }

            return max;
        }

    }

    public int maxProduct(int[] nums) {

        int maxProd = Integer.MIN_VALUE;

        for( int i = 0; i < nums.length; i++ ){
            int prod = nums[i];
            maxProd = Math.max( prod, maxProd );
            for( int j = i+1; j < nums.length; j++ ){
                prod = prod*nums[j];
                maxProd = Math.max( prod, maxProd );
            }
        }

        return maxProd;

    }

    public int maxProduct2(int[] nums) {
        int currMax = nums[0];
        int currMin = nums[0];
        int globalMax = currMax;

        for( int i = 1; i < nums.length; i++ ){
            int temp = currMax;
            currMax = Math.max( Math.max(currMax*nums[i], currMin*nums[i]), nums[i] );
            currMin = Math.min( Math.min(temp*nums[i], currMin*nums[i]), nums[i] );
            globalMax = Math.max(globalMax, currMax);
        }

        return globalMax;
    }

}






















