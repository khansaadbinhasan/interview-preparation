package leetcode.medium;

import java.util.*;

//["9001 discuss.leetcode.com"]
//["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
//["1 x.com"]
public class L811SubDomainVisitCount {

    public static void main(String[] args) {
        new L811SubDomainVisitCount().run();
    }

    public void run(){
        System.out.println(subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
    }

    public List<String> subdomainVisits(String[] cpdomains) {

        Map<String, Integer> cpDomainMap = new HashMap<>();
        List<String> domaCountList = new LinkedList<>();

        for( String domain: cpdomains ){
            String[] domainCountLst = domain.split(" ");
            Integer domaCount = Integer.parseInt(domainCountLst[0]);
            List<String> domaList = getList(domainCountLst[1]);

            for( String doma: domaList ){
                if( !cpDomainMap.containsKey(doma) ){
                    cpDomainMap.put(doma, 0);
                }

                cpDomainMap.put(doma, cpDomainMap.get(doma)+domaCount);
            }


        }

        for( String key: cpDomainMap.keySet() ){
            domaCountList.add(cpDomainMap.get(key) + " " + key);
        }

        return domaCountList;

    }

    public List<String> getList(String domains){

        List<String> lst = new LinkedList<>();
        String[] domainList = domains.split("\\.");

        String doma = "";

        for( int i = domainList.length-1; i >= 0; i-- ){
            doma = domainList[i] + doma;
            lst.add(doma);
            doma = "." + doma;
        }

        return lst;
    }

}
