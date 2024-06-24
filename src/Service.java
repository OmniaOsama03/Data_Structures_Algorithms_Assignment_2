public abstract class Service
{
    //Common Attribute:
    private String passengerId;

    //Constructor:
    public Service(String passengerId) {
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
