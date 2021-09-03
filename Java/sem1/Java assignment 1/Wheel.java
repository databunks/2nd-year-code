public class Wheel {

    private double radius;
    private String wheelName;
    private double circumference;

    //Constructor
    public Wheel(String name , double rad)
    {
        wheelName = name;
        radius = rad;
        circumference = (Math.PI)*(radius)*(2);
    }
    //Getters

    public String getWheelName()
    {
        return wheelName;
    }

    public double getWheelRad()
    {
        return radius;
    }

    public double getWheelCircumference()
    {
        return circumference;
    }

    
   
    
}
