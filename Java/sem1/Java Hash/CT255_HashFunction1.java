import java.util.ArrayList;


//import jdk.javadoc.internal.doclets.formats.html.AllPackagesIndexWriter;
/**
 *
 * @author Michael Schukat, 2019
 */

public class CT255_HashFunction1 {

    public static void main(String[] args) {
        long res = 0;
        

        if (args != null && args.length > 0) { // Check for <input> value
            res = hashF1(args[0]); // call hash function with <input>
            if (res < 0) { // Error
                System.out.println("Error: <input> must be 1 to 64 characters long.");
            }
            else
             {
                System.out.println("input = " + args[0] + " : Hash = " + res);
                System.out.println("Start searching for collisions");
                // Your code to look for a hash collision starts here!
                
                bruteForce(3, res); // brute force function is called, you can set the length of how many inputs to be tried
                            
                    
            } 
        }   
        
        else
           { // No <input> 
              System.out.println("Use: CT255_HashFunction1 <Input>");
           } 
    }
  
    
    public static void bruteForce(int charLen, long res)
    {         
      long collisionAttempt; // stores the hash of each attempt
      String[] alphaNumericChars = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","0","1","2","3","4","5","6","7","8","9"}; //This stores all the alphanumeric charachters, you can add more to this list but for the sake of demonstration i just added these to reduce computation time
      ArrayList<String> bruteForceInput = new ArrayList<String>();; // ArrayList containing each charachter combination before being turned into a string
      int alphaNumericCharsCountIndex = 0; // Index for the array containing the charachters to be tried
      int alphaNumericCharsIndex = 0; // Index according to the length of the input
      int numberOfTimes = 0; // Counts the amount of combinations tried
      int hashCollisions = 0; //Counts the number of collisions found
         

      while (charLen != alphaNumericCharsCountIndex) // Tries all the number of possible combinations until the charLen condition is reached
          {
            bruteForceInput.add(alphaNumericChars[alphaNumericCharsIndex]); // new charachter added for each iteration
            String hashStringInput = ""; // This contains the string to be hashed

            for (int i = 0; i <= alphaNumericCharsCountIndex; i++) //inputs all the charachters stored in the bruteForceInput arraylist to the hashStringInput
                {
                  hashStringInput += bruteForceInput.get(i);  
                }
                    
            collisionAttempt = hashF1(hashStringInput); // hashStringInput is then passed through the function
                    
            if (res == collisionAttempt) // Checks for hash collision to the initial string
               {
                System.out.println("Collision found !! : " + hashStringInput);
                hashCollisions++;
               }


            for (int x = 0; x < alphaNumericCharsCountIndex; x++) // This whole loop checks and sets the previous element in the arraylist to increment to the next element in the alphanumeric arraylist and resets anything in the arraylist to the first index if it reaches the last element in this way it linearly increments
               {
                 for (int i = 1; i <= alphaNumericCharsCountIndex; i++)
                     {
                       if (bruteForceInput.get(i) == alphaNumericChars[alphaNumericChars.length - 1] && bruteForceInput.get(i - 1) != alphaNumericChars[alphaNumericChars.length - 1])
                          {
                           bruteForceInput.set(i - 1, alphaNumericChars[findIndex(bruteForceInput.get(i - 1), alphaNumericChars.length - 1,alphaNumericChars)]);
                          }      
                     }        
               }
            
                    
                     
            if (bruteForceInput.get(alphaNumericCharsCountIndex) == alphaNumericChars[alphaNumericChars.length - 1]) //if last index is reached the following occurs
               {      
                 alphaNumericCharsIndex = -1; //index is reset it is -1 since it is incremented to below so it will be 0 leaving the if statement
                 boolean check = false;  // this check makes sure that if the last element is reached in 2 different elements it will not increment and cause an error as shown by the if statements below
                        
                 for (int i = 0; i <= alphaNumericCharsCountIndex; i++)
                     {
                       if (bruteForceInput.get(i) != alphaNumericChars[alphaNumericChars.length - 1])
                          {
                            check = true; // if there are elements reached the last the check is set to true
                          }

                       if (bruteForceInput.get(i) == alphaNumericChars[alphaNumericChars.length - 1])
                          {
                             bruteForceInput.set(i, alphaNumericChars[0]);    //index of charachter is reset                             
                          }
                     }

                  if (check == false)
                    {
                      bruteForceInput.add(alphaNumericChars[0]); //adds a new element if check is set to false
                      alphaNumericCharsCountIndex++;           //charachter index is incremented as there is more charachters
                      
                    }              
                                            
               }
      
                        
       bruteForceInput.remove(alphaNumericCharsCountIndex); // The last element in the arraylist is removed to allow for another combination to be tried
       alphaNumericCharsIndex++; // The charachter index is incremented which is reference to the arraylist
       numberOfTimes++; // increments number of attempts (Fun fact : the number of attempts can also be calculated using X ^ N where N is the length of the charachter strings to be tried and X is the number of elements in the arraylist)
                   
     }
     System.out.println("Total of number combinations tried : " + numberOfTimes); // Prints number of combinations tried
     System.out.println("Total number of Hash Collisions : " + hashCollisions); // Prints number of hash collisions
     
    }

    private static int findIndex(String charachter, int charCount, String[] charArray) // this function returns the index of the next element in the array
    {
        boolean matchFound = false;
        boolean matchNotFound = false;
        int i = 0;

        while (matchFound == false && matchNotFound == false)  // conditions for if match is found or if end of array is reached
          {
            if(charachter == charArray[i])
              {
                  matchFound = true;
              }
            else if (i == charCount)
            {
              matchNotFound = true;
            }
            
            i++;
          }
      return i;   // returns next element of alphanumeric array
    }
    
        
    private static long hashF1(String s){
        long ret = -1;
        int i;
        long[] hashA = new long[]{3, 7, 4, 13, 3};  //Array of hashA length is increased to add more placeholders and increase collision ressistance also is of type long to store more numbers
        
        String filler,sIn;
        
        filler = new String("ABCDEFGHABCDEFGHABCDEFGHABCDEFGHABCDEFGHABCDEFGHABCDEFGHABCDEFGH");
        
        
        
        if ((s.length() > 64) || (s.length() < 1)) { // String does not have required length
            ret = -1;
        }
        else {
            sIn = s + filler; // Add characters, now have "<input>HABCDEF..."  before the 
            sIn = sIn.substring(0, 64); // // Limit string to first 64 characters
            // System.out.println(sIn); // FYI
            for (i = 0; i < sIn.length(); i++)
            {
                char byPos = sIn.charAt(i); // get i'th character
                hashA[0] += (byPos * 17); // Note: A += B means A = A + B
                hashA[1] += (byPos * 31);
                hashA[2] += (byPos * 101);  
                hashA[3] += (byPos * 79);
                hashA[4] += (byPos * 43);  //More placeholders are used increasing collision ressistance
                

            }
            
    
            hashA[0] %= 255;  // % is the modulus operation, i.e. division with rest
            hashA[1] %= 255;
            hashA[2] %= 255;
            hashA[3] %= 255; 
            hashA[4] %= 255;
           
            
            
            ret = hashA[0]  + (hashA[1]) + (hashA[2] * 256 * 256) + (hashA[3]) + (hashA[4]* 256 * 256 * 256 * 256) + (hashA[4]* 256 * 256 * 256 * 256 * 256);
            if (ret < 0) ret *= -1;
        }
        return ret;
    }    
}
