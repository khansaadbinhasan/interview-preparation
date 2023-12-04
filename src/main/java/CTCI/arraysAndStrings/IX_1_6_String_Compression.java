package CTCI.arraysAndStrings;


//"aaaaabbbbaaaabbddc"
//"aabcccccaaa"
//"abcd"
public class IX_1_6_String_Compression {

    public static void main(String[] args) {
        new IX_1_6_String_Compression().run();
    }

    public void run(){

        System.out.println("Compressed String is: " + compressString("aaaaabbbbaaaabbddc"));

    }

    public String compressString(String s){

        StringBuilder compressedString = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            int freq = 1;
            char c = s.charAt(i);

            while (i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
                freq++;
                i++;
            }

            compressedString.append(c).append(freq);
        }

        return compressedString.length() < s.length() ? compressedString.toString(): s;
    }

}
