package leetcode.medium;

//"daabcbaabcbc"
//"abc"
//"axxxxyyyyb"
//"xy"
//"abc"
//"a"
//"tlashdhfljsfkldhs"
//"ff"
//"fdfdfdfffff"
//"ff"
//"aabababa"
//"aba"
public class L1910RemoveAllOccurencesOfSubstring {

    public static void main(String[] args) {
        new L1910RemoveAllOccurencesOfSubstring().run();
    }

    public void run(){
        System.out.println(removeOccurrences("daabcbaabcbc", "abc"));
    }

    public String removeOccurrences(String s, String part) {

        while( s.contains(part) && !s.isEmpty()){
            s = s.replaceFirst(part, "");
        }

        return s;
    }
}
