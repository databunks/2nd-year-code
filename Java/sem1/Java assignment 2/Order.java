import java.util.ArrayList;
public class Order 
{
   private ShoppingCart cart;
   private Customer customer;
   private Payment payment;
   private Address address;
   private ArrayList<Item> orderItems = new ArrayList<Item>();
   private int itemNo = 0;
   private int totalPrice;

//Constructor

    Order(ShoppingCart cusCart, Customer customer_, Payment cuspayment, Address cusAddress)
    {
      cart = cusCart;
      address = cusAddress;
      customer = customer_;
      payment = cuspayment;
      totalPrice = cart.getTotalPrice();
      
      
      for (int i = cart.getItemNo(); i >= 0; i--)
         {
           orderItems.add(cart.getItem(i));
           cart.removeItem(i);
           itemNo++;
         }
    }
    
//Getters

    public int getItemNo()
    {
      return itemNo;
    }

    public int getTotalPrice()
    {
      return totalPrice;
    }

    public ShoppingCart getShoppingCartObj()
    {
       return cart;
    }

    public Customer getCustomerObj()
    {
      return customer;
    }

    public Payment getPaymentObj()
    {
      return payment;
    }

    public Item getItemObj(int index)
    {
      return orderItems.get(index);
    }

    public Address getAddressObj()
    {
      return address;
    }  
    
}
