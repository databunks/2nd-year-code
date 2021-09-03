public class Customer
{
   private String customerFirstName;
   private String customerSurName;
   private String customerEmailAddress;
   private final long customerId;
   private static long customerIdCount = 1000000;
   
  
   


//Constructer

   public Customer(String cusFirstName, String cusSurName, String cusEmailAddress)
   {
       customerFirstName = cusFirstName;
       customerSurName = cusSurName;
       customerEmailAddress = cusEmailAddress;
       customerId = makeCustomerId();
   }

//Mutator

   public long makeCustomerId()
   {
       customerIdCount++;
       return customerIdCount;
   }

//Getters

   public long getCustomerId()
   {
       return customerId;

   }

   public String getFirstName()
   {
       return customerFirstName;
   }

   public String getSurName()
   {
       return customerSurName;
   }

   public String getCustomerEmailAddress()
   {
       return customerEmailAddress;
   }

}