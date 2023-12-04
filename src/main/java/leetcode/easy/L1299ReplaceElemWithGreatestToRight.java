package leetcode.easy;

//[17,18,5,4,6,1]
//[400]
//[1,2,3,4,5,6,7]
//[5,4,3,2,1]
//[4,3,2,1]
//[1,2,3,4,5,6]
public class L1299ReplaceElemWithGreatestToRight {

    public int[] replaceElements(int[] arr) {

        int pointer = 0;
        int i = 0;

        while( i < arr.length - 1 ){

            pointer = i+1;
            int max = -1;
            int maxI = -1;

            while( pointer < arr.length ) {
                if( arr[pointer] > max ) {
                    maxI = pointer;
                    max = arr[pointer];
                }

                pointer++;
            }

            while( i < maxI ) {
                arr[i] = arr[maxI];
                i++;
            }

        }

        arr[arr.length-1] = -1;

        return arr;
    }

}
