package date_26_3_25.Lecture93;

public class SalariedEmployee extends Employee{
    private double anualSalary;
    private boolean isRetired = false;

    SalariedEmployee(String name, String birthDate, String hireDate, double anualSalary){
        super(name, birthDate, hireDate);
        this.anualSalary = anualSalary;
    }

    public double getAnualSalary() {
        return anualSalary;
    }

    public boolean isRetired() {
        return isRetired;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() +
        "\nEmployee Type: Salaried" + 
        "\nAnnual Salary: " + getAnualSalary()+
        (getEndDate() != null ? "\nEnd Date: " + getEndDate(): "") + 
        "\n -------------";
    }
}
