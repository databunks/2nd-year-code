import java.util.ArrayList;
public abstract class BusVendors 
{
    String startingLocation;
    String destination;
    double fare;
    int numberOfPassengers;
    Date dateOfDeparture = new Date();
    Time timeOfDeparture = new Time();
    Date dateOfArrival = new Date();
    Time timeOfArrival = new Time();

    static ArrayList<BusVendors> trips = new ArrayList<BusVendors>();
    static int numberOfTrips = 0;
    private String tripDetails;

    public void addTrip()
    {
      trips.add(this);
      numberOfTrips++;
    }

    public int getNumberOfTrips()
    {
      return numberOfTrips;
    }

    public BusVendors getCurrentTrip(int index)
    {
      return trips.get(index);
    }

    @Override
    public String toString()
    {
        tripDetails += "----------------------------------------------------------------";
        tripDetails = "\nVendor : " + this.getClass().getName() + "\n";
        tripDetails += "\nStarting location : \n";
        tripDetails += startingLocation + "\n\n";
        tripDetails += "Destination : \n";
        tripDetails += destination + "\n\n";
        tripDetails += "Fare : \n";
        tripDetails += fare + "\n\n";
        tripDetails += "Number of passengers : \n";
        tripDetails += numberOfPassengers + "\n\n";
        tripDetails += "Date of departure : \n";
        if (dateOfDeparture.getDay() < 10) tripDetails += "0";
        tripDetails +=  dateOfDeparture.getDay() + "/";
        if (dateOfDeparture.getMonth() < 10) tripDetails += "0";
        tripDetails += dateOfDeparture.getMonth() + "/" + dateOfDeparture.getYear() + "\n\n";
        tripDetails += "Time of departure : \n";
        if (timeOfDeparture.getHour() < 10) tripDetails += "0";
        tripDetails += timeOfDeparture.getHour() + ":";
        if (timeOfDeparture.getMinutes() < 10) tripDetails += "0";
        tripDetails += timeOfDeparture.getMinutes() + " " + timeOfDeparture.getAmPm() + "\n\n";
        tripDetails += "Date of arrival : \n";
        if (dateOfArrival.getDay() < 10) tripDetails += "0"; 
        tripDetails += dateOfArrival.getDay() + "/";
        if(dateOfArrival.getMonth() < 10) tripDetails += "0";
        tripDetails += dateOfArrival.getMonth() + "/" + dateOfArrival.getYear() + "\n\n";
        tripDetails += "Time of arrival : \n";
        if (timeOfArrival.getHour() < 10 ) tripDetails += "0";
        tripDetails += timeOfArrival.getHour() + ":";
        if (timeOfArrival.getMinutes() < 10) tripDetails += "0";
        tripDetails += timeOfArrival.getMinutes() + " " + timeOfArrival.getAmPm() + "\n";
        tripDetails += "----------------------------------------------------------------";

        return tripDetails;
    }


    public void bookTrip(Booking booking)
    {
          

          if (numberOfPassengers > booking.getPassengers() && booking.getFare() >= (fare * booking.getPassengers()) && startingLocation == booking.getStartLocation() && destination == booking.getEndDestination())
          {
            fare = fare * booking.getPassengers();
            numberOfPassengers -= booking.getPassengers();
            System.out.println("----------------------------------------------------");
            System.out.println("Booking successful, Trip details: \n");
            System.out.println("Trip Id : " + booking.getStartLocation() + "\n");
            System.out.println("Starting Location : " + booking.getStartLocation());
            System.out.println("End Destination : " + booking.getEndDestination());
            System.out.println("Fare : " + fare);
            System.out.println("Amount paid : " + booking.getFare() + "\n");
            System.out.println("Number of passengers for this journey : " + booking.getPassengers());
            if (booking.getFare() > fare) System.out.printf("Extra amount paid sum of %.2f will be refunded to your account" ,booking.getFare() - fare);
            System.out.println("\n----------------------------------------------------");                    

          }
          else if (numberOfPassengers < booking.getPassengers())
          {
              System.out.println("-------------------------------");
              System.out.println("Booking failed not Enough seats");
              System.out.println("-------------------------------");
          }
          else if (fare * booking.getPassengers() > booking.getFare())
          {
              System.out.println("-------------------------------------------------");
              System.out.println("Booking failed not Enough money provided for fare");
              System.out.println("-------------------------------------------------");   
          }
          else if (startingLocation != booking.getStartLocation() || destination != booking.getEndDestination())
          {
              System.out.println("-------------------------------------------------------------------------------------------");
              System.out.println("Booking failed, Route does not exist or Wrong start location / destination (Case sensitive)");
              System.out.println("-------------------------------------------------------------------------------------------");
          }
          else
          {
              System.out.println("----------------------------");
              System.out.println("Booking failed unknown error");
              System.out.println("----------------------------");
          }
    }

    

   public void displayAllTrips()
   {
      for (int i = 0; i < numberOfTrips; i++)
      {
        System.out.println(trips.get(i));
      }
   }
   
}
