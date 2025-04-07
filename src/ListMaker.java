import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean done = false;

        while (!done) {
            displayMenu();
            displayList(myList);

            String choice = SafeInput.getRegExString(scanner, "Enter your choice: ", "[AaDdIiPpQq]");

            switch (choice.toUpperCase()) {
                case "A":
                    addItem(scanner, myList);
                    break;
                case "D":
                    deleteItem(scanner, myList);
                    break;
                case "I":
                    insertItem(scanner, myList);
                    break;
                case "P":
                    displayList(myList);
                    break;
                case "Q":
                    done = confirmQuit(scanner);
                    break;
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nMenu Options:");
        System.out.println("A -- Add an item to the list");
        System.out.println("D -- Delete an item from the list");
        System.out.println("I -- Insert an item into the list");
        System.out.println("P -- Print the list");
        System.out.println("Q -- Quit the program");
    }

    private static void displayList(ArrayList<String> list) {
        System.out.println("\nCurrent List:");
        if (list.isEmpty()) {
            System.out.println("List is empty");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }
    }

    private static void addItem(Scanner scanner, ArrayList<String> list) {
        String item = SafeInput.getNonZeroLenString(scanner, "Enter item to add: ");
        list.add(item);
        System.out.println("Item added to the list.");
    }

    private static void deleteItem(Scanner scanner, ArrayList<String> list) {
        if (list.isEmpty()) {
            System.out.println("List is empty, nothing to delete");
        } else {
            displayList(list);
            int itemNum = SafeInput.getRangedInt(scanner, "Enter item number to delete: ", 1, list.size());
            list.remove(itemNum - 1);  // Adjust for 0-based index
            System.out.println("Item deleted from the list.");
        }
    }

    private static void insertItem(Scanner scanner, ArrayList<String> list) {
        String item = SafeInput.getNonZeroLenString(scanner, "Enter item to insert: ");

        if (list.isEmpty()) {
            list.add(item);
            System.out.println("Item added to the empty list.");
        } else {
            displayList(list);
            int position = SafeInput.getRangedInt(scanner, "Enter position to insert (1-" + (list.size()+1) + "): ", 1, list.size()+1);
            list.add(position - 1, item);  // Adjust for 0-based index
            System.out.println("Item inserted into the list.");
        }
    }

    private static boolean confirmQuit(Scanner scanner) {
        return SafeInput.getYNConfirm(scanner, "Are you sure you want to quit? (Y/N): ");
    }
}