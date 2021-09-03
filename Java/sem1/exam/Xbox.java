public class Xbox extends Tower_Console
{
    String series;


    public Xbox()
    {
        super();
    }

    public String getSeries()
    {
        return series;
    }

    public void setSeries(String series)
    {
        this.series = series;
    }

    @Override
    public String toString()
    {
        String xboxString = "";
        xboxString += "Name : ";
        xboxString += name + "\n";
        xboxString +="Description : " + description + "\n";
        xboxString += "Colour : " + colour +  "\n";
        xboxString += "Price : " + price + "\n";
        xboxString += "Is avaliable : " + isAvaliable + "\n";
        xboxString += "Series : " + series;
        return xboxString;
    }
    
}
