package leetcode.easy;

//"iiii"
//1
//"leetcode"
//2
//"zbax"
//2
//"a"
//1
//"dfjkakjflasjdkfhjkadshfjkadshfkjadshf"
//4
//"zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz"
//6
public class L1945SumAfterConvert {

    public int getLucky(String s, int k) {

        String numStr = convert(s);

        int sum = 0;

        while( k-- > 0 ){

            sum = 0;

            for( int i = 0; i < numStr.length(); i++ ){
                sum += numStr.charAt(i) - '0';
            }

            numStr = String.valueOf(sum);
        }

        return sum;
    }

    public String convert(String s){
        StringBuilder sb = new StringBuilder();

        for( int i = 0; i < s.length(); i++ ){
            sb.append(s.charAt(i)-'a'+1);
        }

        return sb.toString();
    }

}
