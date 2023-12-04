package leetcode.medium;

import java.util.*;

//[[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
//[[2,3],[1,3],[5,4],[6,4]]
//[[1,2]]
//[[1,2],[3,4],[4,3]]
//[[1,5],[1,10],[1,11],[2,11],[2,13],[2,14],[3,4],[3,8],[4,12],[4,15],[5,6],[5,10],[5,13],[5,19],[6,9],[6,10],[6,13],[6,14],[6,18],[7,10],[7,11],[7,12],[7,14],[8,10],[8,11],[8,14],[9,11],[9,12],[9,13],[9,16],[9,19],[10,17],[11,13],[11,17],[12,15],[16,17],[16,18]]
public class L2225FindPlayersWithZeroOrOneLosses {

    public static void main(String[] args) {
        new L2225FindPlayersWithZeroOrOneLosses().run();
    }

    public void run(){
        System.out.println(findWinners(new int[][]{{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}}));
    }

    public List<List<Integer>> findWinners(int[][] matches) {

        Set<Integer> winners = new HashSet<>();
        Set<Integer> losers = new HashSet<>();
        Set<Integer> winners1 = new HashSet<>();
        Set<Integer> losersMultiple = new HashSet<>();


        for( int i = 0; i < matches.length; i++ ){
            if( !losers.contains(matches[i][0]) ){
                winners.add(matches[i][0]);
            }

            if( !losersMultiple.contains(matches[i][0]) && losers.contains(matches[i][0]) ){
                winners1.add(matches[i][0]);
            }

            if( !losersMultiple.contains(matches[i][1]) ){
                winners1.add(matches[i][1]);
            }

            if( winners.contains(matches[i][1]) ){
                winners.remove(matches[i][1]);
                winners1.add(matches[i][1]);
            }

            if( losers.contains(matches[i][1]) ){
                losersMultiple.add(matches[i][1]);
                winners1.remove(matches[i][1]);
            }

            losers.add(matches[i][1]);
        }

        List<List<Integer>> winnerList = new LinkedList<>();

        LinkedList<Integer> winnerLst = new LinkedList(winners);
        LinkedList<Integer> winner1Lst = new LinkedList(winners1);

        winnerLst.sort(Comparator.naturalOrder());
        winner1Lst.sort(Comparator.naturalOrder());

        winnerList.add(winnerLst);
        winnerList.add(winner1Lst);

        return winnerList;

    }

}
