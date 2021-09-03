public class Address 
{
  private String street;
  private String city;
  private String country;
  private String postCode;

    Address(String cusStreet, String cusCity, String cusCountry, String cusPostCode)
     {
       street = cusStreet;
       city = cusCity;
       country = cusCountry;
       postCode = cusPostCode;
     }
     
    public String getStreet()
    {
      return street;
    }

    public String getCity()
    {
      return city;
    }

    public String getCountry()
    {
      return country;
    }

    public String getPostCode()
    {
      return postCode;
    }
  
}
