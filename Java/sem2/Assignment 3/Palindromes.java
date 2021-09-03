

public class Palindromes
{
    public static int c, inputLen, m1c,m2c,m3c,m4c,m5c,m6c,tempVar,methodCheck; // declaring counters and other integer variables
    public static long startTime, endTime; // declaring the start and end time variables
    public static String reversedString; // declaring public reversed string

    public static void main(String[] args)
    {
        m1c = m2c = m3c = m4c = m5c = m6c = 0; // initialising counters

        methodCheck = 0; // setting method for which to count
        

        startTime = System.currentTimeMillis(); // setting start time
        for (int i = 0; i <= 1000000; i++)
        {
            reverseByLoop(String.valueOf(i)); // calling reversebyLoop method and passing in string current number loop to 1 mil
        }
        endTime = System.currentTimeMillis(); // setting end time
        System.out.println("Time taken for reverseByLoop in decimal (Method 1) : " + (endTime - startTime) + "ms"); // listing time by taking them away
        

        startTime = System.currentTimeMillis();
        for (int i = 0; i <= 1000000; i++)
        {
            reverseByLoop(decimalToBinary(String.valueOf(i)));
        }
        endTime = System.currentTimeMillis();
        
        System.out.println("Time taken for reverseByLoop in binary (Method 1) : " + (endTime - startTime) + "ms");
        System.out.println("Number of operations for reverseByLoop (Method 1) : " + (m1c));
        System.out.println("Number of operations for decimal to binary : " + m6c); 

        methodCheck = 1;
        startTime = System.currentTimeMillis();
        for (int i = 0; i <= 1000000; i++)
        {
            checkUntilFalse(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("\nTime taken for checkUntilFalse in decimal (Method 2) : " + (endTime - startTime) + "ms");
        

        startTime = System.currentTimeMillis();
        for (int i = 0; i <= 1000000; i++)
        {
            checkUntilFalse(decimalToBinary(String.valueOf(i)));
        }
        endTime = System.currentTimeMillis();

        
        System.out.println("Time taken for checkUntilFalse in binary (Method 2) : " + (endTime - startTime) + "ms");
        System.out.println("Number of operations for checkUntilFalse (Method 2) : " + (m2c));
        System.out.println("Number of operations for decimal to binary : " + m6c);
        

        

        methodCheck = 2;
        startTime = System.currentTimeMillis();
        for (int i = 0; i <= 1000000; i++)
        {
            stackCompareQueue(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("\nTime taken for StackCompareQueue in decimal (Method 3) : " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for (int i = 0; i <= 1000000; i++)
        {
            stackCompareQueue(decimalToBinary(String.valueOf(i)));
        }
        endTime = System.currentTimeMillis();
        

        System.out.println("Time taken for StackCompareQueue in binary (Method 3) : " + (endTime - startTime) + "ms");
        System.out.println("Number of operations for StackCompareQueue (Method 3) : " + (m3c));
        System.out.println("Number of operations for decimal to binary : " + m6c);
        m6c = 0;
        
        

        methodCheck = 3;
        startTime = System.currentTimeMillis();
        for (int i = 0; i <= 1000000; i++)
        {
            recursion(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("\nTime taken for recursion in decimal (Method 4) : " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for (int i = 0; i <= 1000000; i++)
        {
          recursion(decimalToBinary(String.valueOf(i)));
        }
        endTime = System.currentTimeMillis();
        
        System.out.println("Time taken for recursion in binary (Method 4) : " + (endTime - startTime) + "ms");
        System.out.println("Number of operations for recursion (Method 4) : " + (m4c + m5c));

        System.out.println("\nNumber of operations for decimal to binary : " + m6c);
        System.out.println("Number of operations for reverseString : " + m5c);

        int binaryPalindromeCount = 0; // initialising and declaring decimal / binary plaindrome count
        int decimalPalindromeCount = 0; // 

        for (int i = 0; i <= 1000000; i++)
        {
            if (checkUntilFalse(String.valueOf(i))) decimalPalindromeCount++; // checks for decimal palindrome and increments
            if(checkUntilFalse(decimalToBinary(String.valueOf(i)))) binaryPalindromeCount++; // checks for binary palindrome and increments
        }
        System.out.println("\nNumber of decimal palindromes : " + decimalPalindromeCount + "\nNumber of binary palindromes : " + binaryPalindromeCount); 

    }

    public static boolean reverseByLoop(String input) // method 1
    {
        String reversedString = ""; m1c += 2; // 2 operations 

        m1c += 6; // for for loop below
        for (int i = input.length() - 1; i > -1; i--) // 6 operations
        {
            reversedString += input.charAt(i); // 2 operations
            m1c += 8; 
        }
        if (reversedString.equals(input)) // 2 operations // if backwards == forwards
        {
            m1c += 3; 
            return true; // 1 operation
        }
        else // 1 operation
        {
            m1c += 2; 
            return false; // 1 operation
        }  
    }

    public static boolean checkUntilFalse(String input) // method 2
    {
        int i = 0; m2c += 2; // 2 operations
        m2c += 2; // for while loop 
        while (i != input.length()) // 2 operations
        {
            m2c += 2;
            if (input.charAt(i) != input.charAt(input.length() - i - 1)) // 7 operations // compare first to last, 2nd to 2nd last etc until string has been scanned
            {
                m2c += 8; // 8 operations 
                return false; // 1 operation
            }  
            i++; m2c += 2; // 2 operations
        }
        m2c++; 
        return true; // 1 operation 
    }

    public static boolean stackCompareQueue(String input)
    {
        ArrayQueue queue = new ArrayQueue(); m3c += 3; // 3 operations (new queue made)
        ArrayStack stack = new ArrayStack(); m3c += 3; // 3 operations (new stack made)

        int i = 0; m3c += 2; // 2 operations, counter initialised

        m3c += 2; // 2  operations (for while loop)
        while (i != input.length()) 
        {
            m3c += 2; // for while loop
            queue.enqueue(input.charAt(i)); m3c += 2; // 2(n-1) operations // current char queued
            stack.push(input.charAt(i)); m3c += 2; //  2(n-1) operations // current char pushed into stack
            i++; m3c += 2; // 2(n-1) operations // i incremented
        }

        m3c += 2 ; // 2  operations for while loop below

        while (!stack.isEmpty()) // 2n opeartions // pops and deques and compares until empty
        {
            m3c += 2;

            if ((char)stack.top() != (char)queue.front()) // 4 operations// if they are not equal
            {
                m3c += 5; 
                return false; // 1 operation // exit method
             }                    
            stack.pop(); m3c++; // n - 1 opeartions // pops from stack
            queue.dequeue(); m3c++; // n - 1 operations // deques from queue
        }
        m3c++;
        return true; // 1 operation // exits program
    }
    
    public static boolean recursion(String input)
    {
        c = 0; m4c++; // 1 operation // initialize counter
        inputLen = input.length() - 1; m4c += 3; // 3 operations // initialize length
        reversedString = ""; m4c++; // 1 operation // initialize reversed string
        if (input.equals(reverseString(input))) // 2 operations checks if the string is forwards = backwards
        {
            m4c += 3;
            return true; // one operation // exits
        } 
        else  // one operation
        {
            m4c += 2;
            return false; // one operation // exits
        }
    }

    public static String reverseString(String input)
    {
        tempVar = 0; // initializing tempVar
        reversedString += input.charAt(inputLen - c); tempVar += 4; // 4 operations
        tempVar++;
        c++; // one operation
        if(c == (inputLen + 1)) // 3 operations
        {
            tempVar += 4;
            m5c += tempVar;
            m4c += tempVar;
            return reversedString; // one operation
        }
        tempVar += 2;
        m5c += tempVar;
        m4c += tempVar;
        return reverseString(input); // 2 operations
    }

    public static String decimalToBinary(String decimalInput)
    {
        tempVar = 0;
        int currentNum = Integer.parseInt(decimalInput); tempVar += 3; // 3 operations // parses string to int
        String binaryString = ""; tempVar += 2; // 2 operations

        if (currentNum == 0) // 2 operations
        {
            binaryString = "0"; // one operation
            tempVar += 3;
        }
        else
        {
            tempVar++; // for else
            tempVar += 2; // for while + 2
            while (currentNum != 0) // 2 operations
            {
                tempVar+=2; // inside while ( n - 1)

                if (currentNum % 2 == 1) // 3 operations
                {
                    binaryString += "1"; // 2 operations
                    tempVar += 5;
                }
                else // 1 operation
                {
                    tempVar += 3;
                    binaryString += "0"; //  2 operations
                }
                currentNum = currentNum / 2; // 2 operations
                tempVar += 2;
            }   
        }
        tempVar++;
        m6c += tempVar;
        if (methodCheck == 0) m1c += tempVar;        // checks for which method to add to
        else if (methodCheck == 1) m2c += tempVar;
        else if (methodCheck == 2) m3c += tempVar;
        else if (methodCheck == 3) m4c += tempVar;
        return binaryString;
    }

}