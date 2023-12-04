package leetcode.easy;


//[1,2,3]
//[3,2,7]
//4
//[4]
//[4]
//4
//[4]
//[4]
//5
//[1,1,1,1]
//[1,3,2,4]
//7
//[9,8,7,6,5,4,3,2,1]
//[10,10,10,10,10,10,10,10,10]
//5
public class L1450NumberOfStudentsDoingHomework {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {

        int count = 0;

        for(int i = 0; i < startTime.length; i++ ){
            if( queryTime >= startTime[i] && queryTime <= endTime[i] ) count++;
        }

        return count;
    }

}
