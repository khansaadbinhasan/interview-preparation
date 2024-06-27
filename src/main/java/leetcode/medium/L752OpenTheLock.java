package leetcode.medium;

import java.util.*;

//["0201","0101","0102","1212","2002"]
//"0202"
//["8888"]
//"0009"
//["8887","8889","8878","8898","8788","8988","7888","9888"]
//"8888"
//["0000"]
//"0001"
//["0001"]
//"0002"
//["0101","9998"]
//"9999"
//["1301","0113","0202","0122","3012","0131","0200","0203","1232","0222"]
//"2311"
//["0201","0101","0102","1212","2002"]
//"0000"
public class L752OpenTheLock {

    public static void main(String[] args) {
        new L752OpenTheLock().run();
    }

    //0000->1000->2000->2100->2200->2300->2310->2311
    public void run(){
        System.out.println(
                openLock(
                        new String[]{"1301","0113","0202","0122","3012","0131","0200","0203","1232","0222"},
                "2311")
        );
    }

    public int openLock(String[] deadends, String target) {
        if(target.equals("0000")) return 0;

        Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));

        int dist = 0;

        Set<String> visitedSet = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        q.add("0000");
        q.add(null);

        while( !q.isEmpty() ){
            String start = q.poll();

            if( deadendSet.contains(start) ) continue;
            if( visitedSet.contains(start) ) continue;
            if (start == null) {
                dist++;
                if (!q.isEmpty()) {
                    q.add(null);
                }
                continue;
            }
            visitedSet.add(start);

            List<String> neighs = getNeighbors(start);

            for( String n: neighs ){
                if( !deadendSet.contains(n) ){
                    q.add(n);
                }

                if( n.equals(target) ) {
                    return dist+1;
                }
            }

        }

        return -1;
    }

    public List<String> getNeighbors(String s){
        List<String> neighs = new LinkedList<>();

        for( int i = 0; i < s.length(); i++ ){
            neighs.add(replace(s, i, getNext(s.charAt(i))));
            neighs.add(replace(s, i, getPrev(s.charAt(i))));
        }

        return neighs;
    }

    public String replace(String s, int i, char c){
        StringBuilder sb = new StringBuilder(s);

        return sb.replace(i, i+1, String.valueOf(c)).toString();
    }

    public char getNext(char c){
        return (char)(
                '0'+((c-'0')+1)%10
        );
    }

    public char getPrev(char c){
        return (char)(
                '0'+(10+((c-'0')-1))%10
        );
    }
}

//2312
//2321
//2411
//3311
//1311
//2211
//2301
//2310

//5000 3000 4100 4900 4010 4090 4001 4009 4100 2100 3200 3000 3110 3190 3101 3109 4900 2900 3000 3800 3910 3990 3901 3909 4010 2010 3110 3910 3020 3000 3011 3019 4090 2090 3190 3990 3000 3080 3091 3099 4001 2001 3101 3901 3011 3091 3002 3000 4009 2009 3109 3909 3019 3099 3000 3008 3200 1200 2300 2100 2210 2290 2201 2209 3110 1110 2210 2010 2120 2100 2111 2119 3190 1190 2290 2090 2100 2180 2191 2199 3101 1101 2201 2001 2111 2191 2102 2100 3109 1109 2209 2009 2119 2199 2100 2108 3800 1800 2900 2700 2810 2890 2801 2809 3910 1910 2010 2810 2920 2900 2911 2919 3990 1990 2090 2890 2900 2980 2991 2999 3901 1901 2001 2801 2911 2991 2902 2900 3909 1909 2009 2809 2919 2999 2900 2908 3020 1020 2120 2920 2030 2010 2021 2029 3011 1011 2111 2911 2021 2001 2012 2010 3019 1019 2119 2919 2029 2009 2010 2018 3080 1080 2180 2980 2090 2070 2081 2089 3091 1091 2191 2991 2001 2081 2092 2090 3099 1099 2199 2999 2009 2089 2090 2098 3002 1002 2102 2902 2012 2092 2003 2001 3008 1008 2108 2908 2018 2098 2009 2007 2300 0300 1400 1200 1310 1390 1309 2210 0210 1310 1110 1220 1200 1211 1219 2290 0290 1390 1190 1200 1280 1291 1299 2201 0201 1101 1211 1291 1202 1200 2209 0209 1309 1109 1219 1299 1200 1208 2120 0120 1220 1020 1130 1110 1121 1129 2111 0111 1211 1011 1121 1101 1112 1110 2119 0119 1219 1019 1129 1109 1110 1118 2180 0180 1280 1080 1190 1170 1181 1189 2191 0191 1291 1091 1101 1181 1192 1190 2199 0199 1299 1099 1109 1189 1190 1198 2102 0102 1202 1002 1112 1192 1103 1101 2108 0108 1208 1008 1118 1198 1109 1107 2700 0700 1800 1600 1710 1790 1701 1709 2810 0810 1910 1710 1820 1800 1811 1819 2890 0890 1990 1790 1800 1880 1891 1899 2801 0801 1901 1701 1811 1891 1802 1800 2809 0809 1909 1709 1819 1899 1800 1808 2920 0920 1020 1820 1930 1910 1921 1929 2911 0911 1011 1811 1921 1901 1912 1910 2919 0919 1019 1819 1929 1909 1910 1918 2980 0980 1080 1880 1990 1970 1981 1989 2991 0991 1091 1891 1901 1981 1992 1990 2999 0999 1099 1899 1909 1989 1990 1998 2902 0902 1002 1802 1912 1992 1903 1901 2908 0908 1008 1808 1918 1998 1909 1907 2030 0030 1130 1930 1040 1020 1031 1039 2021 0021 1121 1921 1031 1011 1022 1020 2029 0029 1129 1929 1039 1019 1020 1028 2012 0012 1112 1912 1022 1002 1013 1011 2018 0018 1118 1918 1028 1008 1019 1017 2070 0070 1170 1970 1080 1060 1071 1079 2081 0081 1181 1981 1091 1071 1082 1080 2089 0089 1189 1989 1099 1079 1080 1088 2092 0092 1192 1992 1002 1082 1093 1091 2098 0098 1198 1998 1008 1088 1099 1097 2003 0003 1103 1903 1013 1093 1004 1002 2007 0007 1107 1907 1017 1097 1008 1006 7000 5000 6100 6900 6010 6090 6001 6009 8100 6100 7200 7000 7110 7190 7101 7109 8900 6900 7000 7800 7910 7990 7901 7909 8010 6010 7110 7910 7020 7000 7011 7019 8090 6090 7190 7990 7000 7080 7091 7099 8001 6001 7101 7901 7011 7091 7002 7000 8009 6009 7109 7909 7019 7099 7000 7008 9200 7200 8300 8100 8210 8290 8201 8209 9110 7110 8210 8010 8120 8100 8111 8119 9190 7190 8290 8090 8100 8180 8191 8199 9101 7101 8201 8001 8111 8191 8102 8100 9109 7109 8209 8009 8119 8199 8100 8108 9800 7800 8900 8700 8810 8890 8801 8809 9910 7910 8010 8810 8920 8900 8911 8919 9990 7990 8090 8890 8900 8980 8991 8999 9901 7901 8001 8801 8911 8991 8902 8900 9909 7909 8009 8809 8919 8999 8900 8908 9020 7020 8120 8920 8030 8010 8021 8029 9011 7011 8111 8911 8021 8001 8012 8010 9019 7019 8119 8919 8029 8009 8010 8018 9080 7080 8180 8980 8090 8070 8081 8089 9091 7091 8191 8991 8001 8081 8092 8090 9099 7099 8199 8999 8009 8089 8090 8098 9002 7002 8102 8902 8012 8092 8003 8001 9008 7008 8108 8908 8018 8098 8009 8007 0300 8300 9400 9200 9310 9390 9301 9309 0210 8210 9310 9110 9220 9200 9211 9219 0290 8290 9390 9190 9200 9280 9291 9299 0201 8201 9301 9101 9211 9291 9202 9200 0209 8209 9309 9109 9219 9299 9200 9208 0120 8120 9220 9020 9130 9110 9121 9129 0111 8111 9211 9011 9121 9101 9112 9110 0119 8119 9219 9019 9129 9109 9110 9118 0180 8180 9280 9080 9190 9170 9181 9189 0191 8191 9291 9091 9101 9181 9192 9190 0199 8199 9299 9099 9109 9189 9190 9198 0102 8102 9202 9002 9112 9192 9103 9101 0108 8108 9208 9008 9118 9198 9109 9107 0700 8700 9800 9600 9710 9790 9701 9709 0810 8810 9910 9710 9820 9800 9811 9819 0890 8890 9990 9790 9800 9880 9891 9899 0801 8801 9901 9701 9811 9891 9802 9800 0809 8809 9909 9709 9819 9899 9800 9808 0920 8920 9020 9820 9930 9910 9921 9929 0911 8911 9011 9811 9921 9901 9912 9910 0919 8919 9019 9819 9929 9909 9910 9918 0980 8980 9080 9880 9990 9970 9981 9989 0991 8991 9091 9891 9901 9981 9992 9990 0999 8999 9099 9899 9909 9989 9990 9998 0902 8902 9002 9802 9912 9992 9903 9901 0908 8908 9008 9808 9918 9998 9909 9907 0030 8030 9130 9930 9040 9020 9031 9039 0021 8021 9121 9921 9031 9011 9022 9020 0029 8029 9129 9929 9039 9019 9020 9028 0012 8012 9112 9912 9022 9002 9013 9011 0018 8018 9118 9918 9028 9008 9019 9017 0070 8070 9170 9970 9080 9060 9071 9079 0081 8081 9181 9981 9091 9071 9082 9080 0089 8089 9189 9989 9099 9079 9080 9088 0092 8092 9192 9992 9002 9082 9093 9091 0098 8098 9198 9998 9008 9088 9099 9097 0003 8003 9103 9903 9013 9093 9004 9002 0007 8007 9107 9907 9017 9097 9008 9006 1310 9310 0410 0210 0320 0300 0311 0319 1220 9220 0320 0120 0230 0210 0221 0229 1211 9211 0311 0111 0221 0201 0212 0210 1219 9219 0319 0119 0229 0209 0210 0218 1130 9130 0230 0030 0140 0120 0139 1121 9121 0221 0021 0111 0120 1129 9129 0229 0029 0139 0119 0120 0128 1112 9112 0212 0012 0102 0111 1118 9118 0218 0018 0128 0108 0119 0117 1390 9390 0490 0290 0300 0380 0391 0399 1280 9280 0380 0180 0290 0270 0281 0289 1291 9291 0391 0191 0201 0281 0292 0290 1299 9299 0399 0199 0209 0289 0290 0298 1170 9170 0270 0070 0180 0160 0171 0179 1181 9181 0281 0081 0191 0171 0182 0180 1189 9189 0289 0089 0199 0179 0180 0188 1192 9192 0292 0092 0102 0182 0193 0191 1198 9198 0298 0098 0108 0188 0199 0197 9301 0401 0201 0311 0391 0302 0300 1103 9103 0003 0193 0104 0102 1309 9309 0409 0209 0319 0399 0300 0308 1208 9208 0308 0108 0218 0298 0209 0207 1107 9107 0207 0007 0117 0197 0108 0106 1600 9600 0700 0500 0610 0690 0601 0609 1710 9710 0810 0610 0720 0700 0711 0719 1790 9790 0890 0690 0700 0780 0791 0799 1701 9701 0801 0601 0711 0791 0702 0700 1709 9709 0809 0609 0719 0799 0700 0708 1820 9820 0920 0720 0830 0810 0821 0829 1811 9811 0911 0711 0821 0801 0812 0810 1819 9819 0919 0719 0829 0809 0810 0818 1880 9880 0980 0780 0890 0870 0881 0889 1891 9891 0991 0791 0801 0881 0892 0890 1899 9899 0999 0799 0809 0889 0890 0898 1802 9802 0902 0702 0812 0892 0803 0801 1808 9808 0908 0708 0818 0898 0809 0807 1930 9930 0030 0830 0940 0920 0931 0939 1921 9921 0021 0821 0931 0911 0922 0920 1929 9929 0029 0829 0939 0919 0920 0928 1912 9912 0012 0812 0922 0902 0913 0911 1918 9918 0018 0818 0928 0908 0919 0917 1970 9970 0070 0870 0980 0960 0971 0979 1981 9981 0081 0881 0991 0971 0982 0980 1989 9989 0089 0889 0999 0979 0980 0988 1992 9992 0092 0892 0902 0982 0993 0991 1998 9998 0098 0898 0908 0988 0999 0997 1903 9903 0003 0803 0913 0993 0904 0902 1907 9907 0007 0807 0917 0997 0908 0906 1040 9040 0140 0940 0050 0030 0041 0049 1031 9031 0931 0041 0021 0032 0030 1039 9039 0139 0939 0049 0029 0030 0038 1022 9022 0922 0032 0012 0023 0021 1028 9028 0128 0928 0038 0018 0029 0027 1013 9013 0913 0023 0003 0014 0012 1017 9017 0117 0917 0027 0007 0018 0016 1060 9060 0160 0960 0070 0050 0061 0069 1071 9071 0171 0971 0081 0061 0072 0070 1079 9079 0179 0979 0089 0069 0070 0078 1082 9082 0182 0982 0092 0072 0083 0081 1088 9088 0188 0988 0098 0078 0089 0087 1093 9093 0193 0993 0003 0083 0094 0092 1097 9097 0197 0997 0007 0087 0098 0096 1004 9004 0104 0904 0014 0094 0005 0003 1006 9006 0106 0906 0016 0096 0007 0005


//0000->1000->2000->2100->2200->2300->2310->2311