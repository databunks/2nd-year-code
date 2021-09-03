public class PlayStation extends Tower_Console
{
    String edition;
    int number;
    
    public PlayStation()
    {
        super();
    }

    public String getEdition()
    {
        return edition;
    }

    public int getNumber()
    {
        return number;
    }

    public void setEdition(String edition)
    {
        this.edition = edition;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    @Override
    public String toString()
    {
        String playStationString = "";
        playStationString += "Name : ";
        playStationString += name + "\n";
        playStationString +="Description : " + description + "\n";
        playStationString += "Colour : " + colour +  "\n";
        playStationString += "Price : " + price + "\n";
        playStationString += "Is avaliable : " + isAvaliable + "\n";
        playStationString += "Edition : " + edition + "\n";
        playStationString += "Number : " + number;
        return playStationString;
    }
}
