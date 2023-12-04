package CTCI.arraysAndStrings;

public class IX_1_5_One_Away {

    public static void main(String[] args) {
        new IX_1_5_One_Away().run();
    }

    public void run(){

        String[][] tests = {{"a", "b", "true"},
                {"", "d", "true"},
                {"d", "de", "true"},
                {"pale", "pse", "false"},
                {"acdsfdsfadsf", "acdsgdsfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdsfads", "true"},
                {"acdsfdsfadsf", "cdsfdsfadsf", "true"},
                {"adfdsfadsf", "acdfdsfdsf", "false"},
                {"adfdsfadsf", "bdfdsfadsg", "false"},
                {"adfdsfadsf", "affdsfads", "false"},
                {"pale", "pkle", "true"},
                {"pkle", "pable", "false"}};

        for (int i = 0; i < tests.length; i++) {
            String[] test = tests[i];
            String a = test[0];
            String b = test[1];
            boolean expected = test[2].equals("true");

            test(a, b, expected);
            test(b, a, expected);
        }

    }

    public void test(String a, String b, boolean expected) {
        boolean resultA = isEditDistanceOne(a, b);

        if (resultA == expected) {
            System.out.println(a + ", " + b + ": success");
        } else {
            System.out.println(a + ", " + b + ": error");
        }
    }

    public boolean isEditDistanceOne(String word1, String word2){

        if( Math.abs(word1.length() - word2.length()) > 1) return false;

        return canInsert(word1, word2) || canInsert(word2, word1) || canUpdate(word1, word2);
    }

    //word1.len - word2.len == 1
    public boolean canInsert(String word1, String word2){

        if( (word1.length() - word2.length()) != 1 ) return false;

        int pointer1 = 0;
        int pointer2 = 0;

        int countNotEquals = 0;

        while( pointer1 < word1.length() && pointer2 < word2.length() ){

            if( word1.charAt(pointer1) != word2.charAt(pointer2) ) {
                if( countNotEquals >= 1 ) return false;

                countNotEquals++;
                pointer1++;
            }

            else {
                pointer1++;
                pointer2++;
            }
        }

        return true;
    }

    public boolean canUpdate(String word1, String word2){
        if( word1.length() != word2.length() ) return false;

        int pointer1 = 0;
        int pointer2 = 0;

        int countNotEquals = 0;

        while( pointer1 < word1.length() && pointer2 < word2.length() ){

            if( word1.charAt(pointer1) != word2.charAt(pointer2) ) {
                if( countNotEquals >= 1 ) return false;

                countNotEquals++;
            }

            pointer1++;
            pointer2++;
        }

        return true;
    }

}
