package leetcode.blind75;

//[[1,3],[6,9]]
//[2,5]
//[[1,2],[3,5],[6,7],[8,10],[12,16]]
//[4,8]
//[[1,5]]
//[0,0]
//[[1,2],[3,5],[6,7],[8,10],[12,12],[13,13],[14,15],[16,19]]
//[12,20]
//[[1,1]]
//[1,2]
//[]
//[1,1]
//[[1,3],[4,6]]
//[2,5]
//[[1,5]]
//[6,8]
public class L57InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int N = intervals.length;
        int ind = 0;

        if( N == 0 ) return new int[][]{newInterval};

        boolean isMerged = false;

        for( int i = 0; i < N; i++ ){
            if( intervals[i][0] == -1 ) continue;

            int[] merge = merge(intervals[i], newInterval);
            if( merge[0] != -1 ){
                intervals[i] = merge;
                ind = i;
                isMerged = true;
                break;
            }
        }

        int p1 = ind-1;
        int p2 = ind+1;
        int len = N;

        while( p2 < N ){
            int[] merge = merge(intervals[ind], intervals[p2]);

            if( merge[0] == -1 ) break;
            intervals[ind] = merge;
            intervals[p2] = new int[]{-1,-1};

            p2++;
            len--;
        }

        while( p1 >= 0 ){
            int[] merge = merge(intervals[ind], intervals[p1]);

            if( merge[0] == -1 ) break;
            intervals[ind] = merge;
            intervals[p1] = new int[]{-1,-1};

            p1--;
            len--;
        }

        if( !isMerged ){
            len++;
        }

        int[][] inters = new int[len][2];
        int j = 0;
        int index = 0;

        for( int i = 0; i < N; i++ ){
            if( intervals[i][0] != -1 ){
                if( intervals[i][0] < newInterval[0] ) index++;
                inters[j++] = intervals[i];
            }
        }

        if( !isMerged ){
            for( int i = len-2; i >= index; i-- ){
                inters[i+1] = inters[i];
            }

            inters[index] = newInterval;
        }


        return inters;
    }




    //returns the merged interval i1 is merged between i2, else return -1 if merging not posible
    public int[] merge( int[] i1, int[] i2){
        //[a,b]
        //[c,d]

        int a = i1[0];
        int b = i1[1];
        int c = i2[0];
        int d = i2[1];

        //a < c,
        //a > c
        //b < c,  O
        //b >c,
        //a < d,
        //a > d,  O
        //b < d,
        //b > d

        if( b < c || a > d || a == -1 || c == -1 ) return new int[]{-1,-1};

        return new int[]{Math.min(a,c), Math.max(b,d)};
    }

}
