package interviews.coupaSDET;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    //file name as input
    //checks whether file is present
    //file is present return true
    //every 5s check if file is present
    //at end of 10mins it should stop polling return false

//    polling
    //timeout
    //file path
    //returns true or false

    //Prerequisite
    //I should be able to create at any timestamp
    //10s file will not be there and API return false
    //11th s i will create the file and API should return after 15s
    //till 1 min return true
    //After 1 min delete the file return false
    //Create again return true
    //Update file --> return true
    //Update file name --> return false
    //8mins have passed now
    //No file is there and i poll it and timeout is 10s, wait for 10s return false

    //Create, Update, Delete
    //Different polling times should work, timeouts should also work
    //Hidden files --> true only
    //File is very large --> 10 GB
    //differ .bat name is same but different ending extension .exe

    //Authentication --> Users that have access should be able to see the results
    //Token should be validated --> random token
    //Some user has access to one folder and file is in another folder --> should not be able to get result

    //Different cloud providers supporting that should work
    //I am hitting the API for 1000 times/s --> Is the API Crashing or not

    //G pay implement to make payments scan QR, UPI id
    //Different devices - Low BW internet, slow devices, old devices, Low quality cameras --> UI Level testing
    //Security level testing --> hack the system --> Is correct user getting the money sending the money
    //Load testing -->
    //Feature testing --> QR Code, UPI Id --> Via backend --> Regression
    //Bank --> Deducting and sending, GPay
    //User --> End user
    //ensure GPay is highly available wont crash in any situation, to crash the application
    //load testing --> Push a lot of requests --> Performance is very bad --> Not acceptable
    //very high load for a long time --> an hour
    //Some server goes --> Machines -->> 10 machines --> 5 machines are down --> recover or not
    //Some downstream service goes down --> That should not impact BAU --> Fallabacks
    //High throughput on DB, Redis, Kafka --> Create a lot of entries at once
    //Network issues --> Delay in getting responses from downstreams --> Performance impact
    //Cloud environment --> AZ -->


    public boolean filePresent(String fileName){//File path absolute

        //Cron --> poll at every n S
        //while

        int start = 0;

        while( start <= 10*60 ){
            //get all the files and the check if file is there or not
            //a/b/c
            if( getAllFiles(fileName.substring(0,fileName.lastIndexOf("/"))).contains(fileName) ){
                return true;
            }
            start += 5;
//            Thread.sleep(5000);
        }

        return false;
    }

//    public int lastIndex(String fileName){
//        int last = 0;
//        for( char c: fileName.toCharArray() ){
//            if( c == '/' ) last
//        }
//
//        return last;
//    }

    public Set<String> getAllFiles(String path){
        //Add it to the set
        Set<String> filePaths = new HashSet<>();

        //Read all files present in path
        File file = new File(path);
//        file.exists()
//                file.get

        return filePaths;
    }

}
