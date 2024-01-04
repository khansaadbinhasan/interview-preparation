package CTCI.ch7OOP.callCenter.front;

import CTCI.ch7OOP.callCenter.services.CallManagerService;
import CTCI.ch7OOP.callCenter.models.*;

public class CallCenter {

    public static void main(String[] args) {
        new CallCenter().run();
    }

    public void run(){

        //make employees
        //make a call
        //call taker

        Respondent r = new Respondent("Responder", 1, false);
        Manager m = new Manager("Manager", 2, true);
        Director d = new Director("Director", 3, false);

        Call c = new Call("98988979", "a");

        CallManagerService callManagerService = new CallManagerService();

        callManagerService.addRespondent(r);
        callManagerService.addManager(m);
        callManagerService.addDirector(d);

        Employee employee = callManagerService.dispatchCall(c);

        System.out.println(employee);

//        System.out.println(employee.getDesignation());

    }

}
