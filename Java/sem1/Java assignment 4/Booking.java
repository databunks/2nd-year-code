public class Booking 
{
   
    private long tripId;
    private String startLocation;
    private String endDestination;
    private double fare;
    private int passengers;

    public Booking(long tripId, String startLocation, String endDesination, double fare, int passengers)
    {
       
        this.tripId = tripId;
        this.startLocation = startLocation;
        this.endDestination = endDesination;
        this.passengers = passengers;
        this.fare = fare * passengers;  
    }


    public long getTripId()
    {
        return tripId;
    }

    public String getStartLocation()
    {
        return startLocation;
    }

    public String getEndDestination()
    {
        return endDestination;
    }

    public double getFare()
    {
        return fare;
    }

    public int getPassengers()
    {
        return passengers;
    }
    
}
