import java.util.Scanner;

public class InventoryManagementMain {
    public static void main(String[] args) {
        InventoryManagement inventoryManagement = new InventoryManagement();
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter an item and its quantity you want to store. Enter \"EXIT\" to stop.");
        String input = myScanner.next();
        while (!input.equals("EXIT")) {
            int value = myScanner.nextInt();
            inventoryManagement.addItem(input, value);
            input = myScanner.next();
        }
        System.out.println("What item do you want to know the quantity of?");
        input = myScanner.next();
        while (!input.equals("EXIT")) {
            if (inventoryManagement.containsItem(input)) {
                System.out.println(input + " : " + inventoryManagement.getItemCount(input));
            } else {
                System.out.println("Sorry, \"" + input + "\" is not in our inventory.");
            }
            input = myScanner.next();
        }
        myScanner.close();
    }
}
