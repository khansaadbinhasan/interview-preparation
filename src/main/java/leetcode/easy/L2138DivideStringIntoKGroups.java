package leetcode.easy;

//"abcdefghi"
//3
//"x"
//"abcdefghij"
//3
//"x"
//"a"
//1
//"a"
//"a"
//2
//"a"
//"abcdefgh"
//3
//"r"
//"a"
//10
//"l"
public class L2138DivideStringIntoKGroups {

    public String[] divideString(String s, int k, char fill) {

        int len = (int) Math.ceil( s.length() / (double) k );
        String[] divString = new String[len];

        int j = 0;

        for( int i = 0; i < s.length(); i += k ){
            if( i + k > s.length() ){
                StringBuilder x = new StringBuilder();

                int count = s.length() % k;
                while( count < k ){
                    count++;
                    x.append(fill);
                }

                divString[j] = s.substring(i) + x;
                break;
            }

            divString[j++] = s.substring(i, i+k);
        }

        return divString;
    }

}
