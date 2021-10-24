package leetcode.easy;

import java.util.*;

//["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
//["a@leetcode.com","b@leetcode.com","c@leetcode.com"]
public class L929UniqueEmailAddresses {

    public int numUniqueEmails(String[] emails) {

        int count = 0;

        Set<String> s = new HashSet<>();

        for( String email: emails ){
            s.add(sanitizedEmail(email));
        }

        return s.size();
    }

    public String sanitizedEmail(String email){

        String[] emailDomain = email.split("@");

        if( emailDomain.length != 2 ) return null;

        String local = sanitizedLocal(emailDomain[0]);
        String domain = sanitizedDomain(emailDomain[1]);

        if( local == null || domain == null ) return null;

        return local + "@" + domain;
    }

    public String sanitizedLocal(String local){

        for( char c: local.toCharArray() ){
            if( (c != '.') && (c != '+') && !( c >= 'a' && c <= 'z' ) )
                return null;
        }

        local = local.replaceAll("\\.","");

        if( local.contains("+") )
            local = local.substring(0, local.indexOf("+"));


        return local;
    }

    public String sanitizedDomain(String domain){

        for( char c: domain.toCharArray() ){
            if( (c != '.') && !( c >= 'a' && c <= 'z' ) )
                return null;
        }

        return domain;
    }


}
