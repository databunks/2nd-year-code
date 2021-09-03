
import java.awt.Graphics;
import java.awt.Image;
import java.util.*;

public class BadGuy {
	
	Image myImage;
	int x=0,y=0;
	boolean hasPath=false;
	Stack<Node> path = new Stack<Node>();

	public BadGuy( Image i ) {
		myImage=i;
		x = 30;
		y = 10;
	}
	
	public void reCalcPath(boolean map[][],int targx, int targy) 
	{
		// TO DO: calculate A* path to targx,targy, taking account of walls defined in map[][]
		hasPath = false; // initialize path
		LinkedList<Node> openList = new LinkedList<Node>();
		LinkedList<Node> closedList = new LinkedList<Node>();
		Iterator<Node> i;
		Node min,currentValue; // used for finding lowest f cost
		while(!path.empty()) 
		{
			path.pop(); // pop everything from stack upon recalculation
		}
		Node current = new Node(x,y);
		current.parent = null; // starting node has no parent
		current.g = 0; // g is 0 as it is the starting node                                
		current.h = Math.max(Math.abs(current.x - targx), Math.abs(current.y - targy)); // using a cheap heuristic to get the h cost
		current.f = current.h + current.g; // f cost calculated

		openList.add(current); // starting node added

		while (true)
		{
		    i = openList.iterator();
			min = i.next();
			while(i.hasNext()) // finds lowest f cost
			{
				currentValue = i.next();
				if(min.f > currentValue.f){
					min = currentValue; // node with lowest f cost stored in min
				}
			}
					current = min; // set the current node to the node with lowest f cost
					for (int xx = -1; xx <= 1; xx++)
					{
						for (int yy = -1; yy <= 1; yy++)
						{
							if (xx != 0 || yy != 0) // for  each of the neighbours
							{
								if (((current.x + xx < 40 && current.y + yy < 40) && (current.x + xx > -1 && current.y + yy > -1)) && (!map[current.x + xx][current.y + yy])) // check conditions that break the code
								{
									Node neighbour = new Node(0,0); // declare neighbour
									neighbour.x = current.x + xx; // set xPos
									neighbour.y = current.y + yy; // set yPos

									boolean openListCheck = true; 
									i = openList.iterator();
									currentValue = i.next();
									while (i.hasNext()) // check if it is in openList
									{
										if (neighbour.x == currentValue.x && neighbour.y == currentValue.y) 
										{
											openListCheck = false; // set check to false if match found
											break;
										}
										currentValue = i.next();
									}

									boolean closedListCheck = true; 
									i = closedList.iterator();
									if(i.hasNext()) currentValue = i.next(); // check if it is in closed list
									while (i.hasNext())
									{
										if (neighbour.x == currentValue.x && neighbour.y == currentValue.y) 
										{
											closedListCheck = false; // set check to false if match found
											break;
										}
										currentValue = i.next();
									}

									if (closedListCheck && openListCheck) // if neighbour is not in either
								    {									
										neighbour.parent = current; // set the parent to the current
										neighbour.h = (int)Math.max(Math.abs(neighbour.x - targx) , Math.abs(neighbour.y - targy)); // calculate the h cost using cheap heuristic
										if ((xx == -1 && yy == -1) || (xx == -1 && yy == 1) || (xx == 1 && yy == 1) || (xx == -1 && yy == 1)) neighbour.g = neighbour.parent.g + 14; // if it is a diagnol cost is 14
										else neighbour.g = neighbour.parent.g + 10; // g cost is set as 10 in cardinal directions
										neighbour.f = neighbour.g + neighbour.h; // f cost is set
										openList.add(neighbour); // neighbour added to open list
									} 
								}
							}
						}
					}
					closedList.add(current); // current added to closed list
					openList.remove(current); // current removed from open list
					
				
			

			if (current.h == 0) // if target is found
			{
				hasPath = true; // path is found
				break;
			}
			else if (openList.size() == 0) // if open list is empty
			{
				hasPath = false; // no path found
				break;
			}

		}
		Node lastNode = closedList.get(closedList.size() - 1); // get the last node
		path.push(lastNode);
		do // trace its parents and push them to stack
		{
			path.push(path.peek().parent);
			if (path.peek() == null) break; // check for null cases
		} while (path.peek().parent != null); //
	}
	
	public void move(boolean map[][],int targx, int targy) {
		if (hasPath) 
		{
			// TO DO: follow A* path, if we have one defined
			if (!path.empty())
			{
				Node peek = path.pop(); // stores top of stack and pops it
				if (peek != null) // checks if null
				{
					x = peek.x; // sets x of bad guy
					y = peek.y; // sets y of bad guy
				}
			}
		}
		else {
			// no path known, so just do a dumb 'run towards' behaviour
			int newx=x, newy=y;
			if (targx<x)
				newx--;
			else if (targx>x)
				newx++;
			if (targy<y)
				newy--;
			else if (targy>y)
				newy++;
			if (!map[newx][newy]) {
				x=newx;
				y=newy;
			}
		}
	}
	
	public void paint(Graphics g) {
		g.drawImage(myImage, x*20, y*20, null);
	}
	
}

