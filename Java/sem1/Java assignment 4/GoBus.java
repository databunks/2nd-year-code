public class GoBus extends BusVendors
{ 

    public GoBus(String startingLocation, String destination, double fare, int numberOfPassengers,Date dateOfDeparture, Time timeOfDeparture, Date dateOfArrival, Time timeOfArrival)
    {
        this.startingLocation = startingLocation;
        this.destination = destination;
        this.fare = fare;
        this.numberOfPassengers = numberOfPassengers;
        this.dateOfDeparture = dateOfDeparture;
        this.timeOfDeparture = timeOfDeparture;
        this.timeOfArrival = timeOfArrival; 
        this.dateOfArrival = dateOfArrival;
        this.addTrip();
    }

}
