public abstract class Fish extends Animal
{
   boolean hasFins;
   boolean canSwim;
   boolean hasGills;

   public Fish()
   {
     super();
     hasFins = true;
     canSwim = true;
     hasGills = true;
     colour = "Black";

   }

   //Swim ability for fishes
   @Override
   public void move(int distance)
   {
     if (canSwim == true)
     {
      System.out.printf("Swimming for %d meters" ,distance);
     }
     else
     {
       System.out.println("I cant swim for some reason :/");
     }
   }

  //Getters

   public boolean getHasFins()
   {
     return hasFins;
   }

   public boolean getHasGills()
   {
     return hasGills;
   }

   public boolean getCanSwim()
   {
     return canSwim;
   }
  //Setters
  

  public void setHasFins(boolean fishHasGills)
  {
    hasGills = fishHasGills;
  }

  public void setCanSwim(boolean fishCanSwim)
  {
    canSwim = fishCanSwim;
  }

  public void setHasGills(boolean gills)
  {
    hasGills = gills;
  }

}
