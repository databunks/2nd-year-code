public class TestCar 
{
    public static void main(String[] args)
    {
        //Configure your car here make it as slick as you want you can customize its attributes
        Car car = new Car("ferrari");
        Engine engine = new Engine("superfast" , 5);
        if (engine.getTPL() < 0){System.out.println("I have yet to see a car with negative turns per litre, wipe your glasses and enter a valid value");}      
     else 
     {   Wheel wheel = new Wheel("slick rims" , 4.5);
          if (wheel.getWheelRad() < 0) { System.out.println("I have yet to see a car with negative wheel radius, wipe your glasses and enter a valid value");}
          else
       { 
          car.add(engine);
          car.add(wheel);
        
        //Add how much fuel you want, Note : car will use it all up in one go
        car.addFuel(13);
        System.out.println("Current fuel level : " + car.getFuelLevel());
        
        if (car.getFuelLevel() > 0)
         {
          //Car uses all fuel when drive is called so add more fuel if you want to drive more
          //Can check the status any time with printstate
          car.drive();
          car.printState();
          car.addFuel(10);
          System.out.println("                                                      ");
          System.out.println("Current fuel level : " + car.getFuelLevel());
          car.drive();
          car.printState(); 
          
         }
         else
          {
            System.out.println("You cant have negative fuel, Try again");
          }
       }
     }

    }    
}
