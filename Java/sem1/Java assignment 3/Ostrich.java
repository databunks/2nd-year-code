public class Ostrich extends Bird
{
   String name;
   boolean isTall;
   boolean hasThinLongLegs;

   Ostrich(String ostrichName, String ostrichColour ,boolean tall, boolean thinLongLegs)
   {
       super();
       isTall = tall;
       flies = false;
       hasThinLongLegs = thinLongLegs;
       colour = ostrichColour;
       name = ostrichName;
   }
   
   //Getters

   public String getName()
   {
      return name;
   }

   public boolean getIsTall()
   {
      return isTall;
   }

   public boolean getHasThinLongLegs()
   {
      return hasThinLongLegs;
   }

   

   @Override
   public String toString(){
     String strng ="";
     strng+= "Ostrich; ";
     strng+= "Name: ";
     strng+= name;
     strng+= "; ";
     strng+= "colour: ";
     strng+= colour + ";";
     
     strng+= " Has long thin legs: ";
     if (hasThinLongLegs == true)
       {
          strng+= "it does have long thin legs";
       }
      else if(hasThinLongLegs == false)
       {
          strng += "Does not have thin long legs";
       }

       strng += ";";

      strng+= " Is it tall? : " ;
      
      if (isTall == true)
       {
         strng+= "It is tall";
       }
      else if (isTall == false)
        {
           strng+= "It is not tall";
        }
      
        strng+="Does it have wings? : ";

        if(hasWings == true)
        {
            strng+= "It does have wings";
        }
        else
        {
            strng+="Does not have wings";
        }
        strng+="; ";
        strng+="Does it fly? : ";

        if (flies == true)
        {
            strng+= "It flies";
        }
        else
        {
            strng+= "It does not fly";
        }

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

     strng += ";";
     strng+= "\n";
     // TOD0 Your job is to include the fields and attributes inherited 
     //from Bird and Animal in the String representation
     return strng;
      }

      @Override
      public boolean equals(Object obj)
      {
          
          if (obj instanceof Ostrich)
            {
                Ostrich objRef = (Ostrich)obj;
                if (name == objRef.name && colour == objRef.colour && hasThinLongLegs == objRef.hasThinLongLegs && isTall == objRef.isTall && flies == objRef.flies && hasWings == objRef.hasWings && hasFeathers  == objRef.hasFeathers && hasSkin == objRef.hasSkin && breathes == objRef.breathes)
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
      
   //setters

   public void setName(String animalName)
    {
        name = animalName;
    }

   public void setIsTall(boolean ostIsTall)
   {
      isTall = ostIsTall;
   }

   public void setHasThinLongLegs(boolean ostHasThinLongLegs)
   {
      hasThinLongLegs = ostHasThinLongLegs;
   }



}
