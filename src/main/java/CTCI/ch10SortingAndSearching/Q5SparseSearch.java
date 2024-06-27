package CTCI.ch10SortingAndSearching;

public class Q5SparseSearch {

    public static void main(String[] args) {
        new Q5SparseSearch().run();
    }

    public void run(){
        System.out.println("ab".compareTo("ac"));//If (this) is greater than the other object then we get -1
        System.out.println("at".compareTo("ball"));//If (this) is greater than the other object then we get -1
        System.out.println(searchStringArr(new String[]{"ab", "ac", "ad"}, "ab"));
        System.out.println(searchStringArr(new String[]{"ab", "ac", "ad"}, "ac"));
        System.out.println(searchStringArr(new String[]{"ab", "ac", "ad"}, "ad"));
        System.out.println(searchStringArr(new String[]{"ab", "ac", "ad"}, "ap"));
    }

    public int searchStringArr(String[] sparseList, String target){

        int start = 0;
        int end = sparseList.length-1;

        while( start <= end ){
            int mid = (start+end)/2;

            int cmp = sparseList[mid].compareTo(target);
            if( cmp == 0 ) return mid;

            if(cmp > 0) end = mid-1;
            else start = mid+1;
        }

        return -1;
    }

}
