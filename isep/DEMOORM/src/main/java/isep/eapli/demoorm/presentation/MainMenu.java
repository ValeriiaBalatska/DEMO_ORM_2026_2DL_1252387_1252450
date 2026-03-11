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
				default -> System.out.println("Option not recognized.");
			}
		} while (option != 0);
	}

	private static int menu() {
		System.out.println("\n=============================");
		System.out.println("        Rent a Car");
		System.out.println("=============================");
		System.out.println("1. Register Car Group");
		System.out.println("2. List all Car Groups");
		System.out.println("3. Search Car Group by ID");
		System.out.println("=============================");
		System.out.println("0. Exit\n");
		return Console.readInteger("Please choose an option: ");
	}
}