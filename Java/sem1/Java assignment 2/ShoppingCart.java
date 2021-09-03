import java.util.ArrayList;
public class ShoppingCart
{
  private long cartId;
  private ArrayList<Item> cart = new ArrayList<Item>();
  private int itemNo = 0;
  private int totalPrice = getTotalPrice();
  private boolean cartLock = false;
  private int month;
  private int year;
  private Customer customer_obj;


//Constructor
  ShoppingCart(Customer customer,int cusMonth, int cusYear)
  {
    cartId = customer.getCustomerId();
    customer_obj = customer;
    month = cusMonth;
    year = cusYear;
  }
//Mutators
  public void lockCart()
  {
    cartLock = true;
  }
  
  public void addItem(Item item)
  {
    if (cartLock == false)
    {
     cart.add(item);
     itemNo++;
    }
    else if (cartLock == true)
    {
      System.out.println("Cart is locked cant add anymore items");
    }
  }

  public void removeItem(int index)
  {
    
   if (cartLock == false)
   {
     cart.remove(index);
     itemNo--;
    
   }  else if (cartLock == true)
       {
         System.out.println("Cart is locked cant add anymore items");
       }
  }

//Getters

  public void printItems()
  {
    System.out.println("Shopping cart Items : ");
    System.out.println("");
    for (int i = 0; i < itemNo; i++)
    {
      System.out.println(cart.get(i));
    }
    System.out.println("");
  }

  public long getShoppingCartId()
  {
    return cartId;
  }

  public int getItemNo()
  {
    return itemNo - 1;
  }

  public Item getItem(int index)
  {
    return cart.get(index);
  }

  public int getTotalPrice()
  {
    Item cartItem;
    int total = 0;

    for (int i = 0; i < getItemNo() + 1; i++)
    {
      cartItem = cart.get(i);
      total += cartItem.getPrice();
    }
    
    return total;
  }

  public Customer getCustomerObj()
  {
    return customer_obj;
  }

  public int getMonth()
  {
    return month;
  }

  public int getYear()
  {
    return year;
  }

  
}