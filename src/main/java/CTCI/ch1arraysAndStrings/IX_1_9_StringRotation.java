package CTCI.ch1arraysAndStrings;

public class IX_1_9_StringRotation {

    public boolean rotateString(String s, String goal) {
        if( s.length() != goal.length() ) return false;

        return (s+s).contains(goal);
    }

}
