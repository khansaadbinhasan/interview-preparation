package interviews.sliceSDET.containsW;

import java.util.LinkedList;
import java.util.List;

public class CheckContains {

    public static void main(String[] args) {
        new CheckContains().run();
    }

    public void run(){
        List<Weather> weatherList1 = weatherList1();
        List<Weather> weatherList2 = weatherList2();

        System.out.println(weatherList1.containsAll(weatherList2));
    }

    public List<Weather> weatherList1(){
        Weather w1 = new Weather("Delhi", 10);
        Weather w2 = new Weather("Bangalore", 13);
        Weather w3 = new Weather("Nagpur", 43);

        List<Weather> weatherList1 = new LinkedList<>();

        weatherList1.add(w1);
        weatherList1.add(w2);
        weatherList1.add(w3);

        return weatherList1;
    }

    public List<Weather> weatherList2(){
        Weather w1 = new Weather("Delhi", 10);
        Weather w2 = new Weather("Bangalore", 13);
        Weather w3 = new Weather("Chennai", 13);

        List<Weather> weatherList1 = new LinkedList<>();

        weatherList1.add(w1);
        weatherList1.add(w2);
        weatherList1.add(w3);

        System.out.println(weatherList1.indexOf(w2));

        return weatherList1;
    }

}
