package leetcode.easy;

//4
//2
//7
//1
public class L1374GenerateOddString {

    public String generateTheString(int n) {

        String s = "";

        if( n % 2 == 0 ) {
            s += "b";
            n--;
        }

        return s + generateOddString(n);
    }

    public String generateOddString(int n){

        String s = "";

        for( int i = 0; i < n; i++ ){
            s += "a";
        }

        return s;
    }

}
