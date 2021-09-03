public class Shark extends Fish
{
    String name;
    boolean canBite;
    boolean isDangerous;

    Shark(String sharkName, String sharkColour, boolean bite, boolean dangerous)
    {
      super();
      canBite = bite;
      isDangerous = dangerous;
      colour = sharkColour;
      name = sharkName;
    }

    public void feed()
    {
        if (canBite == true)
        {
            System.out.println("MMMM!!!!! that was tasty :))");
        }
        else
        {
            System.out.println("Wish i could bite to feed :( ");
        }

    }

    //Getters

    public String getName()
    {
       return name;
    }
 

    public boolean getCanBite()
    {
        return canBite;
    }

    public boolean getIsDangerous()
    {
        return isDangerous;
    }


    @Override
    public String toString(){
        String strng ="";
        strng+= "Shark; ";
        strng+= "Name: ";
        strng+= name;
        strng+= "; ";
        strng+= "colour: ";
        strng+= colour + ";";
        strng+= " Dangerous? : ";
        if (isDangerous == true)
           {
               strng+= "Is dangerous";
           }
        else if (isDangerous == false)
            {
                strng+= "Is not dangerous";
            }
         strng+= ";";
         strng+= " Can it bite : ";
        if (canBite == true)
           {
               strng+= "Can bite";
           }
        else if (canBite == false)
            {
                strng+= "Cannot bite";
            }
        strng+= "; ";
        strng+= "Can it swim ? : ";
        if (canSwim == true)
        {
          strng+="It can swim";
        }
        else
        {
            strng+= "It cant swim";
        }
        strng+="; ";
        strng+="Does it have fins? : ";
        if(hasFins == true)
        {
            strng+= "Has fins";
        }
        else
        {
            strng+= "Does not have fins";
        }
        strng+="; ";

        strng+= "Does it have gills ? : ";

        if(hasGills == true)
        {
            strng+= "Has gills";
        }
        else
        {
          strng+= "Does not have gills";
        }

        strng+="; ";

        strng+="Does it have skin? : ";

        if (hasSkin == true)
        {
            strng+= "It has skin";
        }
        else
        {
            strng+= "It has no skin";
        }
        strng+= ";";

        strng+= "Does it breathe ? : ";

        if (breathes == true)
        {
            strng+= "It does breathe";
        }
        else
        {
            strng+= "It does not breathe";
        }
        
        strng+="; ";
        
        strng+= "\n";
        // TOD0 Your job is to include the fields and attributes inherited 
        //from Bird and Animal in the String representation
        return strng;
    }

    @Override
    public boolean equals(Object obj)
    {
        
        if (obj instanceof Shark)
          {
              Shark objRef = (Shark)obj;
              if (name == objRef.name && colour == objRef.colour && isDangerous == objRef.isDangerous && canBite == objRef.canBite && hasFins == objRef.hasFins && hasGills == objRef.hasGills && canSwim == objRef.canSwim && hasSkin == objRef.hasSkin && breathes == objRef.breathes)
              {
                  return true;
              }
              else
              {
                  return false;
              }
          }
        else
        {
            return false;
        }
    }
     
   //Setters

   public void setName(String animalName)
    {
        name = animalName;
    }


    public void setIsDangerous(boolean sharkIsDangerous)
    {
        isDangerous = sharkIsDangerous;
    }

    public void setCanBite (boolean sharkCanBite)
    {
        canBite = sharkCanBite;
    }

}