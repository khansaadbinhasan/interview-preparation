package pramp;

public class ProductExceptSelf {
    //[8,10,2]
    static int[] arrayOfArrayProducts(int[] arr) {
        if( arr.length < 2 ) return new int[]{};

        // your code goes here
        //arr --> [8,10,2]
    /**
    O(n):-

    [8,10,2]
    [1,8,80]
    */



    /**
    //int[] pre = new int[arr.length];//[1,8,80]
    //int[] post = new int[arr.length];//[20,2,1]
    //int[] mult = new int[arr.length];//[20,16,80]

     //Fill up pre and post arrays
    //pre[0] = 1;
    //post[arr.length-1] = 1;
    //for( int i = 1; i < arr.length; i++ ){
      //pre[i] = pre[i-1]*arr[i-1];
    //}

    for( int i = arr.length-2; i >= 0; i-- ){
      post[i] = post[i+1]*arr[i+1];
    }

    //Make our mult array
    for( int i = 0; i < arr.length; i++ ){
      mult[i] = pre[i] * post[i];
    }

    return mult;
      **/

        //[8,10,2]

//        https://www.linkedin.com/in/sharb/
//        https://www.linkedin.com/in/khan-saad-bin-hasan/
//        tree->  cost
//        ch1
//                ch2
//        ch3
//                ch31


//        subordnates -> cost

        int[] mult = new int[arr.length];//[1,8,80]

        mult[0] = 1;
        for( int i = 1; i < mult.length; i++ ){
            mult[i] = mult[i-1]*arr[i-1];
        }

        int post = 1;//2

        for( int i = arr.length-1; i >= 0; i-- ){
            mult[i] = post * mult[i];
            post = post * arr[i];
        }

        //mult[0] = mult[0] * post;

        //[1,8,80]. post=20
        //[20,16,80]

        // []
        return mult;
    }
    // execute code
    // tc: O(n)
    // sc: 3*O(n)=>

    public static void main(String[] args) {

    }

    //arr --> [8,10,2]
    //[10*2, 8*2, 8*10]
    //prefix mult --> [1, 8, 80]
    //post mult --> [20,2,1]
    //mult[i] = pre[i] * post[i];
    //arr = [2,7,3,4]
    //pre = [1,2,14,42]
    //post = [84,12,4,1]
    //mult = [84,24,56,42]
    //O(n) --> time
    //Space --> O(n)
    //out of bound --> integer --> INteger.MAX_VALUE
    //division operation

    //[]
    //[1] -> []

}
