
/**
 *  This class provides functionality to build rainbow tables (with a different reduction function per round) for 8 character long strings, which
    consist of the symbols "a .. z", "A .. Z", "0 .. 9", "!" and "#" (64 symbols in total).
    Properly used, it creates the following value pairs (start value - end value) after 10,000 iterations of hashFunction() and reductionFunction():
          start value  -  end value
          Kermit12        lsXcRAuN
          Modulus!        L2rEsY8h
          Pigtail1        R0NoLf0w
          GalwayNo        9PZjwF5c
          Trumpets        !oeHRZpK
          HelloPat        dkMPG7!U
          pinky##!        eDx58HRq
          01!19!56        vJ90ePjV
          aaaaaaaa        rLtVvpQS
          036abgH#        klQ6IeQJ
          
          
 *
 * @author Michael Schukat
 * @version 1.0
 */
public class RainbowTable
{
    /**
     * Constructor, not needed for this assignment
     */
    public RainbowTable() 
    {

    }

    public static void main(String[] args) {
		long res = 0;
		int i = 0;
        String start;

		if (args != null && args.length > 0) { // Check for <input> value
			start = args[0];
				
            if (start.length() != 8) 
            {
                System.out.println("Input " + start + " must be 8 characters long - Exit");   
            }
            
            else
             {
                //Problem 1
                System.out.println("Problem 1 : \n");
                problem1(start , res); // argument from console (Kermit12) and res is passed through as parameter
                System.out.println("");

              //Problem 2
              System.out.println("Problem 2 : \n");
              problem2(); // Solution to problem 2 is called
             }
              

            
		}
        else 
        { // No <input> 
			System.out.println("Use: RainbowTable <Input>");
		} 
    }

    public static void problem1(String start, long res)
    {
       

                String plainText = start; // plaintext start value is stored in plaintext
                int i; // Counter
             
               
                for (i = 0; i < 10000; i++) // Loops 10k times
                 {
                    res = hashFunction(plainText); // plain text is hashed and stored in res
                    plainText = reductionFunction(res, i); // res is then reduced based on index i and stored in plaintext
                    //Loop repeats until the end plaintext value is reached after 10k iterations            
                 }
              System.out.println("Start chain : " + start); //prints start plaintext value
              System.out.println("End chain : " + plainText); //prints 10kth plaintext value

    }

    public static void problem2()
    {
        String[] startValues = {"Kermit12","Modulus!","Pigtail1","GalwayNo","Trumpets","HelloPat","pinky##!","01!19!56","aaaaaaaa"," 036abgH#"}; // list of chains to test to see if we can crack them
        String plainText; // plaintext value is stored here
        long res; // hashed plaintext is stored here
        boolean cracked = false; // check to see if we have found a match

        for (int j = 0; j < startValues.length; j++) //loops through whole startValue array
        {
            plainText = startValues[j]; //start value at index j is taken 
            cracked = false; // Cracked is set to false at beginning of loop so we can see if we can find a match to the current start value index
            int i = 0; // counter reset at start of loop
            res = 0; // hashed plaintext is reset
            while (cracked == false && i < 10000) // loop will run until it finds a match or after 10k iterations
            {
                res = hashFunction(plainText); //Hashed plaintext is stored inside loop

                if (res == 977984261343652499L || res == 111111111115664932L || res == 750105908431234638L || res == 895210601874431214L) // We are comparing the current hash inside the chain to any of the hashes we want to find so we can find a match
                {
                    System.out.println("");
                    System.out.println("Match found : " + plainText); // prints out plaintext corresponding to one of the hashes we want to find
                    System.out.println("For hash : " + res); // prints out one of the hashes we were looking for
                    System.out.println("Start value : " + startValues[j]); // Prints the corresponding start value
                    System.out.println("");
                    cracked = true; // boolean cracked set to true which is reffered to later on
                    
                }
                plainText = reductionFunction(res, i); // hash is reduced 
                i++; //counter incremented
            }

            if (cracked == false && j != startValues.length - 1) // This prints until the second last element in the start chain array
            {
             System.out.println("No match found for " + startValues[j] + " trying for another chain........."); // Prints out that a match is not found if cracked is still set to false
            }

            if (j == startValues.length - 1 && cracked == false) // prints out when final element is reached
            {
              System.out.println("No match found for " + startValues[j] + "\nEnd of chain reached tried all start values"); // prints out false finding if cracked is still false
            }
            else if (j == startValues.length - 1 && cracked == true) // does the same as if a crack is found except prints out end of chain reached at the end if crack is found
            {
                System.out.println("");
                System.out.println("Match found : " + plainText); // prints out plaintext corresponding to one of the hashes we want to find
                System.out.println("For hash : " + res); // prints out one of the hashes we were looking for
                System.out.println("Start value : " + startValues[j]); // Prints the corresponding start value
                System.out.println("");   
                System.out.println("End of chain reached, tried all start values"); 
            }

        }
        

	}

        
        
    private static long hashFunction(String s){
        long ret = 0;
        int i;
        long[] hashA = new long[]{1, 1, 1, 1};
        
        String filler, sIn;
        
        int DIV = 65536;
        
        filler = new String("ABCDEFGHABCDEFGHABCDEFGHABCDEFGHABCDEFGHABCDEFGHABCDEFGHABCDEFGH");
        
        sIn = s + filler; // Add characters, now have "<input>HABCDEF..."
        sIn = sIn.substring(0, 64); // // Limit string to first 64 characters

        for (i = 0; i < sIn.length(); i++) 
        {
            char byPos = sIn.charAt(i); // get i'th character
            hashA[0] += (byPos * 17111); // Note: A += B means A = A + B
            hashA[1] += (hashA[0] + byPos * 31349);
            hashA[2] += (hashA[1] - byPos * 101302);
            hashA[3] += (byPos * 79001);
        } 
           
        ret = (hashA[0] + hashA[2]) + (hashA[1] * hashA[3]);
        if (ret < 0) ret *= -1;
        return ret;
    } 
    
    private static String reductionFunction(long val, int round) {  // Note that for the first function call "round" has to be 0, 
        String car, out;                                            // and has to be incremented by one with every subsequent call. 
        int i;                                                      // I.e. "round" created variations of the reduction function.
        char dat;                                                  
        
        car = new String("0123456789ABCDEFGHIJKLMNOPQRSTUNVXYZabcdefghijklmnopqrstuvwxyz!#");
        out = new String("");
      
        for (i = 0; i < 8; i++) 
        {
            val -= round;
            dat = (char) (val % 63);
            val = val / 83;
            out = out + car.charAt(dat);
        }
        
        return out;
    }
}
