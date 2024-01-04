package CTCI.ch1arraysAndStrings;

//Replace " " with "%20"
public class IX_1_3_URLify {

    public static void main(String[] args) {
        new IX_1_3_URLify().run();
    }

    public void run(){
        System.out.println(replaceSpaces("Mr John Smith    "));
        System.out.println(replaceSpacesII("Mr John Smith    ".toCharArray()));

    }

    public String replaceSpaces(String s){

        char[] charArr = new char[s.length()];

        int indOfLastChar = charArr.length-1;

        while( s.charAt(indOfLastChar) == ' ' ) indOfLastChar--;

        for (int i = s.length()-1; i >= 0 ; i--) {
            if( s.charAt(indOfLastChar) == ' ' ) {
                charArr[i--] = '0';
                charArr[i--] = '2';
                charArr[i--] = '%';

                indOfLastChar--;
            }

            charArr[i] = s.charAt(indOfLastChar--);
        }

        return String.valueOf(charArr);
    }

    public String replaceSpacesII(char[] charArr){

        int indOfLastChar = charArr.length-1;

        while( charArr[indOfLastChar] == ' ' ) indOfLastChar--;

        for (int i = charArr.length-1; i >= 0 ; i--) {
            if( charArr[indOfLastChar] == ' ' ) {
                charArr[i--] = '0';
                charArr[i--] = '2';
                charArr[i--] = '%';

                indOfLastChar--;
            }

            charArr[i] = charArr[indOfLastChar--];
        }

        return String.valueOf(charArr);
    }


}
