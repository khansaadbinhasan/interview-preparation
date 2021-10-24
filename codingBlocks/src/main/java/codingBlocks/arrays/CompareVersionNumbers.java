package codingBlocks.arrays;

import java.util.Arrays;
import java.util.Scanner;

//1.0.1.6
//1

//1.01
//1.001

//1.0
//1.0.0

//0.1
//1.1

//1.0.1
//1

//7.5.2.4
//7.5.3

//2.5.33
//0.1

//1.0.1.6
//1.000

public class CompareVersionNumbers {

    public static void main(String[] args) {
        new CompareVersionNumbers().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        String version1 = sc.next();
        String version2 = sc.next();

        System.out.println(compareVersion(version1, version2));
    }

    //if s1 > s2 return -1, s1 == s2 return 0, s1 < s2 return -1;
    public int compareVersion(String version1, String version2) {

        int compareVal = 0;

        String[] version1Releases = removeZeros(version1.split("\\."));
        String[] version2Releases = removeZeros(version2.split("\\."));

        if( version1Releases.length == 0 && version2Releases.length == 0 ) return 0;

        int arrLen = Math.min(version1Releases.length, version2Releases.length);

        for (int i = 0; i < arrLen; i++) {

            if( compareStringsAsInts(version1Releases[i], version2Releases[i]) == 0 ) continue;
            else if( compareStringsAsInts(version1Releases[i], version2Releases[i]) == 1 ) return 1;
            else if( compareStringsAsInts(version1Releases[i], version2Releases[i]) == -1 ) return -1;

        }

        if( version1Releases.length > version2Releases.length ) return 1;
        else if( version1Releases.length < version2Releases.length ) return -1;

        return 0;

    }

    //if s1 > s2 return -1, s1 == s2 return 0, s1 < s2 return -1;
    public int compareStringsAsInts(String s1, String s2){

        if( s1.isEmpty() || s2.isEmpty() ) return 0;

        char[] charArr1 = s1.toCharArray();
        char[] charArr2 = s2.toCharArray();

        int iZeros = 0;
        int jZeros = 0;

        while( iZeros < charArr1.length && charArr1[iZeros] == '0' ) iZeros++;
        while( jZeros < charArr2.length && charArr2[jZeros] == '0' ) jZeros++;


        if( iZeros == charArr1.length && jZeros == charArr2.length ) return 0;

        if( charArr1.length - iZeros > charArr2.length - jZeros ) return 1;
        else if( charArr1.length - iZeros < charArr2.length - jZeros ) return -1;


        int lenArr = 0;


        for (int i = iZeros, j = jZeros; i < charArr1.length && j < charArr2.length; i++, j++) {
            if( charArr1[i] == charArr2[j] ) lenArr++;
            else if( charArr1[i] > charArr2[j] ) return 1;
            else if( charArr1[i] < charArr2[j] ) return -1;
        }


        if( lenArr == charArr1.length ) return 0;

        return 0;
    }

    public String[] removeZeros(String[] versionReleases){

        for (int i = versionReleases.length-1; i >= 0 ; i--) {
            if( isZero(versionReleases[i]) )
                versionReleases = Arrays.copyOf(versionReleases, versionReleases.length - 1);
            else break;
        }

        return versionReleases;

    }

    public boolean isZero(String s){
        int iZeros = 0;

        char[] charArr = s.toCharArray();

        while( iZeros < charArr.length && charArr[iZeros] == '0' ) iZeros++;

        if( iZeros == charArr.length ) return true;

        return false;
    }

}
