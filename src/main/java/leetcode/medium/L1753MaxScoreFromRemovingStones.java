package leetcode.medium;

//2
//4
//6
//4
//4
//6
//1
//8
//8
//1
//1
//1
//12
//10
//13
//100000
//99999
//99998
//4
//4
//7
//8
//16
//22
//24
//19
//24
public class L1753MaxScoreFromRemovingStones {

    public int maximumScore(int a, int b, int c) {

        int smallest = Math.min(Math.min(a,b),c);
        int middle = 0;
        int largest = Math.max(Math.max(a,b),c);

        if( (smallest == a && largest == b) || (smallest == b && largest == a) ) middle = c;
        else if( (smallest == b && largest == c) || (smallest == c && largest == b) ) middle = a;
        else if( (smallest == a && largest == c) || (smallest == c && largest == a) ) middle = b;

        if( largest == middle ){
            if( smallest == 1 ) return largest;

            largest -= Math.ceil(smallest/2.0);
            middle -= (smallest - Math.ceil(smallest/2.0));
            return smallest + Math.min(largest,middle);
        }
        if( smallest+middle <= largest ) return smallest+middle;

        return largest + (smallest+middle-largest)/2;
    }


}
