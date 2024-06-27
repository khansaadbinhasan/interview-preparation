package leetcode.medium;

//"ADOBECODEBANC"
//"ABC"
//"a"
//"a"
//"a"
//"aa"
//"ab"
//"a"
public class L76MinimumWindowSubstring {

    public static void main(String[] args) {
        new L76MinimumWindowSubstring().run();
    }

    public void run(){
        System.out.println(minWindow("ab", "a"));
    }

    public String minWindow(String s, String t){//ab, a
        int min = Integer.MAX_VALUE;
        int[] freqArr2 = new int[256];
        String ans = "";

        for( int i = 0; i < t.length(); i++ ){
            freqArr2[t.charAt(i)]++;
        }

        for( int i = 0; i < s.length(); i++ ){
            int[] freqArr1 = new int[256];

            for( int j = i; j < s.length(); j++ ){
                freqArr1[s.charAt(j)]++;
                if( contains(freqArr1, freqArr2) ){
                    if( (j-i+1) < min ){
                        ans = s.substring(i, j+1);
                        min = j-i+1;
                    }
                }
            }
        }

        return ans;
    }

    //freq1 contains freq2 return true else false
    public boolean contains(int[] freq1, int[] freq2){
        for( int i = 0; i < freq1.length; i++ ){
            if( freq1[i] < freq2[i] ) return false;
        }

        return true;
    }


}
