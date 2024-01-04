package leetcode.medium;

import java.util.*;

//1
//2
//3
//4
//5
//6
//7
//8
public class L22GenerateParanthesis {

    List<String> bracks = new LinkedList<>();

    int numO = 0;
    int numC = 0;


    public List<String> generateParenthesis(int n) {
        numO = n;
        numC = n;

        bracks(numO, numC, "");

        return bracks;
    }


    public void bracks(int numOR, int numCR, String brack){
        if( numOR == 0 && numCR == 0 ) {
            bracks.add(brack);
        }

        int numOT = numO - numOR;
        int numCT = numC - numCR;

        if( numOR > 0 ) bracks(numOR-1, numCR, brack + "(");
        if( numOT > numCT ) bracks(numOR, numCR-1, brack+")");
    }

}
