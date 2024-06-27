package leetcode.medium;

import java.util.*;

//[["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
//[["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
//[["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com","john00@mail.com"]]
//[["John","johnsmith@mail.com","john_newyork@mail.com"],["John","jhohnsmith@mail.com","johhn00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com","john00@mail.com"]]
//[["a","blah@mail.com"]]
//[["a","blah@mail.com"],["b","clah@mail.com"]]
//[["a","blah@mail.com"],["a","clah@mail.com"]]
//[["a","blah@mail.com"],["a","blah@mail.com"]]
//[["Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"],["Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co"],["Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co"],["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"],["Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"]]
public class L721AccountsMerge {

    public static void main(String[] args) {
        new L721AccountsMerge().run();
        HashSet<Integer> objects = new HashSet<>();
//        Collections.sort(objects, Comparator.naturalOrder());
    }

    public void run(){
        List<List<String>> accounts = new LinkedList<>();
        accounts.add(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"));
        accounts.add(Arrays.asList("John","johnsmith@mail.com","john00@mail.com"));
        accounts.add(Arrays.asList("Mary","mary@mail.com"));
        accounts.add(Arrays.asList("John","johnnybravo@mail.com"));
        System.out.println(accountsMerge(accounts));
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<List<String>>> accMap = new HashMap<>();

        for(List<String> acc: accounts){
            List<String> list = new LinkedList<>();

            for(int i = 1; i < acc.size(); i++){
                list.add(acc.get(i));
            }

            accMap.putIfAbsent(acc.get(0), new LinkedList<>());
            accMap.get(acc.get(0)).add(list);
        }

        for( String key: accMap.keySet() ){
            List<List<String>> lists = accMap.get(key);
            for( int i = 0; i < lists.size(); i++ ){
                List<String> l1 = lists.get(i);
                boolean setL1 = false;
                for( int j = i+1; j < lists.size(); j++ ){
                    List<String> l2 = lists.get(j);
                    List<String> l = new LinkedList<>(l1);
                    l.retainAll(l2);
                    if( !l.isEmpty() ){
                        List<String> l3 = new LinkedList<>(l1);
                        l3.removeAll(l);
                        lists.get(j).addAll(l3);
                        setL1 = true;
                    }
                }
                if( setL1 ) lists.get(i).removeAll(lists.get(i));
            }
        }

        return createListFromMap(accMap);
    }

    public List<List<String>> createListFromMap(Map<String, List<List<String>>> accMap){

        List<List<String>> lst = new LinkedList<>();

        for( String key: accMap.keySet() ){
            for( List<String> l: accMap.get(key) ){
                if( l.isEmpty() ) continue;
                l.sort(Comparator.naturalOrder());
                l.add(0, key);
                lst.add(l);
            }
        }

        return lst;
    }

}
