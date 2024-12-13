import java.util.ArrayList;
import java.util.Scanner;

public class WasteManagementSystem {
    private final ArrayList<WasteItem> wasteItems;

    public WasteManagementSystem() {
        this.wasteItems = new ArrayList<>();
    }

    public void analyzeWaste() {
        double totalWeight = 0.0;
        for (WasteItem item : this.wasteItems) {
            totalWeight += item.getWeight();
        }
        System.out.println("Total waste weight: " + totalWeight + " kg.");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Waste Management System ---");
            System.out.println("1. Add Waste");
            System.out.println("2. View Waste");
            System.out.println("3. Delete Waste");
            System.out.println("4. View Disposal Advice");
            System.out.println("5. Analyze Waste");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addWasteItem(scanner);
                case 2 -> viewWaste();
                case 3 -> deleteWaste(scanner);
                case 4 -> viewAdvice();
                case 5 -> analyzeWaste();
                case 6 -> {
                    System.out.println("Exiting system. Thank you!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void addWasteItem(Scanner scanner) {
        System.out.print("Enter waste name: ");
        String name = scanner.nextLine();
    
        System.out.print("Enter waste weight (kg): ");
        double weight = scanner.nextDouble();
        scanner.nextLine();
    
        System.out.println("Select waste category:");
        System.out.println("1. Recyclable");
        System.out.println("2. Non-Recyclable");
        System.out.println("3. Compostable");
        int category = scanner.nextInt();
    
        try {
            WasteItem item = WasteFactory.createWasteItem(category, name, weight);
            wasteItems.add(item);
            System.out.println("Waste item added successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void viewWaste() {
        if (wasteItems.isEmpty()) {
            System.out.println("No waste items recorded.");
            return;
        }

        System.out.println("\n--- Waste Items ---");
        for (int i = 0; i < wasteItems.size(); i++) {
            WasteItem item = wasteItems.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " - " + item.getWeight() + " kg - " + item.getClass().getSimpleName());
        }
    }

    private void deleteWaste(Scanner scanner) {
        if (wasteItems.isEmpty()) {
            System.out.println("No waste items to delete.");
            return;
        }

        viewWaste();
        System.out.print("Enter the number of the waste item to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 1 || index > wasteItems.size()) {
            System.out.println("Invalid choice. No item deleted.");
        } else {
            WasteItem removed = wasteItems.remove(index - 1);
            System.out.println("Removed: " + removed.getName() + " (" + removed.getClass().getSimpleName() + ")");
        }
    }

    private void viewAdvice() {
        System.out.println("\n--- Disposal Advice ---");
        if (wasteItems.isEmpty()) {
            System.out.println("No waste items recorded. Here are some general tips:");
        } else {
            for (WasteItem item : this.wasteItems) {
                System.out.println(item.getName() + ": " + item.disposalAdvice());
            }
        }

        System.out.println("\n--- General Tips ---");
        System.out.println("1. Reduce the use of single-use plastics by opting for reusable items.");
        System.out.println("2. Compost organic waste to reduce landfill contribution and create nutrient-rich soil.");
        System.out.println("3. Sort your waste into recyclable, compostable, and general waste bins.");
        System.out.println("4. Clean recyclables (like cans and bottles) before disposal to avoid contamination.");
        System.out.println("5. Safely dispose of hazardous materials (like batteries and chemicals) at designated facilities.");
    }

    public static void main(String[] args) {
        WasteManagementSystem system = new WasteManagementSystem();
        system.run();
    }
}

abstract class WasteItem {
    private final String name;
    private final double weight;

    public WasteItem(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public abstract String disposalAdvice();
}

class WasteFactory {
    public static WasteItem createWasteItem(int category, String name, double weight) {
        return switch (category) {
            case 1 -> new Recyclable(name, weight);
            case 2 -> new NonRecyclable(name, weight);
            case 3 -> new Compostable(name, weight);
            default -> throw new IllegalArgumentException("Invalid waste category.");
        };
    }
}

class Recyclable extends WasteItem {
    public Recyclable(String name, double weight) {
        super(name, weight);
    }

    @Override
    public String disposalAdvice() {
        return "Dispose in the recycle bin. Ensure it's clean.";
    }
}

class NonRecyclable extends WasteItem {
    public NonRecyclable(String name, double weight) {
        super(name, weight);
    }

    @Override
    public String disposalAdvice() {
        return "Dispose in the general waste bin.";
    }
}

class Compostable extends WasteItem {
    public Compostable(String name, double weight) {
        super(name, weight);
    }

    @Override
    public String disposalAdvice() {
        return "Add to the compost bin or organic waste pile.";
    }
}



