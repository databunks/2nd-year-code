
public class Canary extends Bird
{
    
    String name; // the name of this Canary

    /**
     * Constructor for objects of class Canary
     */
    public Canary(String name , String canaryColour)
    {
        super(); // call the constructor of the superclass Bird
        this.name = name;
        colour = canaryColour; // this overrides the value inherited from Bird    
        flies = true;
    }

    //Getters

    public String getName()
    {
       return name;
    }

    //Setters
    public void setName(String animalName)
    {
        name = animalName;
    }


    /**
     * Sing method overrides the sing method
     * inherited from superclass Bird
     */
    @Override // good programming practice to use @Override to denote overridden methods
    public void sing()
    {
        System.out.println("tweet tweet tweet");
    }
    
    /**
     * toString method returns a String representation of the bird
     * What superclass has Canary inherited this method from? 
     */
    @Override
    public String toString(){
        String strng ="";
        strng+= "Canary; ";
        strng+= "Name: ";
        strng+= name;
        strng+= "; ";
        strng+= "colour: ";
        strng+= colour;
        strng+= "; ";
        strng+= "Can it fly : ";
        if (flies == true)
        {
            strng+= "It flies";
        }
        else
        {
            strng+= "It does not fly";
        }
        strng+= "; ";
        strng+="Does it have feathers? : ";

        if(hasFeathers == true)
         {
             strng+="It has feathers";
         }
        else
        {
            strng+="It has no feathers";
        }
        strng+="; ";
        strng+="Does it have wings? : ";

        if(hasWings == true)
        {
            strng+= "It does have wings";
        }
        else
        {
            strng+="Does not have wings";
        }
        strng+=";";

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

    
    /**
     * equals method defines how equality is defined between 
     * the instances of the Canary class
     * param Object
     * return true or false depending on whether the input object is 
     * equal to this Canary object
     */
    
    @Override
    public boolean equals(Object obj)
    {
        
        if (obj instanceof Canary)
          {
              Canary objRef = (Canary)obj;
              if (name == objRef.name && colour == objRef.colour && flies == objRef.flies && hasWings == objRef.hasWings && hasFeathers  == objRef.hasFeathers && hasSkin == objRef.hasSkin && breathes == objRef.breathes)
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
}
