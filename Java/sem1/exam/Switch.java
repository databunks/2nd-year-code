public class Switch extends Handheld_Console
{
    String model;

    public Switch()
    {
        super();
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    @Override
    public String toString()
    {
        String switchString = "";
        switchString += "Name : ";
        switchString += name + "\n";
        switchString +="Description : " + description + "\n";
        switchString += "Colour : " + colour +  "\n";
        switchString += "Price : " + price + "\n";
        switchString += "Is avaliable : " + isAvaliable + "\n";
        switchString += "Model : " + model;
        return switchString;
    }
}
