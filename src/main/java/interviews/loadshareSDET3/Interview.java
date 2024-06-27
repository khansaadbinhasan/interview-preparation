package interviews.loadshareSDET3;

import java.util.*;

public class Interview {
    public static void main(String[] args) {
        new Interview().run();
    }

    public void run(){

    }



    public void q2(){
        //{key,value} --> keys will be unique
        //{key1, key2} --> keys1, key2 will be unique

        //get api
        //Fetch user list
        //URL Of API
        //Parameters to pass
        //Map<String, String> headers = new HashMap<>();//
        //HttpClient httpClient = new HttpClient();
        //ResponseObject obj = httpClient.setUrl("URL").setHeaders(headers).queryParams(Map).get();
        //{code, status, body}
        //if(code == 200 && status == OK){
        //  String body = obj.getBody();
        //Convert to this json
        // OBject mapper to map this body to a java object
        //     interviews.loadshareSDET3.User object we create import jar
        //return user list
        // }

        User user = new User();
        List<PhoneNumbers> phoneNumbersList = user.getProfile().getPhoneNumbersList();

        String workNumber = "";
        for( PhoneNumbers phoneNumbers: phoneNumbersList ){
            if( phoneNumbers.getType().equals("work") ) {
                workNumber = phoneNumbers.getNumber();
                break;
            }
        }

        System.out.println("Work number is: " + workNumber);

//        user.getPosts().getCommentsList()

    }

    public void secondLargest(){
        //Second largest number in array
        //duplicates?
//        int[] arr = new int[]{-1,-2,-4,1,2,3,4};//3
        int[] arr = new int[]{};

        if( arr.length < 2 ) return;

        int largest = Integer.MIN_VALUE;//1
        int secondLargest = Integer.MIN_VALUE;//--1


        for (int i = 0; i < arr.length; i++) {
            //2
            if( arr[i] > largest ){
                secondLargest = largest;
                largest = arr[i];
            }
        }

        System.out.println(secondLargest);
    }


}
