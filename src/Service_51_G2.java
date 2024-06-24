//Omnia Osama Ahmed - 1084505
public abstract class Service_51_G2
{
    //Common Attribute:
    private String passengerId;

    //Constructor:
    public Service_51_G2(String passengerId) {
        this.passengerId = passengerId;
    }

   //Setter & Getter:
    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }
    public String getPassengerId() {
        return passengerId;
    }

    //Common method:
    public abstract void provideService();
}
