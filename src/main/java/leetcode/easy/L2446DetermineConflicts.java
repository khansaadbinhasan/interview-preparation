package leetcode.easy;


//["01:15","02:00"]
//["02:00","03:00"]
//["01:00","02:00"]
//["01:20","03:00"]
//["10:00","11:00"]
//["14:00","15:00"]
public class L2446DetermineConflicts {

    public static void main(String[] args){
        new L2446DetermineConflicts().run();
    }

    public void run(){
    }

    public boolean haveConflict(String[] event1, String[] event2) {

        int s1 = Integer.parseInt(event1[0].replaceAll(":", ""));
        int e1 = Integer.parseInt(event1[1].replaceAll(":", ""));

        int s2 = Integer.parseInt(event2[0].replaceAll(":", ""));
        int e2 = Integer.parseInt(event2[1].replaceAll(":", ""));


        return (s1 == s2 || s1 == e2 || s2 == e1 || e1 == e2) ||
                (s1 > s2 && s1 < e2) ||
                (e1 > s2 && e1 < e2) ||
                (s2 > s1 && s2 < e1) ||
                (e2 > s1 && e2 < e1);

    }
}
