package PIE.linkedLists;

public class FindMthFromLast {

    public static void main(String[] args) {
        new FindMthFromLast().run();
    }

    public void run(){

        MyLinkedList mlst = new MyLinkedList();

        MyNode head = mlst.getDemoLinkedList();

        System.out.println(mlst);

        System.out.println(findMthFromLst(head, 6));
    }

    public MyNode findMthFromLst(MyNode head, int m){

        if( head == null ) return null;

        MyNode pointer1 = head;
        MyNode pointer2 = head;

        int count = 0;

        while ( pointer2 != null && count < m ){
            pointer2 = pointer2.next;
            count++;
        }

        if( count < m ) return null;


        while( pointer1 != null && pointer2 != null ){
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        if( pointer2 == null ) return pointer1;

        return null;
    }



}
