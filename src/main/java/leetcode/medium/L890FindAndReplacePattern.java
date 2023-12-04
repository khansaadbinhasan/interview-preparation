package leetcode.medium;

import java.util.*;

//["abc","deq","mee","aqq","dkd","ccc"]
//"abb"
//["a","b","c"]
//"a"
//["badc","abab","dddd","dede","yyxx"]
//"baba"
//["ktittgzawn","dgphvfjniv","gceqobzmis","alrztxdlah","jijuevoioe","mawiizpkub","onwpmnujos","zszkptjgzj","zwfvzhrucv","isyaphcszn"]
//"zdqmjnczma"
public class L890FindAndReplacePattern {

    public static void main(String[] args) {
        new L890FindAndReplacePattern().run();
    }

    public void run(){
        System.out.println(
                findAndReplacePattern(
                    new String[]{"ktittgzawn","dgphvfjniv","gceqobzmis","alrztxdlah","jijuevoioe",
                            "mawiizpkub","onwpmnujos","zszkptjgzj","zwfvzhrucv","isyaphcszn"},
                            "zdqmjnczma"
                )
        );
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> patList = new LinkedList<>();

        String[] patternArr = pattern.split("");
        Set<String> s = new HashSet<>();

        for( int i = 0; i < patternArr.length; i++ ){
            s.add(patternArr[i]);
        }

        for( String word: words ){
            Map<String, String> map = new HashMap<>();
            Map<String, String> map2 = new HashMap<>();
            String[] wordChars = word.split("");

            boolean add = true;

            for( int i = 0; i < wordChars.length; i++ ){
                if( map.containsKey(patternArr[i]) && !map.get(patternArr[i]).equals(wordChars[i]) ){
                    add = false;
                    break;
                }

                map.put(patternArr[i], wordChars[i]);
                map2.put(wordChars[i], patternArr[i]);
            }

            if( map.size() != map2.size() ) continue;

            for( String key: map.keySet() ){
                if( !key.equals(map2.get(map.get(key))) ) {
                    add = false;
                    break;
                }
            }

            if( add ) patList.add(word);
        }

        return patList;

    }

    private LinkedHashMap<String, Integer> getWordVsCountMap(String pattern){
        LinkedHashMap<String, Integer> wordVsCountMap = new LinkedHashMap<>();

        for( String p: pattern.split("") ){
            if( !wordVsCountMap.containsKey(p) ){
                wordVsCountMap.put(p, 0);
            }
            wordVsCountMap.put(p, wordVsCountMap.get(p)+1);
        }

        return wordVsCountMap;
    }

    private boolean isPatternEqual(LinkedHashMap<String, Integer> m1, LinkedHashMap<String, Integer> m2){

        List<Integer> l1 = new LinkedList<>();
        List<Integer> l2 = new LinkedList<>();

        for( String key: m1.keySet() ){
            l1.add(m1.get(key));
        }

        for( String key: m2.keySet() ){
            l2.add(m2.get(key));
        }

        return l1.equals(l2);
    }


}
