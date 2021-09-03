public class Interface
{
     public Interface()
     {
     }

    public static void main(String[] args)
    {
      Date departureDate = new Date();
      Time departureTime = new Time();
      Date arrivalDate = new Date();
      Time arrivalTime = new Time();

      Booking book1 = new Booking(12931923, "Cork", "Limerick", 11, 2);
      Booking book2 = new Booking(13343434, "Galway", "Dublin", 8, 5);
      Booking book3 = new Booking(13343434, "Belfast", "Dublin", 8, 5);
      Booking book4 = new Booking(12312334, "Galway", "Dublin", 14, 50);
      Booking book5 = new Booking(12343434, "Mars", "Pluto", 25, 3);

      departureDate.setDate(10, 12, 2020);
      departureTime.setTime(2,45,"P.M");
      arrivalTime.setTime(3,5,"P.M");
      arrivalDate.setDate(10,12,2020);

      BusEireann route1 = new BusEireann("Cork", "Limerick", 11, 30, arrivalDate, arrivalTime, arrivalDate, arrivalTime);
      
     

      departureDate.setDate(11, 12, 2020);
      departureTime.setTime(6,00,"A.M");
      arrivalTime.setTime(1,0,"P.M");
      arrivalDate.setDate(12,12,2020);

      CityLink route2 = new CityLink("Galway", "Dublin", 7, 36, arrivalDate, arrivalTime, arrivalDate, arrivalTime);
      
     

      departureDate.setDate(13, 12, 2020);
      departureTime.setTime(5,45,"A.M");
      arrivalTime.setTime(6,45,"A.M");
      arrivalDate.setDate(13,12,2020);

      CityLink route3 = new CityLink("Belfast", "Dublin", 14, 22, arrivalDate, arrivalTime, arrivalDate, arrivalTime);
      
      route1.bookTrip(book1);
      route2.bookTrip(book2);
      route3.bookTrip(book3);
      route3.bookTrip(book4);
      route3.bookTrip(book5);

      route3.displayAllTrips();
    }
}