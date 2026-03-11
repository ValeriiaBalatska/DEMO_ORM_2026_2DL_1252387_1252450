package isep.eapli.demoorm.presentation;

import isep.eapli.demoorm.application.CarService;
import isep.eapli.demoorm.application.ClientService;
import isep.eapli.demoorm.application.RentalContractService;
import isep.eapli.demoorm.domain.*;
import isep.eapli.demoorm.util.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RentalContractUI {

    public void registerRentalContract() {
        System.out.println("=== Register Rental Contract ===");

        // Select Car
        CarService carService = new CarService();
        List<Car> cars = carService.listAllCars();
        if (cars.isEmpty()) {
            System.out.println("No cars available. Please register a car first.");
            return;
        }
        System.out.println("Available Cars:");
        cars.forEach(System.out::println);
        String licensePlate = Console.readLine("Enter car license plate: ");
        Optional<Car> carOpt = carService.findCarByLicensePlate(licensePlate);
        if (carOpt.isEmpty()) {
            System.out.println("Car not found.");
            return;
        }

        // Select Client
        ClientService clientService = new ClientService();
        List<Client> clients = clientService.listAllClients();
        if (clients.isEmpty()) {
            System.out.println("No clients available. Please register a client first.");
            return;
        }
        System.out.println("\nAvailable Clients:");
        clients.forEach(System.out::println);
        long clientId = Console.readInteger("Enter client ID: ");
        Optional<Client> clientOpt = clientService.findClientById(clientId);
        if (clientOpt.isEmpty()) {
            System.out.println("Client not found.");
            return;
        }

        // Contract dates
        String startDate = Console.readLine("Start date (dd-MM-yyyy): ");
        String endDate = Console.readLine("End date (dd-MM-yyyy): ");

        // Register Authorized Drivers
        List<AuthorizedDriver> drivers = new ArrayList<>();
        System.out.println("\n--- Register Authorized Drivers ---");
        boolean addMore = true;
        while (addMore) {
            String dName = Console.readLine("Driver name: ");
            String dAddress = Console.readLine("Driver address: ");
            String dLicense = Console.readLine("License number: ");
            String dExpiry = Console.readLine("License expiry date (dd-MM-yyyy): ");
            drivers.add(new AuthorizedDriver(dName, dAddress, dLicense, dExpiry));
            addMore = Console.readBoolean("Add another driver? (y/n): ");
        }

        // Payment
        Payment payment = null;
        System.out.println("\n--- Payment ---");
        System.out.println("1. Credit Card");
        System.out.println("2. Check");
        System.out.println("0. No payment now");
        int payChoice = Console.readInteger("Choose payment type: ");
        if (payChoice == 1) {
            double amount = Console.readDouble("Amount: ");
            String payDate = Console.readLine("Payment date (dd-MM-yyyy): ");
            String cardNumber = Console.readLine("Card number: ");
            String cardHolder = Console.readLine("Card holder name: ");
            String cardExpiry = Console.readLine("Card expiry date: ");
            payment = new CreditPayment(amount, payDate, cardNumber, cardHolder, cardExpiry);
        } else if (payChoice == 2) {
            double amount = Console.readDouble("Amount: ");
            String payDate = Console.readLine("Payment date (dd-MM-yyyy): ");
            String checkNumber = Console.readLine("Check number: ");
            String bankName = Console.readLine("Bank name: ");
            payment = new CheckPayment(amount, payDate, checkNumber, bankName);
        }

        try {
            RentalContractService service = new RentalContractService();
            RentalContract contract = service.registerRentalContract(
                    startDate, endDate, carOpt.get(), clientOpt.get(), drivers, payment);
            System.out.println("Contract registered:\n" + contract);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void listAllContracts() {
        System.out.println("=== All Rental Contracts ===");
        try {
            RentalContractService service = new RentalContractService();
            List<RentalContract> contracts = service.listAllContracts();
            if (contracts.isEmpty()) {
                System.out.println("No rental contracts registered.");
            } else {
                contracts.forEach(c -> System.out.println(c + "\n"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void searchContractById() {
        System.out.println("=== Search Rental Contract by ID ===");
        long id = Console.readInteger("Enter contract ID: ");
        try {
            RentalContractService service = new RentalContractService();
            service.findContractById(id)
                    .ifPresentOrElse(
                            c -> System.out.println("Found:\n" + c),
                            () -> System.out.println("No contract found with ID " + id)
                    );
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
