package isep.eapli.demoorm.presentation;

import isep.eapli.demoorm.util.Console;

public class MainMenu {

	public static void mainLoop() {
		int option;
		do {
			option = menu();
			switch (option) {
				case 0 -> System.out.println("End of program.");
				case 1 -> {
					new CarGroupUI().registerCarGroup();
					Console.waitForKey("\nPress Enter to continue...");
				}
				case 2 -> {
					new CarGroupUI().listAllCarGroups();
					Console.waitForKey("\nPress Enter to continue...");
				}
				case 3 -> {
					new CarGroupUI().searchCarGroupById();
					Console.waitForKey("\nPress Enter to continue...");
				}
				case 4 -> {
					new CarGroupUI().searchCarGroupByName();
					Console.waitForKey("\nPress Enter to continue...");
				}
				case 5 -> {
					new CarGroupUI().searchCarGroupByClass();
					Console.waitForKey("\nPress Enter to continue...");
				}
				case 6 -> {
					new CarUI().registerCar();
					Console.waitForKey("\nPress Enter to continue...");
				}
				case 7 -> {
					new CarUI().listAllCars();
					Console.waitForKey("\nPress Enter to continue...");
				}
				case 8 -> {
					new CarUI().searchCarByLicensePlate();
					Console.waitForKey("\nPress Enter to continue...");
				}
				case 9 -> {
					new CarUI().searchCarByCarGroup();
					Console.waitForKey("\nPress Enter to continue...");
				}
				case 10 -> {
					new ClientUI().registerClient();
					Console.waitForKey("\nPress Enter to continue...");
				}
				case 11 -> {
					new ClientUI().listAllClients();
					Console.waitForKey("\nPress Enter to continue...");
				}
				case 12 -> {
					new RentalContractUI().registerRentalContract();
					Console.waitForKey("\nPress Enter to continue...");
				}
				case 13 -> {
					new RentalContractUI().listAllContracts();
					Console.waitForKey("\nPress Enter to continue...");
				}
				case 14 -> {
					new RentalContractUI().searchContractById();
					Console.waitForKey("\nPress Enter to continue...");
				}
				default -> System.out.println("Option not recognized.");
			}
		} while (option != 0);
	}

	private static int menu() {
		System.out.println("\n========================================");
		System.out.println("            Rent a Car");
		System.out.println("========================================");
		System.out.println("--- Car Groups ---");
		System.out.println(" 1. Register Car Group");
		System.out.println(" 2. List all Car Groups");
		System.out.println(" 3. Search Car Group by ID");
		System.out.println(" 4. Search Car Group by Name");
		System.out.println(" 5. Search Car Group by Class");
		System.out.println("--- Cars ---");
		System.out.println(" 6. Register Car");
		System.out.println(" 7. List all Cars");
		System.out.println(" 8. Search Car by License Plate");
		System.out.println(" 9. Search Cars by Car Group");
		System.out.println("--- Clients ---");
		System.out.println("10. Register Client");
		System.out.println("11. List all Clients");
		System.out.println("--- Rental Contracts ---");
		System.out.println("12. Register Rental Contract");
		System.out.println("13. List all Rental Contracts");
		System.out.println("14. Search Rental Contract by ID");
		System.out.println("========================================");
		System.out.println(" 0. Exit\n");
		return Console.readInteger("Please choose an option: ");
	}
}