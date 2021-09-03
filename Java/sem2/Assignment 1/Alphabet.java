import java.util.Scanner; 
public class Alphabet
{
    static char alphabet[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'}; //Array is used by each of the 2 methods to save space
    static String inputChar, choice;                       // variable declarations under here until ^^
    static Scanner scanChar = new Scanner(System.in);      // Scanner takes in input from console
    static int i;                                     
    static long startTime, endTime, timeTaken;
    static String stringTime;                             //^^

    public static void forwards() //if user chooses forwards, this method is called
    {
        i = 0; //index counter is set to 0 (first place in alphabet array)
        System.out.println("Enter the first letter");
        startTime = System.currentTimeMillis(); // start time is recorded here to be later compared at the end
        while (i != alphabet.length) // loops until end of array
        {
            if (scanChar.hasNextLine()) inputChar = scanChar.nextLine(); // scanner takes in input
            else inputChar = null;
  
            if (inputChar.length() > 1) System.out.println("Must be a single letter"); //error checking for multiple char input
            else
            {
              if (alphabet[i] == inputChar.charAt(0)) // if it is correct
              {
                if (alphabet[i] != alphabet[alphabet.length - 1]) System.out.println("Correct!, next letter is : " + alphabet[i + 1]); // if statement protects against out of bounds error, next element in group is called
                i++; //increment index
              }
              else 
              {
                System.out.println("Incorrect letter try again"); 
              }
              
            }
            endTime = System.currentTimeMillis(); //end time is recorded when run is complete
        }
        
        timeTaken =  endTime - startTime; // Time taken is calculated
        stringTime = Long.toString(timeTaken); // Time taken is converted to string
        stringTime = stringTime.substring(0, stringTime.length() - 3) + "." + stringTime.substring(stringTime.length() - 3, stringTime.length()); // Decimal point is parsed into string converting it to seconds
        System.out.printf("You got it done in %s s", stringTime); // End timing result is displayed
    }

    public static void backwards() //if user chooses backwards, this method is called
    {
        startTime = System.currentTimeMillis(); //index counter is set to 25 (last place in alphabet array)
        i = alphabet.length - 1;
        System.out.println("Enter the first letter");

        while (i != -1)
        {
              if (scanChar.hasNextLine()) inputChar = scanChar.nextLine();
             else inputChar = null;
            if (inputChar.length() > 1) System.out.println("Must be a single letter");
            else
            {
              if (alphabet[i] == inputChar.charAt(0)) 
              {
                if (alphabet[i] != alphabet[0]) System.out.println("Correct!, next letter is : " + alphabet[i - 1]); //displays next letter
                i--; //decremented index
              }
              else 
              {
                System.out.println("Incorrect letter try again"); 
              }   
            }
            endTime = System.currentTimeMillis();     
        }

        
        timeTaken =  endTime - startTime;
        stringTime = Long.toString(timeTaken);
        stringTime = stringTime.substring(0, stringTime.length() - 3) + "." + stringTime.substring(stringTime.length() - 3, stringTime.length());
        System.out.printf("You got it done in %s s", stringTime);

    }



    public static void main(String[] args) 
    {
        boolean endCheck = false; // used to exit do while loop
      
        do
        {
           System.out.println("Forwards (f) or backwards (b)"); //Choice is displayed to user
           choice = scanChar.nextLine(); //Choice is recorded
            if (choice.charAt(0) == 'f')
            {
              forwards(); //Calls forwards method if f is typed in
              endCheck = true; // End check is set to true in order to exit do while loop
            } 
            else if (choice.charAt(0) == 'b') 
            {
              backwards(); //Calls backwards method if b is typed in
              endCheck = true; // End check is set to true in order to exit do while loop
            }
            else System.out.println("Incorrect input"); //Error message is displayed on incorrect input
        } while(choice != "b" && choice != "a" && endCheck != true); //Repeats if incorrect input is made
            
    }
}