package leetcode.blind75;


//"ABAB"
//2
//"AABABBA"
//1
//"ABACDA"
//2
//"ABACDADDD"
//2
//"JHHGHJGHGHPOPOPOPIUIUYUYTRTYRTFGAVDGVTAFGHDVSJHDUSGFJHSGDJHBCJHDBJHDBFHJDBFHJDBFJHDGBFJHDGFHJDGFHJDGFHJDGFHJDGHFDGJFHGDJFOPOPWQOWPOQPWOQ"
//21
//"PPPPPPPPPPPPPPJJJJJJJJJJJJKKKKKKKKKSLKLKLKLKLIUIYUQGHSGAFSGFAGSCACCCCCCCCCCCXXCXCXCXCCXCXCXCX"
//5
//"A"
//1
//"BAAAB"
//2
//"ABACACCCCAAAAAX"
//2
public class L424LongestRepeatingCharacterReplacement {

    public int characterReplacementTLE(String s, int k) {

        int maxLen = 0;

        for( int i = 0; i < 26; i++ ){
            char c = (char)('A'+i);
            int tempK = k;

            for( int j = 0; j < s.length(); j++ ){
                int len = 0;
                int l = j;
                while( l < s.length() ){
                    while( l < s.length() && s.charAt(l) == c ){
                        l++;
                    }

                    if( k <= 0 || l == s.length() ) break;
                    k--;
                    l++;
                }

                len = l-j;
                maxLen = Math.max(maxLen, len);
                k = tempK;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        new L424LongestRepeatingCharacterReplacement().run();
    }

    public void run(){
        System.out.println(characterReplacement2("ABACACCCCAAAAA", 2));
    }

    public int characterReplacement(String s, int k) {
        int maxLen = 0;
        int[] freqArr = new int[26];

        int p1 = 0;
        int p2 = 0;

        freqArr[s.charAt(p1)-'A']++;

        while( p2 < s.length() && p2 >= p1 ){
            int len = p2-p1+1;
            int maxFreq = 0;

            for( int i = 0; i < s.length(); i++ ){
                maxFreq = Math.max(maxFreq, freqArr[s.charAt(i)-'A']);
            }

            if( maxFreq + k >= len ) {
                maxLen = len;
                if( p2+1 < s.length() ) freqArr[s.charAt(p2+1)-'A']++;
                p2++;
            }

            else{
                freqArr[s.charAt(p1)-'A']--;
                p1++;
            }
        }

        return maxLen;
    }

    public int characterReplacement2(String s, int k) {
        //[ABAD[A]EFAAAAA] k = 2

        //substring → max of chars + k <= len → len of substring
        //else freqArr[p1]--, p1++,
        //p2++, freqArr[p2]++

        //freqArr → 26 → p1 = 0 and p2 = 0, freqArr[] → A = 1

        //ABC, k = 1 → PASS
        //ABA[CAC]CCCAAAAAX, k = 2
        //A 0
        //A 1

        s += "A";
        int maxLen = Math.min(k, s.length());//5

        //Maintain a frequency Array, find max char and update maxLen
        int[] freqArr = new int[26];//[0,0,2]

        int p1 = 0;//2

        freqArr[s.charAt(0)-'A']++;

        for( int i = 1; i < s.length(); i++ ){//6,12
            int len = i-p1;//4
            if( findMaxChar(freqArr) + k >= len ){
                maxLen = Math.max(maxLen, len);
                freqArr[s.charAt(i)-'A']++;
            }

            else{
                freqArr[s.charAt(p1)-'A']--;
                p1++;
                i--;
            }
        }

        return maxLen;
    }

    //Find character with max frequency
    public int findMaxChar(int[] freqArr){

        int maxFreq = 0;

        for( int i = 0; i < freqArr.length; i++ ){
            maxFreq = Math.max(maxFreq, freqArr[i]);
        }

        return maxFreq;
    }

}


////[ABAD[A]EFAAAAA] k = 2
//
////substring → max of chars + k <= len → len of substring
////else freqArr[p1]--, p1++,
////p2++, freqArr[p2]++
//
////freqArr → 26 → p1 = 0 and p2 = 0, freqArr[] → A = 1
//
////ABC, k = 1 → PASS
////ABA[CAC]CCCAAAAAX, k = 2
////A 0
////A 1
//public int longestRepeatingCharacterReplacement(String s, int k){
//
//	s += "A";
//int maxLen = Math.min(k, s.length());//5
//
////Maintain a frequency Array, find max char and update maxLen
//int[] freqArr = new int[26];//[0,0,2]
//
//int p1 = 0;//2
//
//freqArr[s.charAt(0)-'A']++;
//
//for( int i = 1; i < s.length(); i++ ){//6,12
//	int len = i-p1;//4
//	if( findMaxChar(freqArr) + k >= len ){
//		maxLen = Math.max(maxLen, len);
//freqArr[s.charAt(i)-'A']++;
//}
//
//else{
//	freqArr[s.charAt(p1)-'A']--;
//	p1++;
//	i--;
//}
//}
//
//
//return maxLen;
//
//}
//
////Find character with max frequency
//public int findMaxChar(int[] freqArr){
//
//int maxFreq = 0;
//
//for( int i = 0; i < freqArr.length; i++ ){
//maxFreq = Math.max(maxFreq, freqArr[i]);
//}
//
//return maxFreq;
//}