package leetcode.easy;

public class L611ImageSmoother {

    public int[][] imageSmoother(int[][] img) {
        int[][] smoothed = new int[img.length][img[0].length];

        for( int i = 0; i < img.length; i++ ){
            for( int j = 0; j < img[i].length; j++ ){
                int sum = img[i][j];
                int num = 1;

                if( i-1 >= 0 ) {
                    sum += img[i-1][j];
                    num++;

                    if( j-1 >= 0 ) {
                        sum += img[i-1][j-1];
                        num++;
                    }

                    if( j+1 < img[i].length ) {
                        sum += img[i-1][j+1];
                        num++;
                    }
                }

                if( i+1 < img.length ) {
                    sum += img[i+1][j];
                    num++;

                    if( j-1 >= 0 ) {
                        sum += img[i+1][j-1];
                        num++;
                    }

                    if( j+1 < img[i].length ) {
                        sum += img[i+1][j+1];
                        num++;
                    }
                }

                if( j-1 >= 0 ) {
                    sum += img[i][j-1];
                    num++;
                }

                if( j+1 < img[i].length ) {
                    sum += img[i][j+1];
                    num++;
                }

                smoothed[i][j] = sum / num;
            }
        }

        return smoothed;
    }

}
