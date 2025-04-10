package date_26_3_25.Lecture93;

public class Worker {
    private String name;
    private String birthDate;
    protected String endDate;

    Worker(String name, String birtDate){
        this.name = name;
        this.birthDate = birtDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public double collectPay(){
        return 0.0D;
    }

    public void terminate(String endDate){
        this.endDate = endDate;
    }

    @Override
    public String toString(){
        return "\nEmployee Name :" + getName() ;
    }

    public void getDetails(Worker worker){
        System.out.println(worker.toString());
    }
}
