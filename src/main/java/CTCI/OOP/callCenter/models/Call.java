package CTCI.OOP.callCenter.models;

public class Call {

    private String incomingNumber;
    private String query;
    private boolean isCallComplete;
    private boolean isQueryResolved;
    private Employee currentCallTaker;

    public Call(String incomingNumber, String query) {
        this.incomingNumber = incomingNumber;
        this.query = query;
    }

    public String getIncomingNumber() {
        return incomingNumber;
    }

    public void setIncomingNumber(String incomingNumber) {
        this.incomingNumber = incomingNumber;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "Call{" +
                "incomingNumber='" + incomingNumber + '\'' +
                ", query='" + query + '\'' +
                '}';
    }
}
