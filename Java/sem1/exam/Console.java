public abstract class Console
{
   String name;
   String description;
   String colour;
   double price;
   boolean isAvaliable;

   public Console()
   {
     
   }

   public void setName(String name)
   {
       this.name = name;
   }

   public void setDescription(String description)
   {
       this.description = description;
   }

   public void setColour(String colour)
   {
       this.colour = colour;
   }

   public void setPrice(double price)
   {
       this.price = price;
   }

   public void setIsAvaliable(boolean isAvaliable)
   {
       this.isAvaliable = isAvaliable;
   }

   public String getName()
   {
       return name;
   }

   public String getDescription()
   {
       return description;
   }

   public String getColour()
   {
       return colour;
   }

   public double getPrice()
   {
       return price;
   }

   public boolean getIsAvaliable()
   {
       return isAvaliable;
   }

    
    
}