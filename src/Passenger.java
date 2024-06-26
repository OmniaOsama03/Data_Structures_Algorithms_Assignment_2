import java.util.*;
public class Passenger implements Traveler
{
    //Relevant attributes:
    private String id;
    private String name;
    private String ticketClass;
    private ArrayList<Luggage> luggages = new ArrayList<>();
    private String destination;
    private boolean specialNeeds;


    //Constructor:
    Passenger(String id, String name, String ticketClass, String destination, ArrayList<Luggage> luggages, boolean specialNeeds)
    {
        this.id = id;
        this.name = name;
        this.ticketClass = ticketClass;
        this.destination = destination;
        this.specialNeeds = specialNeeds;
        addLuggages(luggages);
    }

    Passenger(String id, String name, String ticketClass, String destination, boolean specialNeeds)
    {
        this.id = id;
        this.name = name;
        this.ticketClass = ticketClass;
        this.destination = destination;
        this.specialNeeds = specialNeeds;
    }

    //Setters
    public void setName(String name) {this.name = name;}
    public void setTicketClass(String ticketClass) {this.ticketClass = ticketClass;}
    public void setLuggages(ArrayList<Luggage> luggages) {addLuggages(luggages);}
    public void setDestination(String destination) {this.destination = destination;}
    public void setSpecialNeeds(boolean specialNeeds) {this.specialNeeds = specialNeeds;}

    //Getters:
    public String getId() {return id;}
    public String getName() {return name;}
    public String getTicketClass() {return ticketClass;}
    public ArrayList<Luggage> getLuggages() {return luggages;}
    public String getDestination() {return destination;}
    public boolean isSpecialNeeds() {return specialNeeds;}

    //Other necessary methods:
    public int LuggageCount()
    {
        return luggages.size();
    }

    public void addLuggages(ArrayList<Luggage> newLuggages) //Adds a set of luggages under a passenger's name.
    {
        if((LuggageCount() + newLuggages.size()) > 3 )
        {
            System.out.println("Request Failed - Can not add luggages. Maximum amount exceeded.");
        }
        else
        {
            for(Luggage luggage : newLuggages)
            {
                addLuggage(luggage);
            }
        }
    }

    public void addLuggage(Luggage newLuggage) //Checks for dimensional requirements, and adds luggage.
    {
        if(luggages.size() + 1 <= 3)
        {
            if (newLuggage.getLength() <= 90 && newLuggage.getWidth() <= 60 && newLuggage.getHeight() <= 40 && newLuggage.getWeight() <= 50)
            {
                luggages.add(newLuggage);
            } else
                System.out.println("Luggage " + newLuggage.getId() + " can not be added as it violates airline policies.");
        }
        else
            System.out.println("Luggage " + newLuggage.getId() + " cannot be added. Maximum luggage count reached.");

    }

    public int calculatePriorityScore() {
        int score = 0;

        if ("First-Class".equals(ticketClass)) {
            score = 3;
        } else if ("Business".equals(ticketClass)) {
            score = 2;
        } else if ("Economy".equals(ticketClass)) {
            score = 1;
        }

        if(specialNeeds == true)
            score++;

        return score;
    }

}
