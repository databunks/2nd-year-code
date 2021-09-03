import java.util.Scanner;

public class InfixToPostFix
{
    public static void main(String[] args)
    {
        String userInputString, outputString; //Input string and output string declared here
        Scanner userInput; // Scanner object userInpit declared here
        boolean errorCheck, check; // error checks are declared here
        int j,i,l,op1,op2; // counters / operands declared here
        double divl; // double output declared here for postfix use
        char validCharArray[] = { '(', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-','+','/','*','^',')'}; // array of valid charachters declared here for use in checking
        char[] precedenceArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-','+','/','*','^'}; // this array will be used for finding precedence
        ArrayStack arrayStack = new ArrayStack(); // arraystack object declared here for use of arraystack methods
        char current; // current char declared here 

        do
        {
            System.out.println("Type in infix expression : "); //user prompted to type in expression
            errorCheck = false; // error check reset here
            l = op1 = op2 = j = 0; //counters value set here
            userInput = new Scanner(System.in); // scanner object initialised
            userInputString = userInput.nextLine(); // input taken here 
            outputString = ""; // outputString initialised here in order to be appended to later

            if (userInputString.length() > 20 || userInputString.length() < 3) // valid string length checked here
            {
                errorCheck = true; // sets error check to true making do while loop repeat
                System.out.println("Input must be between 3 and 20 characters (inclusive)"); // error check returned
            }

            while (j != userInputString.length()) // iterates through whole string
            {
                for (i = 0; i < validCharArray.length; i++)
                {
                   if(userInputString.charAt(j) == validCharArray[i]) l++; // l is incremented whenever charachters matched
                }
                j++; // counter incremented
            }

            if (userInputString.length() != l) 
            {
                errorCheck = true; // error check is set to true do while loop is exited
                System.out.println("Contains illegal characters must be operands operators or paranthesis"); // error message returned when invalid / illegal characters spotted
            }
            
            j = 0; // counter reset

            if (!errorCheck) // does not go through program if errorcheck is set on
            {
              while (j != userInputString.length()) // iterates through whole user input string
              {
                current = userInputString.charAt(j); // current charachter is stored in current variable

                if (Character.isDigit(current)) outputString += current; // if the current is a digit it gets stored in output string
                else if (arrayStack.isEmpty() || (char)arrayStack.top() == '(') arrayStack.push(current); // if stack is empty or top of stack is empty then it gets pushed into stack
                else if (arrayStack.isEmpty() && getPrecedence(precedenceArray, current) > getPrecedence(precedenceArray, (char)arrayStack.top()) && isOperator(precedenceArray, current) && isOperator(precedenceArray, (char)arrayStack.top())) arrayStack.push(current); // if the precedence of the scanned operator is greater than the precedence of the operator in the stack then push it into stack
                else if (isOperator(precedenceArray, (char)arrayStack.top())) // else if the top of the stack is an operator then do the bottom block of code
                {
                    check = true; // initialises check
                    while (check) // while check is true
                    {     // current charachter has to be an operator and the precedence of the top of the stack has to be greater or equal to the precedence of the current and the top of the stack is not equal to the paranthesis and the top of the stack is an operator then pop it
                        if (isOperator(precedenceArray, current) && getPrecedence(precedenceArray, (char)arrayStack.top()) >= getPrecedence(precedenceArray, current) && (char)arrayStack.top() != ')' && (char)arrayStack.top() != '(' && isOperator(precedenceArray, (char)arrayStack.top())) outputString += (char)arrayStack.pop();
                        // if the arraystack is empty and the top of the stack has a parenthesis and it is an operator then push it into stack                                
                        else if (arrayStack.isEmpty() && (char)arrayStack.top() == '(' || (char)arrayStack.top() == ')' && isOperator(precedenceArray, current)) 
                        {
                            arrayStack.push(current);  // push the current charachter into stack
                            check = false; // check is set to false exiting the while 
                        }
                        else check = false; // check is set to false exiting the whil
                        if (arrayStack.isEmpty()) check = false; // check is set to false exiting the while loop if empty
                    }
                    arrayStack.push(current); // current is pushed into stack
                }

                if (current == '(') arrayStack.push(current); // if the current is an open paranthesis then its pushed into stack

                if (current == ')') // if the current is a closing paranthesis then do block of code below
                {
                    arrayStack.pop(); // pop the stack
                    while (!arrayStack.isEmpty() && (char)arrayStack.top() != '(') // goes through whole stack until '(' or arraystack is empty
                    {   
                        outputString += (char)arrayStack.pop();   // stack is popped and appended to output string
                    }      
                    if (!arrayStack.isEmpty()) arrayStack.pop(); // if the arraystack isnt empty then pop it
                }
                j++; // counter is incremented iterating through string
             }

                while (!arrayStack.isEmpty()) // goes through whole stack until empty
                {
                    if((char)arrayStack.top() != '(' && (char)arrayStack.top() != ')') outputString += (char)arrayStack.pop(); // if the top of the stack is not a paranthesis pop and append to string
                    else arrayStack.pop(); // pop all of it                  
                }

                System.out.println("Postfix string : " + outputString); // postfix string is appeneded to output

                for (i = 0; i < outputString.length(); i++) // iterates through whole postfix string
                {
                    current = outputString.charAt(i); // current character is stored in current

                    if (Character.isDigit(current)) arrayStack.push(current - '0'); // if the current charachter was a digit then push it into stack and convert to integer
                    else if (isOperator(precedenceArray, current)) // if the current character is an operator then do below block of code
                    {                   
                        if (!arrayStack.isEmpty()) op1 = (int)arrayStack.pop(); // first operand is popped and set to op1
                        if (!arrayStack.isEmpty()) op2 = (int)arrayStack.pop(); // first operand is popped and set to op2
                        
                        if (current == '+') // if operator is +
                        {
                            l = op1 + op2; // operands are added together
                            System.out.println(op2 + "+" + op1 + " = " + l); // prints out calculation
                            arrayStack.push((int)l); // result is pushed into stack
                        }

                        if (current == '-') // if operator is -
                        {
                            l = op2 - op1; // operands are subtracted
                            System.out.println(op2 + "-" + op1 + " = " + l); // prints out calculation
                            arrayStack.push((int)l); // result is pushed into stack
                        }

                        if (current == '/') // if operator is /
                        {
                            divl = (double)op2 / (double)op1; // operands divided and casted to double to catch for decimal points
                            System.out.println(op2 + "/" + op1 + " = " + divl); // prints out calculation
                            arrayStack.push((double)divl); // result is pushed into stack (casted as double due to division sometimes resulting in decimal points)
                        }

                        if (current == '^') // if operator is ^
                        {
                            l = (int)Math.pow(op2,op1); // op2 is exponentiated
                            System.out.println(op2 + "^" + op1 + " = " + l); // prints out calculation
                            arrayStack.push((int)l); // result is pushed into stack
                        }

                        if (current == '*') // if operator is *
                        {
                            l = op2 * op1; // operands are multiplied 
                            System.out.println(op2 + "*" + op1 + " = " + l); // prints out calculation
                            arrayStack.push((int)l); // result is pushed into stack
                        }
                    }
                }
                System.out.println("Postfix Calcuation Answer : " + arrayStack.top()); // Postfix calculation printed
            } 
        } while(errorCheck); // error check is checked
    }

    public static int getPrecedence(char[] precedenceArray, char inputChar) // getPrecedence method initiated here takes in precedence array and inputted character to calculate the precedence
    {
        int res = 0; // result is intialised here
        for (int i = 0; i < precedenceArray.length; i++)
        {
            if (precedenceArray[i] == inputChar) res = i; // if match found index of array is set to res
        }
        return res; // result returned
    }

    public static boolean isOperator(char[] precedenceArray ,char inputChar) // isOperator method initiated here takes in precedence array and inputted character to calculated precedence
    {
        boolean check = false; // check is set to false

        for (int i = 10; i < precedenceArray.length; i++)
        {
            if (precedenceArray[i] == inputChar) check = true; // check returns true if operator match is found
        }
        return check; // check returned boolean 1 ir 0
    }
}