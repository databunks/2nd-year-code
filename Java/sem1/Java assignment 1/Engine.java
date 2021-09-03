public class Engine 
{

    private String engineName;
    private int tpl;
    private int totalNumTurns;
    
    //Reference object(s)
    private Wheel refWheel;

    public Engine(String name , int turnsPerLitre)
    {
        totalNumTurns = 0;
        engineName = name;
        tpl = turnsPerLitre;
    }

    //Getters
    public double getCircumference()
    {
        return refWheel.getWheelCircumference();
    }

    public String getNameOfWheel()
    {
        return refWheel.getWheelName();
    }

    public int getTPL()
    {
      return tpl;
    }

    public String getEngineName()
    {
        return engineName;
    }

    public int getTotalNumTurns()
    {
      return totalNumTurns;
    }

    //Setters

    public void incrementTotalNumTurns(int turns)
    {
        totalNumTurns += turns;
    }

    public void addWheel(Wheel wheel)
    {
        refWheel = wheel;
    }
}
