package stacksAndQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateParanthesis {

    public static void main(String[] args) {
        new GenerateParanthesis().run();
    }

    public void run() {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for( String para: generateParenthesis(n) ){
            System.out.println(para);
        }

    }

    public List<String> generateParenthesis(int n) {
        List<String> paraList = new ArrayList<>();
        getParanthesis(n, n, paraList, "");

        return paraList;
    }

    public void getParanthesis(int numParasOpen, int numParasClosed, List<String> paraList, String paraNow){

        if( numParasOpen == 0 && numParasClosed == 0 ) {
            paraList.add(paraNow);
            return;
        }

        if( numParasOpen > 0 )
            getParanthesis(numParasOpen-1, numParasClosed, paraList,paraNow+"(");

        if( numParasClosed > numParasOpen )
            getParanthesis(numParasOpen, numParasClosed-1, paraList, paraNow+ ")");


    }

}