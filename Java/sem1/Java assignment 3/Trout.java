public class Trout extends Fish 
{
    String name;
    boolean hasSpikes;
    boolean isEdible;
    boolean swimsUpToLayEggs;
    char troutGender;

    Trout(String troutName,String troutColour, char gender)
    {
        super();
        hasSpikes = true;
        isEdible = true;
        canSwim = true;
        name = troutName;
        colour = troutColour;
        troutGender = gender;
       
        //Swim up to lay eggs is gender dependant

        if (troutGender == 'M' || troutGender == 'm')
         {
           swimsUpToLayEggs = false;
         }
        else if (troutGender == 'F' || troutGender == 'f')
         {
           swimsUpToLayEggs = true;
         }
        else
        {
          System.out.println("Invalid input try M or F");
        }
    }

    //Getters

    public String getName()
    {
       return name;
    }
 

    public char getTroutGender()
    {
      return troutGender;
    }

    public boolean getHasSpikes()
    {
      return hasSpikes;  
    }

    public boolean getIsEdible()
    {
      return isEdible;  
    }

    public boolean getCanSwim()
    {
      return canSwim;  
    }

    @Override
    public String toString(){
      String strng ="";
      strng+= "Trout; ";
      strng+= "Name: ";
      strng+= name;
      strng+= "; ";
      strng+= "colour: ";
      strng+= colour + ";";
      strng+= " Gender: ";
      if (troutGender == 'm' || troutGender == 'M')
       {
         strng += "Male";
       }
      else if (troutGender == 'f' || troutGender == 'F')
       {
         strng+= "Female";
       } 
      strng+= "; ";
      strng+="Swims upstream to lay eggs : ";
      if (troutGender == 'm' || troutGender == 'M')
       {
         strng+= "Cannot lay eggs";
       }
      else if (troutGender == 'f' || troutGender == 'F')
       {
         strng+= "Can lay eggs";
       } 
      strng+= "; ";
      strng+= "Has spikes : ";
      if (hasSpikes == true)
         {
           strng+= "It has spikes";
         }
      else
      {
        strng+="It does not have spikes";
      }
      strng+= "; ";
      strng+= " Is edible ? : ";
      if (isEdible == true)
        {
          strng+="It is edible";
        }
      else
      {
        strng+="It is not edible";
      }
      strng+="; ";
     
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

        strng+= "Does it have gills? : ";

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
      
      if (obj instanceof Trout)
        {
            Trout objRef = (Trout)obj;
            if (name == objRef.name && colour == objRef.colour && hasSpikes == objRef.hasSpikes && swimsUpToLayEggs == objRef.swimsUpToLayEggs && isEdible == objRef.isEdible && troutGender == objRef.troutGender && hasFins == objRef.hasFins && hasGills == objRef.hasGills && canSwim == objRef.canSwim && hasSkin == objRef.hasSkin && breathes == objRef.breathes )
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


   public void setSwimsUpToLayEggs(boolean troutSwimsUpToLayEggs)
    {
        swimsUpToLayEggs = troutSwimsUpToLayEggs;
    }

    public void setName(String animalName)
    {
        name = animalName;
    }

   public void setIsEdible(boolean troutIsEdbile)
   {
     isEdible = troutIsEdbile;
   }
   
   public void setHasSpikes(boolean troutHasSpikes)
   {
     hasSpikes = troutHasSpikes;
   }

  
  

}
