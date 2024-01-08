package CTCI.ch16moderate;

public class Q10LivingPeople {

    public static void main(String[] args) {
        new Q10LivingPeople().run();
    }

    public void run(){
        System.out.println(living(new int[][]{{1900, 2000},{1990,2000},{1995,2000},{1999,2000},{2000,2000}}));
        System.out.println(living(new int[][]{{1900, 2000},{1990,2000},{1995,2000},{1999,2000},{1999,1999}}));
    }

    public int living(int[][] birthDeath){
        int[] years = new int[101];

        for( int i = 0; i < birthDeath.length; i++ ){
            for (int j = birthDeath[i][0]; j <= birthDeath[i][1]; j++) {
                years[j-1900]++;
            }
        }

        int max = 0;
        int maxYears = 0;

        for( int i = 0; i < years.length; i++ ){
            if( years[i] > max ){
                max = years[i];
                maxYears = i;
            }
        }

        return 1900+maxYears;
    }

}
