package CTCI.mathAndLogicPuzzles;

import codingBlocks.arrays.AttendAllMeetings;

import java.util.*;

public class Q10PoisonedBottle {

    public static void main(String[] args) {
        new Q10PoisonedBottle().run();
    }

    public void run(){
        
    }

    int findPoisonedBottle(ArrayList<Bottle> bottles, ArrayList<TestStrip> testStrips){
        runTests(bottles, testStrips);
        ArrayList<Integer> positive = getPositiveOnDay(testStrips, 7);
        return setBits(positive);
    }

    void runTests(ArrayList<Bottle> bottles, ArrayList<TestStrip> testStrips){
        for(Bottle bottle: bottles){
            int id = bottle.getId();
            int bitIndex = 0;

            while( id > 0 ) {
                if( (id & 1) == 1 )
                    testStrips.get(bitIndex).addDropOnDay(0, bottle);

                bitIndex++;
                id >>= 1;
            }
        }
    }

    ArrayList<Integer> getPositiveOnDay(ArrayList<TestStrip> testStrips, int day){

        ArrayList<Integer> positive = new ArrayList<>();

        for( TestStrip testStrip: testStrips ){
            int id = testStrip.getId();

            if( testStrip.isPositiveOnDay(day) ) positive.add(id);
        }

        return positive;
    }

    int setBits(ArrayList<Integer> positive){

        int id = 0;

        for(Integer bitIndex: positive){
            id |= 1 << bitIndex;
        }

        return id;
    }



}


class Bottle{
    private boolean poisoned = false;
    private int id;

    public Bottle( int id ){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setAsPoisoned(){
        poisoned = true;
    }

    public boolean isPoisoned(){
        return poisoned;
    }
}

class TestStrip{

    public static int DAYS_FOR_RESULT = 7;
    private ArrayList<ArrayList<Bottle>> dropsByDay = new ArrayList<>();
    private int id;

    public TestStrip(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    private void sizeDropsForDay(int day){
        while( dropsByDay.size() <= day ){
            dropsByDay.add(new ArrayList<>());
        }
    }

    public void addDropOnDay(int day, Bottle bottle){
        sizeDropsForDay(day);
        ArrayList<Bottle> drops = dropsByDay.get(day);
        drops.add(bottle);
    }

    private boolean hasPoison(ArrayList<Bottle> bottles){
        for(Bottle b: bottles){
            if( b.isPoisoned() ) return true;
        }

        return false;
    }

    public ArrayList<Bottle> getLastWeeksBottles(int day){
        if( day < DAYS_FOR_RESULT ) return null;

        return dropsByDay.get(day - DAYS_FOR_RESULT);
    }

    public boolean isPositiveOnDay(int day){
        int testDay = day - DAYS_FOR_RESULT;

        if( testDay < 0 || testDay >= dropsByDay.size() ) return false;

        for (int d = 0; d <= testDay; d++) {
            ArrayList<Bottle> bottles = dropsByDay.get(d);

            if( hasPoison(bottles) ) return true;
        }

        return false;
    }

}
