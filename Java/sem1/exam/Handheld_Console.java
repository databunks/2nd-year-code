public abstract class Handheld_Console extends Console
{
    int batteryLifeHours;
    double weight;

    public Handheld_Console()
    {
        super();
    }

    public void setBatteryLifeHours(int batteryLifeHours)
    {
        this.batteryLifeHours = batteryLifeHours;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    public int getBatteryLifeHours()
    {
        return batteryLifeHours;
    }

    public double getWeight()
    {
        return weight;
    }
}