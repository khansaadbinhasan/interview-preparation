package leetcode.easy;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//[1,1,0,0]
//[0,1,0,1]
//[1,1,1,0,0,1]
//[1,0,0,0,1,1]
public class L1700NumberOfStudentsUnableToEatLunch {

    public int countStudents(int[] students, int[] sandwiches) {

        Stack<Integer> sandwichStack = new Stack<>();
        Queue<Integer> studentQueue = new LinkedList<>();

        for( int i = 0; i < students.length; i++ ){
            studentQueue.add(students[i]);
        }

        for( int i = sandwiches.length-1; i >= 0; i-- ){
            sandwichStack.push(sandwiches[i]);
        }

        int studs = 0;

        while( !studentQueue.isEmpty() && studs != studentQueue.size() ){
            studs = studentQueue.size();

            for(int i = 0; i < studs; i++){
                int frontStudent = studentQueue.poll();

                if( frontStudent != sandwichStack.peek() ){
                    studentQueue.add(frontStudent);
                    continue;
                }

                sandwichStack.pop();
            }
        }


        return studentQueue.size();

    }

}
