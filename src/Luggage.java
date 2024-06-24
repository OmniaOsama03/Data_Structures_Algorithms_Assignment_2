public class Luggage
{
    //Relevant attributes:
    private String id;
    private String passengerId;
    private double weight;
    private double length;
    private double width;
    private double height;

    //Constructor:
    Luggage(String ID, String passengerId, double weight, double length, double width, double height)
    {
        this.id = ID;
        this.passengerId = passengerId;
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    //Setters
    public void setId(String id) {
        this.id = id;
    }
    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void setLength(double length) {
        this.length = length;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    //Getters:

    public String getId() {
        return id;
    }
    public String getPassengerId() {
        return passengerId;
    }
    public double getHeight() {
        return height;
    }
    public double getLength() {
        return length;
    }
    public double getWidth() {
        return width;
    }
    public double getWeight() {
        return weight;
    }


}
