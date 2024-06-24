
import java.util.*;
public class AirlineCheckInSystem
{


    private Queue<Passenger> passengersQueue;
    private Stack<Luggage> luggageStack;
    private PriorityQueue<PriorityService> priorityServicesQueue;

    public static void main(String[] args)
    {
        AirlineCheckInSystem checkInSystem = new AirlineCheckInSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Airline Check-In System Menu:");
            System.out.println("1. Register Passenger");
            System.out.println("2. Enqueue Priority Passenger");
            System.out.println("3. Push Luggage");
            System.out.println("4. Dequeue Passenger");
            System.out.println("5. Pop Luggage");
            System.out.println("6. View Next Passenger");
            System.out.println("7. View Top Luggage");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {
                case 1: //Prompts user for necessary info, then creates a new Passenger object, added to the passengerQueue

                    //Passenger info:
                    System.out.println("Enter Passenger ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Enter Passenger Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Ticket Class (Economy, Business, First-Class): ");
                    String ticketClass = scanner.nextLine();

                    System.out.print("Does the passenger have special needs?");
                    boolean isSpecialNeeds = scanner.nextBoolean();
                    scanner.nextLine();

                    System.out.println("What is the passenger's destination?");
                    String destination = scanner.nextLine();

                    System.out.print("Enter Luggage Count: ");
                    int luggageCount = scanner.nextInt();
                    scanner.nextLine();  // Consume newline left-over

                    Passenger passenger = new Passenger(id, name, ticketClass, destination, isSpecialNeeds);


                    //Information for the luggage(s):
                    ArrayList<Luggage> newLuggages = new ArrayList<>();

                    if(luggageCount > 0)
                    {
                        for(int x = 0; x < luggageCount; x++)
                        {
                            System.out.println("Information for luggage number " + (x + 1));
                            System.out.println("Enter the id: ");
                            String lugID = scanner.nextLine();

                            System.out.println("Enter the weight: ");
                            double weight = scanner.nextDouble();

                            System.out.println("Enter the length");
                            double length = scanner.nextDouble();

                            System.out.println("Enter the width: ");
                            double width = scanner.nextDouble();

                            System.out.println("Enter the height: ");
                            double height = scanner.nextDouble();
                            scanner.nextLine();

                            Luggage luggage = new Luggage(lugID, id, weight, length, width, height);
                            passenger.addLuggage(luggage);
                        }
                    }
                    if(passenger.calculatePriorityScore() <= 1)
                        checkInSystem.enqueuePassenger(passenger);
                    else
                        checkInSystem.enqueuePriorityPassenger(passenger);

                    System.out.println("Passenger successfully added.");
                    break;

                case 2:
                    //Passenger info:
                    System.out.println("Enter Passenger ID: ");
                    String id2 = scanner.nextLine();

                    System.out.print("Enter Passenger Name: ");
                    String name2 = scanner.nextLine();

                    System.out.print("Enter Ticket Class (Economy, Business, First-Class): ");
                    String ticketClass2 = scanner.nextLine();

                    System.out.print("Does the passenger have special needs?");
                    boolean isSpecialNeeds2 = scanner.nextBoolean();
                    scanner.nextLine();

                    System.out.println("What is the passenger's destination?");
                    String destination2 = scanner.nextLine();

                    System.out.print("Enter Luggage Count: ");
                    int luggageCount2 = scanner.nextInt();
                    scanner.nextLine();  // Consume newline left-over

                    Passenger passenger2 = new Passenger(id2, name2, ticketClass2, destination2, isSpecialNeeds2);


                    //Information for the luggage(s):
                    ArrayList<Luggage> newLuggages2 = new ArrayList<>();

                    if(luggageCount2 > 0)
                    {
                        for(int x = 0; x < luggageCount2; x++)
                        {
                            System.out.println("Information for luggage number " + (x + 1));
                            System.out.println("Enter the id: ");
                            String lugID = scanner.nextLine();

                            System.out.println("Enter the weight: ");
                            double weight = scanner.nextDouble();

                            System.out.println("Enter the length");
                            double length = scanner.nextDouble();

                            System.out.println("Enter the width: ");
                            double width = scanner.nextDouble();

                            System.out.println("Enter the height: ");
                            double height = scanner.nextDouble();
                            scanner.nextLine();

                            Luggage luggage = new Luggage(lugID, id2, weight, length, width, height);
                            passenger2.addLuggage(luggage);
                        }
                    }

                        checkInSystem.enqueuePriorityPassenger(passenger2);
                    System.out.println("Priority Passenger successfully enqueued.");
                    break;


                case 3: //Prompts the user for info about luggage, and pushed luggage into top of stack.
                    System.out.print("Enter Passenger ID: ");
                    String passengerId = scanner.nextLine();

                    System.out.print("Enter Luggage ID: ");
                    String luggageId = scanner.nextLine();

                    System.out.print("Enter Luggage Weight (kg): ");
                    double luggageWeight = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline left-over

                    System.out.print("Enter luggage length: ");
                    double length = scanner.nextDouble();

                    System.out.println("Enter the luggage width: ");
                    double width = scanner.nextDouble();

                    System.out.println("Enter the luggage height: ");
                    double height = scanner.nextDouble();

                    Luggage luggage = new Luggage(luggageId, passengerId, luggageWeight, length, width, height);

                    checkInSystem.pushLuggage(luggage);
                    System.out.println("Luggage pushed successfully.");
                    break;


                case 4: //Checks if queue is empty, if not, Prints the ID of the dequeued passenger.
                    String dequeued = checkInSystem.dequeuePassenger();

                    if (dequeued != "" && dequeued != null) {
                        System.out.println("Passenger with ID " + dequeued + " got dequeued.");
                    } else {
                        System.out.println("No passengers to dequeue.");
                    }
                    break;


                case 5: //Checks if luggage stack is empty. If not, pops the luggage at the top.
                    Luggage top = checkInSystem.popLuggage(); //removes and returns top luggage
                    if (top != null) {
                        System.out.println("Luggage with ID " + top.getId() + " popped!");
                    } else {
                        System.out.println("No luggage to pop. :(");
                    }
                    break;


                case 6: //Uses .peek() to check for the next passenger in queue without removing
                    Passenger next = checkInSystem.getNextPassenger();

                    if (next != null) {
                        System.out.println("Next passenger's name: " + next.getName());
                    } else {
                        System.out.println("No passengers in the queue. :o");
                    }
                    break;


                case 7: //Checks if stack is empty, if not, removes top and prints ID.
                    Luggage topLug = checkInSystem.getTopLuggage();

                    if (topLug != null) {
                        System.out.println("Top luggage: " + topLug.getId());
                    } else {
                        System.out.println("No luggage in the stack.");
                    }
                    break;


                case 8:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }//End of main

    // Constructor
    public AirlineCheckInSystem() {
        passengersQueue = new LinkedList<>();
        luggageStack = new Stack<>();
        priorityServicesQueue = new PriorityQueue<>(new ScoreComparator());
    }


    // Methods:
    public void enqueuePassenger(Passenger passenger) { //Adds a passenger to end of queue
        passengersQueue.offer(passenger);
    }

    public void enqueuePriorityPassenger(Passenger passenger) { //Adds a passenger to the priority queue in order.
        priorityServicesQueue.offer(new PriorityService(passenger.getId(), passenger.calculatePriorityScore()));
    }

    public void pushLuggage(Luggage luggage) { //Adds luggage to the top of the stack
        luggageStack.push(luggage);
    } //Adds luggage to top of stack.

    public String dequeuePassenger() { //Returns passenger with the highest priority. Else, returns passenger from normal Queue. Else, returns nothing.
        String passenger = "";

        if (priorityServicesQueue.poll() == null) {
            if(passengersQueue.poll() == null)
                System.out.println("The queue is empty!");
            else
             passenger = passengersQueue.poll().getId();
        }
        else if(priorityServicesQueue.poll() != null)
            passenger = priorityServicesQueue.poll().getPassengerId();

        return passenger;
    }

    public Luggage popLuggage() { //Removes and returns the luggage at the top of the stack.
        return luggageStack.pop();
    } //Removes and return top luggage in stack.

    public Passenger getNextPassenger() { //Returns copy of passenger next in queue, but doesn't remove them.
        return passengersQueue.peek();
    }

    public Luggage getTopLuggage() { //Returns copy of luggage at top of stack. If stack is empty, returns null.
        return luggageStack.isEmpty() ? null : luggageStack.peek();
    }
    //^ If queue is empty, returns null, otherwise, returns copy of top element.

}
