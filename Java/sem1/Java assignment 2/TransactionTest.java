public class TransactionTest 
{
    
    public static void main(String[] args)
    {
        TransactionTest test = new TransactionTest(); //Transaction object
        test.transaction1(); //Scenario 1
        test.transaction2(); //Scenario 2
    }

    public void transaction1()
    { 
       
        Customer customer = new Customer("Bilbo","Swaggins" ,"FortniteEnthusiast@gmail.com"); // Customer cart object
        ShoppingCart customerShoppingCart = new ShoppingCart(customer,5,2020); //Shopping cart object

        Item item1 = new Item("Fortnite", 123432344); // Item object
        item1.setPrice(120); //Set price
        customerShoppingCart.addItem(item1); // add item to cart

        Item item2 = new Item("Toothbrush", 123432345);
        item2.setPrice(400);
        customerShoppingCart.addItem(item2);

        Item item3 = new Item("Eraser", 123432348);
        item3.setPrice(360);
        customerShoppingCart.addItem(item3);

        customerShoppingCart.printItems();

        Payment payment = new Payment(customerShoppingCart,customerShoppingCart.getCustomerObj().getFirstName() + " "  + customerShoppingCart.getCustomerObj().getSurName(),"Visa", 26671233,6,2020,"Bank of Ireland" , "2 Fortnite road", "Galway","Ireland","E420 42039"); //Payment object
        Address address = new Address("12 Green street","Galway","Ireland","E42069"); // Address object
        Order order = new Order(customerShoppingCart, customerShoppingCart.getCustomerObj(),payment,address); //Order Placed
        customerShoppingCart.lockCart(); // Cart locked
        Email email = new Email(order); // Email object
    
        
        
    }

    public void transaction2()
    {
        Customer customer = new Customer("Jimbob mcFortnite","dudebro420","damndaniel@gmail.com");
        ShoppingCart customerShoppingCart = new ShoppingCart(customer,4,2020);
        Item item1 = new Item("Black ops", 123432344);
        item1.setPrice(120);
        customerShoppingCart.addItem(item1);

        Item item2 = new Item("Pencil", 123432345);
        item2.setPrice(400);
        customerShoppingCart.addItem(item2);

        Item item3 = new Item("Eraser", 123432348);
        item3.setPrice(360);
        customerShoppingCart.addItem(item3);

        customerShoppingCart.printItems();

        customerShoppingCart.removeItem(0); // Item removed by customer

        Payment payment = new Payment(customerShoppingCart,customerShoppingCart.getCustomerObj().getFirstName() + " "  + customerShoppingCart.getCustomerObj().getSurName(),"Visa", 26671233,5,2020,"Bank of Ireland" , "2 Fortnite road", "Galway","Ireland","E420 42039");
        Address address = new Address("12 Tobuscus avenue","Galway","Ireland","E42039");
        Order order = new Order(customerShoppingCart, customerShoppingCart.getCustomerObj(),payment,address);
        customerShoppingCart.lockCart();
        
        Email email = new Email(order);

    }

    //Getters


}
