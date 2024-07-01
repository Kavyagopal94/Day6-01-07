import java.util.Scanner;

public class VendingMachine 
{
    private Product[] products;
    private double currentBalance;

    public VendingMachine(Product[] products)
    {
        this.products = products;
        this.currentBalance = 0.0;
    }

    public void displayProducts() 
    {
        System.out.println("Products available:");
        System.out.println("====================");
        for (int i = 0; i < products.length; i++)
        {
            Product product = products[i];
            System.out.println((i + 1) + ". " + product.getName() + " - Rs" + product.getPrice() + " (" + product.getQuantity() + " available)");
        }
        System.out.println();
    }

    public void insertCoin(double amount) 
    {
        if (amount > 0) 
        {
            currentBalance += amount;
            System.out.println("Current balance: Rs" + currentBalance);
        } 
        else 
        {
            System.out.println("Invalid coin amount.");
        }
    }

    public void selectProduct(int productNumber) 
    {
        if (productNumber < 1 || productNumber > products.length) 
        {
            System.out.println("Invalid product selection.");
            return;
        }

        Product selectedProduct = products[productNumber - 1];

        if (selectedProduct.getQuantity() == 0) 
        {
            System.out.println("Sorry, the product is out of stock.");
            return;
        }

        if (currentBalance >= selectedProduct.getPrice()) 
        {
            selectedProduct.dispense();
            currentBalance -= selectedProduct.getPrice();
            System.out.println("Dispensing " + selectedProduct.getName());
            System.out.println("Remaining balance: Rs" + currentBalance);
        } 
        else
        {
            System.out.println("Insufficient funds. Please insert more coins.");
        }
    }

    public void returnChange()
    {
        if (currentBalance > 0) 
        {
            System.out.println("Returning change: Rs" + currentBalance);
            currentBalance = 0.0;
        } 
        else
        {
            System.out.println("No balance to return.");
        }
    }

    public static void main(String[] args)
    {
        Product[] products = 
        	{
            new Product("CoolDrink", 35.00, 10),
            new Product("Chips", 10.00, 5),
            new Product("Candy", 5.00, 20),
            new Product("Cookies",40.00,15)
        };

        VendingMachine vendingMachine = new VendingMachine(products);
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            vendingMachine.displayProducts();
            System.out.println("1. Insert coin");
            System.out.println("2. Select product");
            System.out.println("3. Return change");
            System.out.println("4. Exit");
            System.out.println();
            System.out.println("Choose an option: ");
            System.out.println("------------------");
            
            System.out.println();
            
            int choice = scanner.nextInt();

            switch (choice) 
            {
                case 1:
                    System.out.print("Enter coin amount: ");
                    double amount = scanner.nextDouble();
                    vendingMachine.insertCoin(amount);
                    break;
                    
                case 2:
                    System.out.print("Enter product number: ");
                    int productNumber = scanner.nextInt();
                    vendingMachine.selectProduct(productNumber);
                    break;
                    
                case 3:
                    vendingMachine.returnChange();
                    break;
                    
                case 4:
                    vendingMachine.returnChange();
                    System.out.println("Thank you for using the vending machine.");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
            System.out.println();
        }
    }
}

