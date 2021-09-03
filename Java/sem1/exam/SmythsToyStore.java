import java.util.ArrayList;

public class SmythsToyStore 
{

    public static void main (String[] args) 
    {
        ArrayList<Console> consoles = new ArrayList<Console>();
        double totalPrice = 0;
        int totalXbox = 0;
        int totalPlayStation = 0;
        int totalSwitch = 0;

        PlayStation playStation = new PlayStation();
        playStation.setName("Playstation");
        playStation.setDescription("Very good playstation");
        playStation.setEdition("3rd Edition");
        playStation.setGeneration("4th edition");
        playStation.setHasHardDiskDrive(true);
        playStation.setColour("White");
        playStation.setIsAvaliable(true);
        playStation.setNumber(4);
        playStation.setPrice(400);

        Xbox xbox = new Xbox();
        xbox.setName("Xbox");
        xbox.setDescription("Very good Xbox");
        xbox.setGeneration("4th edition");
        xbox.setHasHardDiskDrive(true);
        xbox.setColour("Black");
        xbox.setIsAvaliable(false);
        xbox.setSeries("Series X");
        xbox.setPrice(500);

        Switch nintendoSwitch = new Switch();
        nintendoSwitch.setName("Nintendo switch");
        nintendoSwitch.setDescription("Very good switch"); 
        nintendoSwitch.setColour("Red");
        nintendoSwitch.setIsAvaliable(true); 
        nintendoSwitch.setPrice(290.20);
        nintendoSwitch.setBatteryLifeHours(10);
        nintendoSwitch.setWeight(24.20);
        nintendoSwitch.setModel("E-66123");

        for (int i = 0; i < 50; i++)
        {
            consoles.add(nintendoSwitch);
        }

        for (int i = 0; i < 50; i++)
        {
            consoles.add(xbox);
        }

        for (int i = 0; i < 50; i++)
        {
            consoles.add(playStation);
        }
        

        for (int i = 0; i < consoles.size(); i++)
        {
            if (consoles.get(i).getIsAvaliable())
            {
                totalPrice += consoles.get(i).getPrice();
            }

            if (consoles.get(i) instanceof PlayStation)
            {
                totalPlayStation++;
            }

            if (consoles.get(i) instanceof Xbox)
            {
                totalXbox++;
            }

            if (consoles.get(i) instanceof Switch )
            {
                totalSwitch++;
            }
            
        }

        System.out.println("----------------Xbox----------------");
        System.out.println(xbox);
        System.out.println("Total xboxes : " + totalXbox);
        System.out.println("------------------------------------");

        System.out.println("----------------Playstation----------------");
        System.out.println(playStation);
        System.out.println("Total playStations" + totalPlayStation);
        System.out.println("-------------------------------------------");

        System.out.println("----------------Switch----------------");
        System.out.println(nintendoSwitch);
        System.out.println("Total Switches : " + totalSwitch);
        System.out.println("-------------------------------------------");

        System.out.println("Total price : " + totalPrice);

    }
    
}
