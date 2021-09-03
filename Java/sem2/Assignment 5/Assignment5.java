
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.BufferedReader;
import java.io.*;


public class Assignment5
{
    public static void main(String[] args)
    {
        String answer; // storing answer before loop
        BinaryTree<String> tree = createTree(); // tree is initialized here 
        
        while (true)
        {
            displayTree(tree); // displays the content of the tree and some statistics
            BinaryNodeInterface<String> currentNode = tree.getRootNode(); // we first start by asking the first question (root node)
            while (!currentNode.isLeaf()) // keep asking questions until we reach a root node
            {
                System.out.println(currentNode.getData() + " (Y/n?)"); // ask whatever question is stored in the node
                Scanner scanner = new Scanner(System.in); // scanner object instantiated
                answer = scanner.nextLine(); // input is taken from the user and stored in answer
                if (answer.toLowerCase().equals("y")) currentNode = currentNode.getLeftChild(); // if user indicates correct answer then we iterate to the left child node
                else if (answer.toLowerCase().equals("n")) currentNode = currentNode.getRightChild(); // if user indicates incorrect answer then we iterate to the right child node
                else System.out.println("\nInvalid input try again");
                System.out.println("");
            }

            boolean errorCheck = true; // checks for user error
            boolean continuePlaying = true; // checks the condition in which the user keeps playing

            while (errorCheck) // checks for errors by the user 
            {
                System.out.println(currentNode.getData() + " (Y/n?)"); // prompts the leafnode question
                Scanner scanner = new Scanner(System.in); // scanner object instantiated
                answer = scanner.nextLine();  // asks for input from the user
                if (answer.toLowerCase().equals("y")) // if the user indicates the answer is correct
                {
                    boolean errorCheck2 = true; // instantiate user input error check
                    while (errorCheck2) // checks for errors by the user 
                    {
                        System.out.println("\nLooks like we guessed right, would you like to :");
                        System.out.println("Would you like to play again? (1)");
                        System.out.println("Save the tree? (2)");
                        System.out.println("Load another tree? (3)");
                        System.out.println("Quit? (4)");
                        scanner = new Scanner(System.in);
                        answer = scanner.nextLine();
                        
                        if (answer.equals("1")) errorCheck2 = false; // if 1 is entered then game will be replayed
                        else if (answer.equals("2"))
                        {
                            saveTree(tree); // if 2 is entered current tree is saved
                            errorCheck2 = false;
                        }
                        else if (answer.equals("3")) // if 3 is entered
                        {
                            System.out.println("Enter the file path: "); // user prompted for file path
                            scanner = new Scanner(System.in); // scanner object reinstantiated
                            answer = scanner.nextLine(); // user is prompted to enter in file path
                            tree = loadTree(answer); // tree is loaded from path entered
                            errorCheck2 = false; 
                        }
                        else if (answer.equals("4"))
                        {
                            errorCheck2 = false;
                            continuePlaying = false; // if user enters in 4 then program will stop
                        }
                        else System.out.println("\nInvalid input try again\n"); // alert the user indicating invalid input 
                    }

                    errorCheck = false;
                }
                else if (answer.toLowerCase().equals("n")) // if the user indicates the answer is wrong
                {
                    String question,yes,no; // variables declared for user input
                    System.out.println("Looks like we guessed wrong, what question should we replace it with? :");
                    question = scanner.nextLine(); // asks for input from the user
                    System.out.println("What correct answer question should we replace it with? :");
                    yes = scanner.nextLine(); // asks for input from the user
                    System.out.println("What incorrect answer question should we replace it with? :");
                    no = scanner.nextLine(); // asks for input from the user
                    currentNode.setData(question); // sets the question from the user
                    BinaryNode<String> leftNode = new BinaryNode<String>(yes); // sets the correct question from the user
                    BinaryNode<String> rightNode = new BinaryNode<String>(no); // sets the incorrect question from the user
                    currentNode.setLeftChild(leftNode); // sets the correct question from the user
                    currentNode.setRightChild(rightNode); // sets the incorrect question from the user
                    errorCheck = false;
                }
                else System.out.println("\nInvalid input try again"); // prompts that the user has made an error in inputting
                System.out.println("");
            }
            if (!continuePlaying) break; // quits program if continuePlaying is set to false
        }
    }

    public static void displayTree(BinaryTree tree) // displays the content of the tree and some statistics
    {
        if (tree.isEmpty()) System.out.println("Tree is empty");
        else
        {
            System.out.println("In order traversal of the tree : ");
            tree.inorderTraverse();
            System.out.println("");
            System.out.println("Root of tree is :" + tree.getRootData());
            System.out.println("Height of tree is :" + tree.getHeight());
            System.out.println("No. of nodes in tree is :" + tree.getNumberOfNodes());
            System.out.println("----------------------------------------------------");
            System.out.println("");
        }
    }

    public static void saveTree(BinaryTree tree) // saves the current tree in a text file in serialized format
    {
        try 
        {
            FileOutputStream fileOut =
            new FileOutputStream("savedTree.txt"); // tree is saved to this path
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(tree);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in :" + "savedTree.txt");
         } catch (IOException i) 
         {
            i.printStackTrace();
         }
    }

    public static BinaryTree loadTree(String path) // loads a tree from path entered must be in serialized format
    {
        BinaryTree tree = null;
        try 
        {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            tree = (BinaryTree) in.readObject(); // takes in a binary tree class type object
            in.close();
            fileIn.close();
            return tree; // returns the tree
         } catch (IOException i) // catches error
         {
            i.printStackTrace();
            return tree; // returns the tree
         } catch (ClassNotFoundException c) // catches error
         {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return tree; // returns the tree
         }
         
    }

    public static BinaryTree createTree() // initalizes the first tree
    {
        BinaryTree<String> a = new BinaryTree<String>("Is it a big mac?");                   // start by creating
        BinaryTree<String> b = new BinaryTree<String>("Is it a taco?");                      // leaf nodes
        BinaryTree<String> c = new BinaryTree<String>("Is it from mcDonalds", a, b);         // join the leaf nodes by their parent nodes

        BinaryTree<String> d = new BinaryTree<String>("Is it beans and toast?");             // start by creating
        BinaryTree<String> e = new BinaryTree<String>("Is it butter on a stick?");           // leaf nodes
        BinaryTree<String> f = new BinaryTree<String>("Is it a healthy meal?", d, e);        // join the leaf nodes by their parent nodes

        BinaryTree<String> g = new BinaryTree<String>("Is it mighty munch?!");               // start by creating
        BinaryTree<String> h = new BinaryTree<String>("Is it rice crispies?");               // leaf nodes
        BinaryTree<String> i = new BinaryTree<String>("Is it a brand of chips?", g, h);      // join the leaf nodes by their parent nodes

        BinaryTree<String> j = new BinaryTree<String>("Is it pepsi?");                       // start by creating
        BinaryTree<String> k = new BinaryTree<String>("Is it an appetiser?");                // leaf nodes
        BinaryTree<String> l = new BinaryTree<String>("Are you thinking of a drink?", j, k); // join the leaf nodes by their parent nodes

        BinaryTree<String> m = new BinaryTree<String>("Is it fast food?", c, f);             // join the parent nodes by their parent node
        BinaryTree<String> n = new BinaryTree<String>("Are you thinking of a snack?", i, l); // join the parent nodes by their parent node

        BinaryTree<String> o = new BinaryTree<String>("Are you thinking of a meal?", m,n);   // binary tree is now formed

        return o; // binary tree returned
    }    
}
