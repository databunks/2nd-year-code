public class Item 
{
  
  private String itemName;
  private long itemId;
  private int itemPrice;
  
  //Constructor
  public Item(String nameItem, long idItem)
  {
    itemName = nameItem;
    itemId = idItem;
  }

//Mutators

  public void setPrice(int priceItem)
  {
    itemPrice = priceItem;
  }

  //Getters

  public int getPrice()
  {
    return itemPrice;
  }

  public long getItemId()
  {
     return itemId;
  }
  //Formatter
  @Override
  public String toString(){
    String out = "Item Id :" + itemId + "\t" + itemName + "\tPrice : " + itemPrice;
    return out;
  }
}
