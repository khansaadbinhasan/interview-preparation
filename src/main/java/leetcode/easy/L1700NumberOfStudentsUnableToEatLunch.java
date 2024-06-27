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


    public static void main(String[] args) {
        new L1700NumberOfStudentsUnableToEatLunch().run();
    }

    public void run(){
        System.out.println(countStudents2(new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1}));
    }

    public int countStudents2(int[] students, int[] sandwiches) {
        Queue<Integer> studentsQ = new LinkedList<>();
        Queue<Integer> sandwichesQ = new LinkedList<>();

        for( int i = 0; i < students.length; i++ ){
            studentsQ.add(students[i]);
        }

        for( int i = 0; i < sandwiches.length; i++ ){
            sandwichesQ.add(sandwiches[i]);
        }

        int size = studentsQ.size();

        while( !studentsQ.isEmpty() ){
            if( studentsQ.peek() == sandwichesQ.peek() ){
                studentsQ.poll();
                sandwichesQ.poll();
                size = studentsQ.size();
            }

            else {
                if( size == 0 ) return studentsQ.size();
                studentsQ.add(studentsQ.poll());
                size--;
            }
        }

        return 0;
    }

}
