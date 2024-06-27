package CTCI.ch6mathAndLogicPuzzles;

import java.util.Random;

public class Q7Apocaplyslse {

    public static void main(String[] args) {
        new Q7Apocaplyslse().run();
    }

    public void run(){
        System.out.println(runNFamilies(10000));
    }

    double runNFamilies(int n){
        int boys = 0;
        int girls = 0;

        for (int i = 0; i < n; i++) {
            int[] genders = runOneFamily();

            girls += genders[0];
            boys += genders[1];
        }

        return girls / (double) (boys+girls);
    }

    int[] runOneFamily(){
        Random random = new Random();

        int boys = 0;
        int girls = 0;

        while( girls == 0 ){
            if( random.nextBoolean() ) girls++;
            else boys++;
        }

        return new int[]{girls, boys};
    }

}
