package isep.eapli.demoorm.presentation;

import isep.eapli.demoorm.application.CarGroupService;
import isep.eapli.demoorm.domain.CarClass;
import isep.eapli.demoorm.domain.CarGroup;
import isep.eapli.demoorm.util.Console;
import java.util.List;

public class CarGroupUI {

    public void registerCarGroup() {
        System.out.println("=== Register New Car Group ===");
        String name = Console.readLine("Group name: ");
        int doors = Console.readInteger("Number of doors: ");
        double price = Console.readDouble("Price per day: ");
        System.out.println("Classes: 1-UTILITY  2-LUXURY  3-COMMERCIAL");
        int choice = Console.readInteger("Choose class: ");
        CarClass carClass = switch (choice) {
            case 2 -> CarClass.LUXURY;
            case 3 -> CarClass.COMMERCIAL;
            default -> CarClass.UTILITY;
        };
        try {
            CarGroupService service = new CarGroupService();
            CarGroup cg = service.registerNewCarGroup(name, doors, price, carClass);
            System.out.println("Group created: " + cg);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void listAllCarGroups() {
        System.out.println("=== All Car Groups ===");
        try {
            CarGroupService service = new CarGroupService();
            List<CarGroup> groups = service.listAllCarGroups();
            if (groups.isEmpty()) {
                System.out.println("No car groups registered.");
            } else {
                groups.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void searchCarGroupById() {
        System.out.println("=== Search Car Group by ID ===");
        long id = Console.readInteger("Enter ID: ");
        try {
            CarGroupService service = new CarGroupService();
            service.findCarGroupById(id)
                    .ifPresentOrElse(
                            cg -> System.out.println("Found: " + cg),
                            () -> System.out.println("No car group found with ID " + id)
                    );
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void searchCarGroupByName() {
        System.out.println("=== Search Car Group by Name ===");
        String name = Console.readLine("Enter name: ");
        try {
            CarGroupService service = new CarGroupService();
            List<CarGroup> groups = service.findCarGroupsByName(name);
            if (groups.isEmpty()) {
                System.out.println("No car groups found with name: " + name);
            } else {
                groups.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void searchCarGroupByClass() {
        System.out.println("=== Search Car Group by Class ===");
        System.out.println("Classes: 1-UTILITY  2-LUXURY  3-COMMERCIAL");
        int choice = Console.readInteger("Choose class: ");
        CarClass carClass = switch (choice) {
            case 2 -> CarClass.LUXURY;
            case 3 -> CarClass.COMMERCIAL;
            default -> CarClass.UTILITY;
        };
        try {
            CarGroupService service = new CarGroupService();
            List<CarGroup> groups = service.findCarGroupsByClass(carClass);
            if (groups.isEmpty()) {
                System.out.println("No car groups found for class: " + carClass);
            } else {
                groups.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}