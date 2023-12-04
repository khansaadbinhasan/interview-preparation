package leetcode.easy;

//["hello","i","am","leetcode","hello"]
//"hello"
//1
//["a","b","leetcode"]
//"leetcode"
//0
//["i","eat","leetcode"]
//"ate"
//0
//["i","eat","leetcode"]
//"eat"
//1
//["hello","leetcode", "bro", "how", "i","am","leetcode","hello", "hello", "i", "am", "another"]
//"hello"
//1
//["hello","leetcode", "bro", "how", "i","am","leetcode","hello", "hello", "i", "am", "another"]
//"hello"
//0
//["hello"]
//"hello"
//0
//["hello"]
//"no"
//0
public class L2515ShortestDistanceCircularArray {

    public int closetTarget(String[] words, String target, int startIndex) {

        int minDist = words.length;

        for( int i = 0; i < words.length; i++ ){
            if( words[i].equals(target) ){
                minDist = Math.min(minDist, getMinDistance(words, startIndex, i));
            }
        }

        return minDist == words.length ? -1: minDist;
    }

    public int getMinDistance(String[] words, int startIndex, int targetPos){

        int dist1 = Math.abs(targetPos-startIndex);
        int dist2 = words.length - dist1;

        return Math.min(dist1, dist2);
    }

}
