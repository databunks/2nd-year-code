import java.util.Scanner;

public class Assignment2 {
    private char precedenceArray[] = { '(', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-','+','/','*','^',')'};
    private char operandArray[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    private Scanner userInput = new Scanner(System.in);
    private String userInputString;
    private String outputString = "";
    private boolean errorCheck, charCheck;

    public static void main(String args[])
    {
        Assignment2 objRef = new Assignment2();
        ArrayStack arrayStack = new ArrayStack();
        do
        {
            System.out.println("Put in infex expression : ");
            objRef.setUserInputString(objRef.getUserInput().nextLine());  
            objRef.setErrorCheck(true);

            if (objRef.getUserInputString().length() < 3) 
            {
                System.out.println("Input is too short must be 3-20 charachters in length");
                objRef.setErrorCheck(false);
            }
            if (objRef.getUserInputString().length() > 20)
            {
                System.out.println("Input is too long must be 3-20 charachters in length");
                objRef.setErrorCheck(false);
            }
            int x = 0;
            int y = 0;

            while (y != objRef.getUserInputString().length())       
            {  
                for (int i = 0; i < objRef.getPrecedenceArray().length; i++)
                {
                    if(objRef.getPrecedenceArrayElement(i) == objRef.getUserInputString().charAt(y))
                    {
                        x++;
                    }
                }
               y++;
            }
                if (x != objRef.getUserInputString().length())
                {
                    objRef.setCharCheck(true);
                    objRef.setErrorCheck(false);
                }
             
            
            if (objRef.getCharCheck()) System.out.println("Contains illegal charachters");
            if (objRef.getErrorCheck())
            { 
                x = 0;
                int k = 0;

                while (x != objRef.getUserInputString().length())
                {
                    for (int i = 0; i < objRef.getOperandArray().length;i++)
                    { 
                        //GET RID OF OPERAND ARRAY DO IT THE LONG WAY                      
                        if (objRef.getOperandArrayElement(i) == objRef.getUserInputString().charAt(x)) objRef.appendOutput(String.valueOf(objRef.getUserInputString().charAt(x))); 
                        else if (!arrayStack.isEmpty() && k == 0 ) if (objRef.getPrecedence(objRef.getUserInputString().charAt(x)) > objRef.getPrecedence((char)arrayStack.top()) || (char)arrayStack.top() == '(') 
                        { 
                            arrayStack.push(objRef.getUserInputString().charAt(x));    
                            System.out.println(arrayStack.top());
                        }      
                        else if (arrayStack.isEmpty() && k == 0) arrayStack.push(objRef.getUserInputString().charAt(x));
                        else if (k == 0)
                        {
                            while(!arrayStack.isEmpty() && objRef.getPrecedence((char)arrayStack.top()) < objRef.getPrecedence(objRef.getUserInputString().charAt(x)))
                            {
                                if (objRef.getUserInputString().charAt(x) != '(' && objRef.getUserInputString().charAt(x) != ')')
                                {
                                    if (objRef.getPrecedence((char)arrayStack.top()) >= objRef.getPrecedence(objRef.getUserInputString().charAt(x)))
                                    {
                                        arrayStack.pop();
                                        objRef.appendOutput(String.valueOf(arrayStack.top()));
                                    }
                                }
                                else arrayStack.push(objRef.getUserInputString().charAt(x));                           
                            }

                            arrayStack.push(objRef.getUserInputString().charAt(x));
                        }
                        k++;                      
                    }

                        if (objRef.getUserInputString().charAt(x) == '(') 
                        {
                            arrayStack.push(objRef.getUserInputString().charAt(x));
                        }

                        if (objRef.getUserInputString().charAt(x) == ')') 
                        {
                           while ((char)arrayStack.top() != '(' && !arrayStack.isEmpty())
                           {
                               arrayStack.pop();
                               objRef.appendOutput(String.valueOf((char)arrayStack.top()));
                           }
                        }
                    x++;
                    k = 0;
                }

                arrayStack.pop();
                while(!arrayStack.isEmpty())
                {
                    objRef.appendOutput(String.valueOf((char)arrayStack.top()));
                    arrayStack.pop();
                }
                
                System.out.println(objRef.getOutputString());
            }

        }while(!objRef.getErrorCheck());
    }

    public void setUserInputString(String userInputString) {
        this.userInputString = userInputString;
    }

    public void setErrorCheck(boolean errorCheck) {
        this.errorCheck = errorCheck;
    }

    public void setCharCheck(boolean loopCheck) {
        this.charCheck = loopCheck;
    }

    public void appendOutput(String append) {
        outputString += append;
    }

    public String getOutputString() {
        return outputString;
    }

    public boolean getCharCheck() {
        return charCheck;
    }

    public boolean getErrorCheck() {
        return errorCheck;
    }

    public Scanner getUserInput() {
        return userInput;
    }

    public String getUserInputString() {
        return userInputString;
    }

    public char[] getOperandArray()
    {
        return operandArray;
    }

    public char getOperandArrayElement(int index)
    {
        return operandArray[index];
    }

    public char[] getPrecedenceArray() {
        return precedenceArray;
    }

    public char getPrecedenceArrayElement(int index) 
    {
        return precedenceArray[index];
    }

    public int getPrecedence(char charInput) 
    {
        int i = 0;
        int res = 0;
        while (i != precedenceArray.length) 
        {
            if (charInput == precedenceArray[i]) res = i;
            i++;
        }
        return res;
    }
}