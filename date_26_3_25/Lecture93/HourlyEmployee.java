package date_26_3_25.Lecture93;

public class HourlyEmployee extends Employee {
    private double hourlyPayRate;

    HourlyEmployee(String name, String birthDate, String hireDate, double hourlyPayRate){
        super(name, birthDate, hireDate);
        this.hourlyPayRate = hourlyPayRate;
    }

    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + 
        "\nEmployee Type: Hourly" + 
        "\nHourly Pay Rate: " + getHourlyPayRate() + 
        (getEndDate() != null ? "\nEnd Date: " + getEndDate(): "") +
        "\n -------------";
    }

}
