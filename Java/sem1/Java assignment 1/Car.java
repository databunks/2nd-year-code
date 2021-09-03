public class Car
{
  private String carName;
  private double distance;
  private double totalKm;
  private int fuelLevel;
  private double distPerLitre;

  //Reference object(s)
  private Engine refEngine;
  
  //Constructor(s)
  public Car(String name)
  {
    distance = 0;
    totalKm = 0;
    fuelLevel = 0;
    carName = name;
  }


  //Getters

  public void printState()
  {
    System.out.println("Car configuration : " + getCarName());
    System.out.println("Engine name : " + refEngine.getEngineName());
    System.out.println("Wheel name : " + refEngine.getNameOfWheel());
    System.out.println("Wheel circumference : " + refEngine.getCircumference());
    System.out.println("Distance travelled this drive : " + getCarDistance());  
    System.out.println("Total distance travelled : " + totalKm);
    System.out.println("Total number of engine turn count: " + refEngine.getTotalNumTurns());
  }

  public int getFuelLevel()
  {
    return fuelLevel;
  }

  public double getCarDistance()
  {
    return distance;
  }

  public double getTotalCarDistance()
  {
    return totalKm;
  }

  public String getCarName()
  {
    return carName;
  }

  public double getDistancePerLitre()
  {
    return distPerLitre;
  }

  public double getTotalKm()
  {
    return totalKm;
  }


  //Setters
  public void addTotalKm(double var)
  {
    totalKm += var;
  }

  public void addFuel(int fuel)
  {
    fuelLevel += fuel;
  }

  public void setFuel(int fuel)
  {
    fuelLevel = fuel;
  }

  public void add(Engine engine)
  {
    refEngine = engine;
  }

  public void add(Wheel wheel)
  {
    refEngine.addWheel(wheel);
  }

  public void setDistance(double dist)
  {
    distance = dist;
  }

  public void setDistancePerLitre(double dpl)
  {
    distPerLitre = dpl;
  }

  //This function assumes all fuel is used in one go
  public void drive()
  {
    if (fuelLevel <= 0)
    {
      System.out.println("Car has no fuel bro please add more");
    }
  else
   {
    refEngine.incrementTotalNumTurns(fuelLevel * refEngine.getTPL()); 
    setDistancePerLitre(refEngine.getCircumference() * refEngine.getTPL());
    setDistance(getDistancePerLitre()*getFuelLevel());
    addTotalKm(getCarDistance()); 
    setFuel(0);
   }
  }


}