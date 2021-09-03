
public class Animal_test2 
{
    static Animal[] animals = new Animal[5];
  

    public static void main(String[] args)
    {
        animals[0] = new Canary("Richard" , "Yellow");
        animals[1] = new Shark("Jeffery","Black + White" , true,true);
        animals[2] = new Ostrich("Steven", "Pink" , true, true);
        animals[3] = new Trout("Pointer","Orange", 'm');
        animals[4] = new Canary("Richard" , "Yellow");
        Canary canaryObjRef1 = (Canary)animals[0]; // Typecasting object so we can access its methods
        Canary canaryObjRef2 = (Canary)animals[4];
        Shark sharkObjRef1 = (Shark)animals[1];
        Ostrich ostrichObjRef1 = (Ostrich)animals[2];
        Trout troutObjRef1 = (Trout)animals[3];

        //Over here we try a number of scenarios to see how the equals method works
        
        //Comparing objects of the same class
        System.out.println("Comparing objects of : " + canaryObjRef1.getClass() + " and " +  canaryObjRef2.getClass() + ", Results in the equals value being " +  canaryObjRef1.equals(canaryObjRef2)); // Compares 2 objects of the same class to see if they are similar
        canaryObjRef1.setColour("Pink"); // Setting the colour so we can see if there is any difference

        //Just comparing different objects of different classes
        System.out.println("Comparing objects of : " + canaryObjRef1.getClass() + " and " +  canaryObjRef2.getClass() + ", Results in the equals value being " +  canaryObjRef1.equals(canaryObjRef2)); // Compares 2 objects again note they are of the same class
        System.out.println("Comparing objects of : " + sharkObjRef1.getClass() + " and " + ostrichObjRef1.getClass() + ", Results in the equals value being " + sharkObjRef1.equals(ostrichObjRef1));
        System.out.println("Comparing objects of : " + sharkObjRef1.getClass() + " and " + troutObjRef1.getClass() + ", Results in the equals value being " + sharkObjRef1.equals(troutObjRef1));
        System.out.println("Comparing objects of : " + ostrichObjRef1.getClass() + " and " + troutObjRef1.getClass() + ", Results in the equals value being " + troutObjRef1.equals(ostrichObjRef1));

        //Comparing an object to itself
        System.out.println("Comparing objects of : " + ostrichObjRef1.getClass() + " and " + ostrichObjRef1.getClass() + ", Results in the equals value being " + ostrichObjRef1.equals(ostrichObjRef1));
        
    }  
}
