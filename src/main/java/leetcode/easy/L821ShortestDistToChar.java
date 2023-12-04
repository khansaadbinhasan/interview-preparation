package leetcode.easy;

//"loveleetcode"
//"e"
//"aaab"
//"b"
//"a"
//"a"
//"thisissomestring"
//"s"
//"pleasefindherewhatisthedistances"
//"d"
//"pleasefindherewhatisthedistances"
//"p"
//"pleasefindherewhatisthedistances"
//"s"
//"ab"
//"a"
//"aa"
//"a"
//"ab"
//"b"
public class L821ShortestDistToChar {

    public int[] shortestToChar(String s, char c) {

        if( s.length() == 1 ) return new int[]{0};

        int[] distances = new int[s.length()];

        for( int i = 0; i < s.length(); i++ ){
            if( s.charAt(i) != c ) distances[i] = Integer.MAX_VALUE/2;
        }


        for( int i = 0; i < distances.length; i++ ){

            int pointer = i;

            while( pointer < distances.length && distances[pointer] != 0 ) pointer++;

            int pointer1 = pointer > 0 ? pointer-1: pointer;
            int pointer2 = pointer < distances.length ? pointer+1: pointer;

            // if( pointer > 0 ) pointer--;

            while( pointer1 >= 0 && pointer1+1 < distances.length && distances[pointer1] != 0 ) {

                if( distances[pointer1+1] + 1 < distances[pointer1] ) distances[pointer1] = distances[pointer1+1] + 1;

                else break;

                pointer1--;
            }

            while( pointer2 > 0 && pointer2 < distances.length && distances[pointer2] != 0 ) {

                if( distances[pointer2-1] + 1 < distances[pointer2] ) distances[pointer2] = distances[pointer2-1] + 1;

                else break;

                pointer2++;
            }
        }

        return distances;
    }


}
