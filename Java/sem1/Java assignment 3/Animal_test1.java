public class Animal_test1 
{
    static Animal[] animals = new Animal[4];
  

    public static void main(String[] args)
    {
        animals[0] = new Canary("Richard" , "Yellow"); // Name || Colour
        animals[1] = new Shark("Jeffery","Black + White" , true,true); // Name || Colour || canBite || isDangerous
        animals[2] = new Ostrich("Steven", "Pink" , true, true); // Name || Colour || isTall || hasThinLongLegs
        animals[3] = new Trout("Hugh mungus","Orange", 'm'); // Name || Colour || Gender

        Canary canaryObjRef1 = (Canary)animals[0];  // We are just creating object references for the animals and also typecasting them so we have access to their methods, feel free to add as many as you like they are numbered in case of duplicates
        Shark sharkObjRef1 = (Shark)animals[1];
        Ostrich ostrichObjRef1 = (Ostrich)animals[2];
        Trout troutObjRef1 = (Trout)animals[3];
        
        printAnimals(); // We print out all the animals and their attributes associated with them

        System.out.println("");
        ostrichObjRef1.setName("Jimbo"); //We are just checking if setting the name has any affect on the print method, there are multiple set methods but we are just choosing this for example
        System.out.println("Ostrich name has been set to : " + ostrichObjRef1.getName());
        System.out.println("");

        sharkObjRef1.setCanBite(false);
        System.out.println("Sharks biting capability has been set to : " + sharkObjRef1.getCanBite());
        System.out.println("");

        troutObjRef1.setIsEdible(false);
        System.out.println("Trouts edibility has been set to : " + troutObjRef1.getIsEdible());
        System.out.println("");
        
        canaryObjRef1.setColour("Pink");
        System.out.println("Canary's colour has been set to : " + canaryObjRef1.getColour()); //As you can see from the above block of code we can easily modify the attributes of the objects and then retrieve data by using getter methods, there are many other getter/setter methods but for the sake of reducing redundancy ill leave them out
        System.out.println("");

        printAnimals(); // Seeing our changes made by the setter methods

        System.out.println("");
        System.out.println("Testing if ostrich can fly / move when it is called : ");
        animals[2].move(5);
        System.out.println("");
        System.out.println("Testing if Canary can fly / move when it is called : ");
        animals[0].move(10);
        System.out.println("");

        System.out.println("Testing to see if Canary can sing : ");
        canaryObjRef1.sing();
        System.out.println("");

        System.out.println("Testing to see if ostrich can sing : ");
        ostrichObjRef1.sing();
        System.out.println("");

        System.out.println("Testing to see if shark can swim : ");
        sharkObjRef1.move(3);
        System.out.println("");

        System.out.println("Testing to see if trout can swim : ");
        troutObjRef1.move(5);
        System.out.println("");

        System.out.println("Testing to see if shark can feed : ");
        sharkObjRef1.feed();
        System.out.println("");

    
    }
    
    public static void printAnimals()
    {
      for (int i = 0; i < animals.length; i++)
        {
            System.out.println(animals[i]);
        }
    }


}
