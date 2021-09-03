
public class Node 
{
    int g,h,f,x,y; // variables for node such as g,h,f costs and x,y coords of node
    Node parent; // parent of node (what it points to)
    public Node(int xPos, int yPos) // initialize variables in constructor
    {
        x = xPos;
        y = yPos;
        f = g = h = 0;
    }


}
