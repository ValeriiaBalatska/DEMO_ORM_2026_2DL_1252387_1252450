package isep.eapli.demoorm.presentation;

import isep.eapli.demoorm.util.Console;

public class MainMenu {
	public static void mainLoop() {
		int option = 0;
		do {
			option = menu();
			switch (option) {
				case 0:
					System.out.println("End of program.");
					break;
				case 1:
					new CarGroupUI().registerCarGroup();
					Console.waitForKey("\nPress Enter to continue...");
					break;
				case 2:
					System.out.println("Not yet implemented - List all Car Groups.");
					break;
				default:
					System.out.println("Option not recognized.");
					break;
			}
		} while (option != 0);
	}

	private static int menu() {
		int option = -1;
		System.out.println("");
		System.out.println("=============================");
		System.out.println("     Rent a Car ");
		System.out.println("=============================\n");
		System.out.println("1. Register Car Group");
		System.out.println("2. List all Car Groups");
		System.out.println("=============================");
		System.out.println("0. Exit\n\n");
		option = Console.readInteger("Please choose an option: ");
		return option;
	}
}
