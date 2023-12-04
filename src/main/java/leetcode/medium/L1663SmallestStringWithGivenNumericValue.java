package leetcode.medium;

//3
//27
//5
//73
//1
//1
//10000
//100000
public class L1663SmallestStringWithGivenNumericValue {

    public String getSmallestString(int n, int k) {

        StringBuilder sb = new StringBuilder();

        while( n > 0 ){
            if( k <= (n-1)*26 ){
                sb.append("a");
                k--;
            }

            else{
                int diff = k - (n-1)*26;
                char c = (char) ('a' + (diff - 1));
                k -= diff;
                sb.append(c);
            }

            n--;
        }

        return sb.toString();
    }

}
