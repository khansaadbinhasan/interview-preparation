package CTCI.OOP.callCenter.models;

import java.util.HashSet;
import java.util.Set;

public class Respondent extends Employee {
    private boolean isBusy;//busy/available
    private Set<String> resolvableQueries;

    public Respondent(String name, int empId, boolean isBusy) {
        super(name, empId, Employee.DESIGNATION_RESPONDENT);

        this.isBusy = isBusy;

        resolvableQueries = new HashSet<>();

        resolvableQueries.add("a");
        resolvableQueries.add("b");
        resolvableQueries.add("c");
    }

    public boolean isAbleToTakeCall(Call call){
        return !isBusy && resolvableQueries.contains(call.getQuery());
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }
}