//Omnia Osama Ahmed - 1084505
public class PriorityService_51_G2 extends Service_51_G2
{
    //Relevant Attribute:
    private int priorityScore;

    //Constructor:
    PriorityService_51_G2(String passengerId, int priorityScore)
    {
        super(passengerId);
        this.priorityScore = priorityScore;
    }

    // Necessary setters:
    public void setPriorityScore(int priorityScore) {
        this.priorityScore = priorityScore;
    }

    //Getters:
    public int getPriorityScore() {
        return priorityScore;
    }

    //Method:
    @Override
    public void provideService()
    {
        System.out.println("Providing passenger " + super.getPassengerId() + " privileges over other passengers.");
    }


}
