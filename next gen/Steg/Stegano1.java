
/**
 * Skeleton code for Steganography assignment.
 *
 * @author Michael Schukat
 * @version 1.0
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Stegano1
{
    /**
     * Constructor for objects of class Stegano1
     */
    public Stegano1()
    {
    }

    public static void main(String[] args) {
        String arg1, arg2, arg3, arg4;
        Boolean err = false;
        
        if (args != null && args.length > 1) { // Check for minimum number of arguments
            arg1 = args[0];
            arg2 = args[1];
                
            if (arg2 == "") {
                err = true;
            }
            else if ((arg1.charAt(0) == 65) && (args.length > 3))
            {
                // Get other arguments
                arg3 = args[2];
                arg4 = args[3];
                if (arg3 == "" || arg4 == "") {
                    err = true;
                }
                else 
                {
                    // Hide bitstring
                    hide(arg2, arg3, arg4);
                }
            }
            else if (arg1.charAt(0) == 69){
                // Extract bitstring from text   
                retrieve(arg2);   
            }
            else {
                err = true;
                
            }
        }
        else {
            err = true;
            
        }
        
        if (err == true) {
            System.out.println();
            System.out.println("Use: Stegano1 <A:E><Input File><OutputFile><Bitstring>");
            System.out.println("Example: Stegano1 A inp.txt out.txt 0010101");
            System.out.println("Example: Stegano1 E inp.txt");
            
        } 
    }
    
    static void hide(String inpFile, String outFile, String binString) {
        // readers/writers
        BufferedReader reader; 
        BufferedWriter writer;
        int i; //i will be used for indexing
	
        try {
            reader = new BufferedReader(new FileReader(inpFile)); //read / writers
            writer = new BufferedWriter(new FileWriter(outFile));
            String line = reader.readLine(); // reads new lines
            i = 0; // counter set to 0
            boolean encoded = false; //checker for if message has been encoded

            while (line != null) 
            {
                // Your code starts here
                if (i != binString.length() && line.length() > 0 && encoded == false) // if end of bitvector string is reached message is encoded, does not encode if empty line, has a boolean value to make sure out of bounds index error doesent occur
                {
                    if (binString.charAt(i) == '0') line += " "; // if bit is 0 it is encoded as 1 space
                    if (binString.charAt(i) == '1') line += "  "; // if bit is 0 it is encoded as 2 spaces
                    i++; //index incremented
                } else if (i == binString.length()) encoded = true; // this stops adding once message has been encoded stopping any index error
                         
                // Store amended line in output file
                writer.write(line);
                writer.newLine();
		        // read next line
		       line = reader.readLine();
            }
            reader.close();
            writer.close();
            if (i < binString.length()) System.out.println("Message not fully encoded more lines needed"); // if bitstring has not been fully encoded error message pops up, calculated by boolean operator
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }
    
    static void retrieve(String inpFile) {
        BufferedReader reader;
	
        try {
            reader = new BufferedReader(new FileReader(inpFile));
            String line = reader.readLine();
            String printBitVector = ""; // decrypted bitVector stored here
            int lenBitVector, i; // Length of bit vector and i is declared here 

            while (line != null) 
            {
                // Your code starts here
                lenBitVector = 0; //length reset after each iteration
                i = line.length() - 1; // index of edge of line stored here

                while (line.length() > 0 && i != 0) // loops until end of line has been reached or i = 0
                {
                    if (line.charAt(i) == ' ') lenBitVector++; // counts how many spaces on the right of the line
                    else i = 1; // breaks loop by setting i equal to 1 which later gets decremented
                    i--; // decrements
                }

                if (lenBitVector == 1) printBitVector += "0"; // if length of bit vector is 1 0 is added to the resulting print vector
                if (lenBitVector == 2) printBitVector += "1"; //if length of bit vector is 2 1 is added to the resulting print bitvector
        
		        // read next line
		        line = reader.readLine();
            }
            reader.close();
            System.out.println("Bit Vector : " + printBitVector);
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }
}
