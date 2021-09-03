public class Status 
{
    Console consoleRef;
    
    public double getPrice()
    {
       return consoleRef.getPrice();
    }

    public boolean isAvaliable()
    {
        return consoleRef.getIsAvaliable();
    }
}
