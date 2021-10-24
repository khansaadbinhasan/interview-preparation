package misc.javaDataStructures;

import java.util.*;
/*
 * Create the Student and Priorities classes here.
 */
public class PriorityQueueExample{
    public static class Student{
        int id;
        String name;
        double cgpa;

        Student(int id, String name, double cgpa){
            this.id = id;
            this.name = name;
            this.cgpa = cgpa;
        }

        public int getId(){
            return this.id;
        }

        public void setId(int id){
            this.id = id;
        }

        public String getName(){
            return this.name;
        }

        public void setName(String name){
            this.name = name;
        }

        public double getCgpa(){
            return this.cgpa;
        }

        public void setCgpa(double cgpa){
            this.cgpa = cgpa;
        }
    }

    public static class Priorities{

        private List<Student> studentList = new ArrayList<>();
        // The Priorities class should implement the method List<Student> getStudents(List<String> events) to process all the given events and return all the students yet to be served in the priority order.

        private PriorityQueue<Student> studentPriorityQueue = new PriorityQueue<>(new Comparator<Student>(){
            @Override
            public int compare(Student s1, Student s2){

                // The student having the highest Cumulative Grade Point Average (CGPA) is served first.
                if( s1.getCgpa() > s2.getCgpa() ) return -1;
                if( s1.getCgpa() < s2.getCgpa() ) return 1;

                // Any students having the same CGPA will be served by name in ascending case-sensitive alphabetical order.
                if( !s1.getName().equals(s2.getName()) ) return s1.getName().compareTo(s2.getName());

                // Any students having the same CGPA and name will be served in ascending order of the id.
                if( s1.getId() < s2.getId() ) return -1;
                if( s1.getId() > s2.getId() ) return 1;

                return 0;
            }
        });

        List<Student> getStudents(List<String> events){

            for(String event: events){
                String[] eventParts = event.split(" ");

                String qAction = eventParts[0];

                if( qAction.equals("SERVED") ){
                    studentPriorityQueue.poll();
                    continue;
                }

//                System.out.println(event);

                Student student = new Student(Integer.parseInt(eventParts[3]), eventParts[1], Double.parseDouble(eventParts[2]));

                this.studentPriorityQueue.add(student);
            }

            while( !studentPriorityQueue.isEmpty() ){
                studentList.add(studentPriorityQueue.poll());
            }

            return this.studentList;

        }
    }


        private final static Scanner scan = new Scanner(System.in);
        private final static Priorities priorities = new Priorities();

        public static void main(String[] args) {
            int totalEvents = Integer.parseInt(scan.nextLine());
            List<String> events = new ArrayList<>();

            while (totalEvents-- != 0) {
                String event = scan.nextLine();
                events.add(event);
            }

            List<Student> students = priorities.getStudents(events);

            if (students.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                for (Student st: students) {
                    System.out.println(st.getName());
                }
            }
        }
}