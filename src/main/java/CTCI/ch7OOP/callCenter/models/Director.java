package CTCI.ch7OOP.callCenter.models;

import java.util.HashSet;
import java.util.Set;

public class Director extends Employee{

    private boolean isBusy;//busy/available
    private Set<String> resolvableQueries;

    public Director(String name, int empId, boolean isBusy) {
        super(name, empId, Employee.DESIGNATION_DIRECTOR);

        this.isBusy = isBusy;

        resolvableQueries = new HashSet<>();

        resolvableQueries.add("a");
        resolvableQueries.add("g");
        resolvableQueries.add("h");
        resolvableQueries.add("i");

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
