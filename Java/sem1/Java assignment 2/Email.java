public class Email 
{
    private Order order;
    private String email;
  
//Constructor

    Email(Order cusOrder)
    {
      order = cusOrder;
      email = order.getCustomerObj().getCustomerEmailAddress();

      if (email != null && email.contains("@") && email.contains(".") && order.getPaymentObj().getValidPayment() == true)
        {
          printEmail();
        }
      else
       {
         if(order.getPaymentObj().getValidPayment() == true)
         {
          System.out.println("Email is not valid, Enter in a valid email");
         }
         
       }
    }
//Getter
    public void printEmail()
    {
      System.out.println("To : " + order.getCustomerObj().getCustomerEmailAddress());
      System.out.println("Order details : ");
      System.out.println("First Name : " + order.getCustomerObj().getFirstName());
      System.out.println("Last Name : " + order.getCustomerObj().getSurName());
      System.out.println("Customer Id : " + order.getCustomerObj().getCustomerId());
      System.out.println("Shopping Cart Id : " + order.getShoppingCartObj().getShoppingCartId());
      System.out.println("");
      System.out.println("Items in Order list : ");

      for (int i = 0; i < order.getItemNo(); i++)
         {
           System.out.println(order.getItemObj(i));
         }
         System.out.println("");   
      System.out.println("Total price : " + order.getTotalPrice());
      System.out.println("Delivery address :");
      System.out.println("Street Name : " + order.getAddressObj().getStreet());
      System.out.println("City Name : " + order.getAddressObj().getCity());
      System.out.println("Country Name : " + order.getAddressObj().getCountry());
      System.out.println("PostCode : " + order.getAddressObj().getPostCode());
      System.out.println("");
      System.out.println("Billing address :");
      System.out.println("Street address : " + order.getPaymentObj().getBillingStreetAddress());
      System.out.println("City Name: " + order.getPaymentObj().getBillingCity());
      System.out.println("Country name : " + order.getPaymentObj().getBillingCountry());
      System.out.println("Post code : " + order.getPaymentObj().getBillingPostCode());

    }
}
