package leetcode.easy;


//4
//37
//122122
//1
//10000000
//1001
//23242
//34444
public class L492ConstructRectangle {

    public int[] constructRectangle(int area) {

        int diff = area;
        int[] minLW = new int[2];

        // i is width
        for(int i = 1; i <= area; i++ ){
            int length = area / i;
            if( ((double) area / i) == Math.ceil(length) ){
                if( length >= i ){
                    if( length-i < diff ){
                        diff = length - i;
                        minLW[0] = length;
                        minLW[1] = i;
                    }
                }
            }
        }


        return minLW;
    }
}
