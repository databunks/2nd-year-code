public class Payment 
{
    private String customer;
    private String creditCardType;
    private long creditCardNumber;
    private int month;
    private int year;
    private String creditCardBankName;
    private String billingStreetAddress;
    private String billingCity;
    private String billingPostCode;
    private String billingCountry;
    private boolean validPayment = true;

    private ShoppingCart cart;

//Constructor

    Payment(ShoppingCart cusCart ,String customerName, String cusCreditCardType, long cusCreditcardNumber, int cusMonth,int cusYear, String cusCreditCardBankName, String cusBillingStreetAddress,String cusBillingCity,String cusBillingCountry,String cusBillingPostCode)
    { 
      cart = cusCart;
      customer = customerName;
      creditCardType = cusCreditCardType;
      month = cusMonth;
      year = cusYear;
      creditCardBankName = cusCreditCardBankName;
      billingStreetAddress = cusBillingStreetAddress;
      billingCountry = cusBillingCountry;
      billingPostCode = cusBillingPostCode;
      billingCity = cusBillingCity;
      creditCardNumber = cusCreditcardNumber;

      if (creditCardNumber < 10000000 || creditCardNumber > 99999999)
      {
        System.out.println("Credit card Number is invalid");
        validPayment = false;
      }
      else if (!creditCardType.toUpperCase().equals("VISA") && !creditCardType.toUpperCase().equals("MASTERCARD"))
            {
              System.out.println("Credit card type is invalid");
              validPayment = false;
            }
      else if (year < cart.getYear())
          {
            System.out.println("Credit card has expired, Payment cancelled");
            validPayment = false;
          }
    else if (year == cart.getYear())
         {
           if (month <= cart.getMonth())
           {
             System.out.println("Credit card has expired, Payment cancelled");
             validPayment = false;
           }
             
         }
    }

//Getters

    public boolean getValidPayment()
    {
      return validPayment;
    }

    public String getBillingStreetAddress()
    {
      return billingStreetAddress;
    }

    public String getBillingCountry()
    {
      return billingCountry;
    }

    public String getBillingPostCode()
    {
      return billingPostCode;
    }

    public String getBillingCity()
    {
      return billingCity;
    }

    
}
