
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
            String line = reader.readLine();
            int i = 0;
            int binLength = binString.length();
            boolean messageHidden = false;

            while (line != null) 
            {
                // Your code starts here
                if (i == binLength) messageHidden = true;

               

                if (messageHidden == false)
                {
                    if (i < binString.length() - 1 && line.length() >= 2)
                    {
                        if (binString.charAt(i) == '0') line += " ";
                        if (binString.charAt(i) == '1') line += "  ";
                        if (binString.charAt(i + 1) == '0') line += " ";
                        line += ",";
                        if (binString.charAt(i + 1) == '1') line += "  ";
                    }

                else if (binString.length() % 2 != 0 && line.length() >= 2)
                        {
                            line += " ";
                            System.out.println("poggers");
                        }
                                
                }

                i++;
                // Store amended line in output file
                writer.write(line);

                writer.newLine();
		        // read next line
		       line = reader.readLine();
            }
            reader.close();
            writer.close();
            if (i < binString.length()) System.out.println("Message not fully encoded more lines needed");
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }
    
    static void retrieve(String inpFile) {
        BufferedReader reader;
	
        try {
            reader = new BufferedReader(new FileReader(inpFile));
            String line = reader.readLine();
            String printBitVector = "";
            int lenBitVector , lenLine, lastChar, secondLastChar, thirdLastChar, fourthLastChar, charsRightToComma, commaIndex;
            
    
            while (line != null) 
            {
                
                // Your code starts here
                lenLine = line.length();
                lastChar = lenLine - 1;
                secondLastChar = lenLine - 2;
                thirdLastChar = lenLine - 3;
                fourthLastChar = lenLine - 4;
                lenBitVector = 0;
                commaIndex = 0;

                for (int i = 0; i < lenLine; i++)
                {
                    if (line.charAt(i) == ',') commaIndex = i;
                }

                charsRightToComma = lenLine - commaIndex - 1;

                

                if (lenLine >= 4)
                 {
                    for (int i = fourthLastChar; i < lenLine; i++)
                    {
                       if (line.charAt(i) == ' ')
                       {
                         lenBitVector++;
                       }
                    }
                 }
            else if (lenLine >= 2)
                 {
                    for (int i = secondLastChar; i < lenLine; i++)
                    {
                       if (line.charAt(i) == ' ')
                       {    
                         lenBitVector++;
                       }
                    }
                 }
                 System.out.println(charsRightToComma);

                 if (lenBitVector == 2) printBitVector += "00";
            else if (lenBitVector == 3 && charsRightToComma == 0) 
                 {
                    printBitVector+= "10"; 
                    System.out.println("poggers");
                 }
            else if (lenBitVector == 4) printBitVector += "11";
               
                  

               // System.out.println(line);
                
		        // read next line
		        line = reader.readLine();
            }
            reader.close();
            System.out.println(printBitVector);
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }
}