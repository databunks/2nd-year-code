/** M Madden, Nov 2005: Array implementation of Stack ADT  */


public class ArrayStack 
{
   protected int capacity; 			// The actual capacity of the stack array
   protected static final int CAPACITY = 1000;	// default array capacity
   protected Object s[];			// array used to implement the stack 
   protected int top = -1;			// index for the top of the stack
   
   public ArrayStack() 
   {
	   // default constructor: creates stack with default capacity
	   this(CAPACITY);
   }

   public ArrayStack(int cap) 
   {
	  // this constructor allows you to specify capacity of stack
	  capacity = (cap > 0) ? cap : CAPACITY;
	  s = new Object[capacity]; 
   }
   
   public void push(Object element) 
   {
	 if (isFull()) 
	 {
	   System.out.println("ERROR: Stack is full.");
	   return;
	 }
	 top++;
	 s[top] = element;
   }

   public Object pop() {
	  Object element;
	  if (isEmpty()) 
	  {
	     System.out.println("ERROR: Stack is empty.");
	     return  null;
	  }
	  element = s[top];
	  s[top] = null;
	  top--;
	  return element;
   }

   public Object top() 
   {
	 if (this.isEmpty()) 
	 {
		 System.out.println("Stack empty bro");
		 return null;
	 }
	 return s[top];
   }
	   
   public boolean isEmpty() {
		  return (top < 0);
   }

   public boolean isFull() {
		  return (top == capacity-1);
   }

   public int size() { 
		 return (top + 1);
   }
 }