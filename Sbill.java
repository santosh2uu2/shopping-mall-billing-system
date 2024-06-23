package projectsdn;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

class Item
{
    private String name;
    private double price;

    public Item(String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }
    
    public void display()   
    {  
        System.out.format("   %-9s                                  %9.2f                         \n" , name, price);  
    }  
}

public class Sbill
{
    public static void main(String[] args) 
    {
    	
        LinkedList<Item> items = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        
        while (true)
        {
            System.out.println("Options:");
            System.out.println("1. Add item to the bill");
            System.out.println("2. Remove item from the bill");
            System.out.println("3. Display bill");
            System.out.println("4. Exit");
            System.out.print("Enter option number: ");
            int option = scanner.nextInt();
            scanner.nextLine(); 
            switch (option)
            {
                case 1:
                    addItemToBill(items, scanner);
                    break;
                case 2:
                    removeItemFromBill(items, scanner);
                    break;
                case 3:
                    displayBill(items);
                    break;
                case 4:
                    System.out.println("Thank you for shopping!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addItemToBill(LinkedList<Item> items, Scanner scanner)
    {
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter item price: ");
        double itemPrice = scanner.nextDouble();
        scanner.nextLine(); 

        Item item = new Item(itemName, itemPrice);
        items.add(item);

        System.out.println(itemName + " - rs" + itemPrice + " added to the bill.");
    }

    private static void removeItemFromBill(LinkedList<Item> items, Scanner scanner)
    {
        System.out.print("Enter item name to remove: ");
        String itemName = scanner.nextLine();

        boolean removed = false;
        for (Item item : items)
        {
            if (item.getName().equalsIgnoreCase(itemName)) 
            {
                items.remove(item);
                System.out.println(itemName + " removed from the bill.");
                removed = true;
                break;
            }
        }
        
        if (!removed) 
        {
            System.out.println(itemName + " not found in the bill.");
        }
    }
    
    private static void displayBill(LinkedList<Item> items)
    {
        if (items.isEmpty())
        {
            System.out.println("No items in the bill.");
            return;
        }

        double totalAmount = 0.0;
        System.out.println("\t\t\t\t--------------------Invoice-----------------");  
        System.out.println("\t\t\t\t\t "+"  "+"      SRKR SHOPPING MALL");  
        System.out.println("\t\t\t\t\t 3/98 CHINNAMIRAM BHIMAVARAM");  
        System.out.println("\t\t\t\t\t"  +"    " +" Opposite red bucket ");  
        System.out.println("GSTIN: 03AWBP8L4Q6Q1"+"\t\t\t\t\t\t\tContact: (+91) 7995580525");  
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");    
        Date date = new Date();    
        Calendar calendar = Calendar.getInstance();  
        String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };  
        System.out.println("Date: "+formatter.format(date)+"  "+days[calendar.get(Calendar.DAY_OF_WEEK) - 1]+"\t\t\t\t\t\t (+91) 9963845715");  
        System.out.println("-------------------------------|----------------------------|");
        System.out.println("product name                   |              amount        | ");
        System.out.println("-------------------------------|----------------------------|");
        for (Item item : items)
        {
            System.out.println(item.getName() + "                              |                     "          + item.getPrice() +"    |");
            totalAmount += item.getPrice();
        }
        System.out.println("-------------------------------|----------------------------|");
        System.out.println("                                                             Total Bill: Rupees" + totalAmount);
        System.out.println("\n\t\t\t\t\t\t\t\t\t\tTotal AMOUNT(Rs.) " +totalAmount); 
        
        float discount = (float) (totalAmount*2/100);  
        
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t    DISCOUNT (Rs.) " +discount);   
        
        float subtotal = (float) (totalAmount-discount);   
        
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t          SUBTOTAL "+subtotal);    
        
        float sgst=(float) (totalAmount*12/100);  
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t          SGST (%) "+sgst);  
        float cgst=(float) (totalAmount*12/100);  
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t          CGST (%) "+cgst);  
        System.out.println("\t\t\t\t--------------------------------------------------------------------");  
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t     invoice total " +(subtotal+cgst+sgst));  
       
        System.out.println("\t\t\t\t--------------------------------------------------------------------                    ");   
        
    }
}
