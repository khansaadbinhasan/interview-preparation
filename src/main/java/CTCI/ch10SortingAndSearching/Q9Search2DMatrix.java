package CTCI.ch10SortingAndSearching;

public class Q9Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        //First search the row in which the element exists --> modified so that mid is given between range
        //Search the row for the elemnt --> Simple Binary Search
        int row = getRow(matrix, target);

        if( row == -1 ) return false;

        int start = 0;
        int end = matrix[row].length-1;

        while( start <= end ){
            int mid = (start+end) / 2;
            if( matrix[row][mid] == target ) return true;
            if( target < matrix[row][mid] ) end = mid-1;
            else start = mid+1;
        }

        return false;
    }

    //Search the row for the elemnt --> Simple Binary Search
    public int getRow(int[][] matrix, int target){
        int start = 0;
        int end = matrix.length-1;

        while( start <= end ){
            int mid = (start + end) / 2;

            if( target >= matrix[mid][0] && target <= matrix[mid][matrix[mid].length-1]) {
                return mid;
            }

            if( matrix[mid][0] > target ) end = mid-1;
            else start = mid+1;
        }

        return -1;
    }

}
