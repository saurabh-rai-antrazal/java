package date_26_3_25.Lecture93;

public class Employee extends Worker{
    private long employeeId;
    private String hireDate;

    private static long employeeNum = 1;

    Employee(String name, String birthDate, String hireDate){
        super(name, hireDate);
        this.hireDate = hireDate;
        this.employeeId = Employee.employeeNum++; 
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public String getHireDate() {
        return hireDate;
    }
    
    @Override
    public String toString(){
        return "Employee ID: " + getEmployeeId() +
        super.toString() + 
        "\nHire Date: " + getHireDate();
    }

    
}
