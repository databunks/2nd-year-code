
public abstract class Animal
{
    boolean hasSkin;
    boolean breathes;
    String colour;

    /**
     * Constructor for objects of class Animal
     */
    public Animal()
    {
        breathes = true; //all the subclasses of Animal inherit this property and value
        hasSkin = true; // all the subclasses of Animal inherit this property and value
        colour = "grey"; //all the subclasses of Animal inherit this property and value
    }
    
    //Setters 
    public void setColour(String animalColour)
    {
      colour = animalColour;
    }

    public void setBreathes(boolean animalBreathes)
    {
        breathes = animalBreathes;
    }

    public void setHasSkin(boolean animalHasSkin)
    {
        hasSkin = animalHasSkin;
    }

    /**
     * move method
     * param int distance - the distance the Animal should move
     * All subclasses inherit this method
     */
    public void move(int distance)
    {
        System.out.printf("I move %d metres \n", distance);
    }


    //Getters

        
    /**
     * getter method for colour field
     * All subclasses inherit this method
     */
    public String getColour()
    {
        return colour;
    }


     /**
     * 'getter' method for haSkin field
     * All subclasses inherit this method
     */
    
    public boolean getHasSkin()
    {
        return hasSkin;
    }

    public boolean getBreathes()
    {
        return breathes;
    }


    
}
