package leetcode.medium;

public class L6ZigZagConversion {

//    public String convert(String s, int numRows) {
//
//        //Make a 2 d array in zigzag pattern
//        //read the array from left to right then down
//
//        int numCols = s.length() / 2;
//        char[][] zigzag = new char[numRows][numCols];
//        int ind = 0;
//        int i = 0;
//        int j = 0;
//
//        while( ind < s.length() ){
//            while( ind < s.length() && i < numRows ){
//                zigzag[i++][j] = s.charAt(ind++);
//            }
//
//            i--;
//
//            while( ind < s.length() && i > 0 ){
//                zigzag[--i][++j] = s.charAt(ind++);
//            }
//
//            i++;
//        }
//
//        StringBuilder str = new StringBuilder();
//
//        for( i = 0; i < numRows; i++ ){
//            for( j = 0; j < numCols; j++ ){
//                if( zigzag[i][j] != '\u0000' ){
//                    System.out.print(String.valueOf(zigzag[i][j]) + " ");
//                    str.append(zigzag[i][j]);
//                }
//                System.out.print("  ");
//            }
//
//            System.out.println();
//        }
//
//        return str.toString();
//    }

    public String convert(String s, int numRows) {

        if( numRows == 1 ) return s;

        //Make a 2 d array in zigzag pattern
        //read the array from left to right then down

        int numCols = s.length();
        char[][] zigzag = new char[numRows][numCols];
        int ind = 0;
        int i = 0;
        int j = 0;

        while( ind < s.length() ){
            while( ind < s.length() && i < numRows ){
                zigzag[i++][j] = s.charAt(ind++);
            }

            i--;

            while( ind < s.length() && i > 0 ){
                zigzag[--i][++j] = s.charAt(ind++);
            }

            i++;
        }

        StringBuilder str = new StringBuilder();

        for( i = 0; i < numRows; i++ ){
            for( j = 0; j < numCols; j++ ){
                if( zigzag[i][j] != '\u0000' ){
                    str.append(zigzag[i][j]);
                }
            }
        }

        return str.toString();
    }

}
