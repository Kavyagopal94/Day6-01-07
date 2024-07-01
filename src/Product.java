public class Product
{
	private String name;
	private double price;
	private int quantity;
	
	public Product(String name, double price, int quantity) 
	{
    	this.name = name;
	    this.price = price;
	    this.quantity = quantity;
    }
	
	public String getName() 
	{
		return name;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}
	
	public void dispense() {
        if (quantity > 0) {
            quantity--;
        } else {
            System.out.println("Sorry, the product is out of stock.");
        }
    }
	
}
