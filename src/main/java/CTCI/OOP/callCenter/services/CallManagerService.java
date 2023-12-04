package CTCI.OOP.callCenter.services;

import CTCI.OOP.callCenter.models.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CallManagerService {

    //designation: employeelist
    List<Respondent> availableRespondent;
    List<Manager> availableManager;
    List<Director> availableDirector;

    public CallManagerService() {
        availableDirector = new LinkedList<>();
        availableManager = new LinkedList<>();
        availableRespondent = new LinkedList<>();
    }

    public Employee dispatchCall(Call call){

        for(Respondent r: availableRespondent){
            if( r.isAbleToTakeCall(call) ) {
                r.setBusy(true);

                return r;
            }
        }

        for(Manager m: availableManager){
            if( m.isAbleToTakeCall(call) ){
                m.setBusy(true);

                return m;
            }
        }

        for(Director d: availableDirector){
            if( d.isAbleToTakeCall(call) ){
                d.setBusy(true);

                return d;
            }
        }

        return null;
    }


    public void addRespondent(Respondent respondent){
        availableRespondent.add(respondent);
    }

    public void removeAvailableRespondent(Respondent respondent){
        availableRespondent.remove(respondent);
    }

    public void addManager(Manager manager){
        availableManager.add(manager);
    }

    public void removeAvailableManager(Manager manager){
        availableManager.remove(manager);
    }

    public void addDirector(Director director){
        availableDirector.add(director);
    }

    public void removeAvailableDirector(Director director){
        availableDirector.remove(director);
    }

}
