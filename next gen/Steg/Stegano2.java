
/**
 * Skeleton code for Steganography assignment.
 *
 * @author 
 * @version 1.0
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Stegano2
{
    /**
     * Constructor for objects of class Stegano1
     */
    public Stegano2()
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
        // 
        BufferedReader reader;
        BufferedWriter writer;
	
        try {
            reader = new BufferedReader(new FileReader(inpFile));
            writer = new BufferedWriter(new FileWriter(outFile));
            String line = reader.readLine(); // New line is read each time
            int i = 0; // used for indexing
            int binLength = binString.length(); // calculates length of bit Vector
            boolean encoded = false;

            if (binLength % 2 != 0) binString += "0"; //If the bitVector is odd a padding is added (0 bit)
            
            while (line != null) // reads until end of file 
            {
                // Your code starts here
                if (i != binString.length() && line.length() > 0 && encoded == false) // if end of bitvector string is reached message is encoded, does not encode if empty line, has a boolean value to make sure out of bounds index error doesent occur
                {
                    if (binString.charAt(i) == '0' && binString.charAt(i + 1) == '0') line += " ";  // Encodes bit 00 as " "              

                    if (binString.charAt(i) == '0' && binString.charAt(i + 1) == '1') line += "  "; // Encodes bit 01 as "  " 
                  
                    if (binString.charAt(i) == '1' && binString.charAt(i + 1) == '0') line += "   "; // Encodes bit 10 as "   " 

                    if (binString.charAt(i) == '1' && binString.charAt(i + 1) == '1') line += "    "; // Encodes bit 11 as "    " 

                    i = i + 2; //index counter is incremented as there is 2 bits stored per line
                }
                else if (i == binString.length()) encoded = true; // this stops adding once message has been encoded stopping any index error
                // Store amended line in output file
                writer.write(line);
                writer.newLine();
		        // read next line
		       line = reader.readLine();
            }
            reader.close();
            writer.close();
            if (i < binString.length()) System.out.println("Message not fully encoded more lines needed"); // If counter does not match the length of the bitvector array user gets notified
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }
    
    static void retrieve(String inpFile) {
        BufferedReader reader;
	
        try {
            reader = new BufferedReader(new FileReader(inpFile));
            String line = reader.readLine(); // Newline read each time
            String printBitVector = ""; // Hidden bitVector stored here
            int lenLine, lenBitVector, i; // length of line, length of bit vector and index declared here
    
            while (line != null) // reads until end of file 
            {
                // Your code starts here

                lenLine = line.length(); // Length of line stored per iteration
                lenBitVector = 0; // length of bitVector reset
                i = lenLine - 1; // index to edge of line is recorded
                
                while (i != 0) // loops until end of line
                {
                    if (line.length() > 0) // does not check line if it is empty
                    {
                        if (line.charAt(i) == ' ') lenBitVector++; // counts the spaces added right to the file
                        else i = 1; // or else it sets the counter to 1 which then gets decremented and loop terminated
                    }
                    else i = 1; // or else it sets the counter to 1 which then gets decremented and loop terminated
                    i--; // decrements index
                }
                if (lenBitVector == 1) printBitVector += "00"; // Adds corresponding bit to the length of the spaces
                if (lenBitVector == 2) printBitVector += "01"; // Adds corresponding bit to the length of the spaces
                if (lenBitVector == 3)  printBitVector += "10"; // Adds corresponding bit to the length of the spaces
                if (lenBitVector == 4) printBitVector += "11"; // Adds corresponding bit to the length of the spaces
            
                
		        // read next line
		        line = reader.readLine(); // reads next line
            }
            reader.close();
            System.out.println("Bit vector : " + printBitVector + " Remember if the original bitvector is of odd length just subtract 1 bit from the bitvector to get the actual result :)"); //prints bitvector
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }
}