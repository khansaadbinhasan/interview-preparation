package CTCI.OOP.callCenter.models;

public class Employee {

    public static final String DESIGNATION_RESPONDENT = "DESIGNATION_RESPONDENT";
    public static final String DESIGNATION_MANAGER = "DESIGNATION_MANAGER";
    public static final String DESIGNATION_DIRECTOR = "DESIGNATION_DIRECTOR";

    protected String name;
    protected int empId;
    protected String designation;

    public Employee(String name, int empId, String designation) {
        this.name = name;
        this.empId = empId;
        this.designation = designation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", empId=" + empId +
                ", designation='" + designation + '\'' +
                '}';
    }
}
