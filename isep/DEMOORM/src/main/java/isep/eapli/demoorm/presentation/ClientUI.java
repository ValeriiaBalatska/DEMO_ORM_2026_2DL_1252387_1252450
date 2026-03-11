package isep.eapli.demoorm.presentation;

import isep.eapli.demoorm.application.ClientService;
import isep.eapli.demoorm.domain.Client;
import isep.eapli.demoorm.util.Console;
import java.util.List;

public class ClientUI {

    public void registerClient() {
        System.out.println("=== Register New Client ===");
        System.out.println("1. Corporate Client");
        System.out.println("2. Individual Client");
        int type = Console.readInteger("Choose type: ");

        String name = Console.readLine("Name: ");
        String address = Console.readLine("Address: ");
        String phone = Console.readLine("Phone number: ");
        String email = Console.readLine("Email: ");
        String remarks = Console.readLine("Remarks: ");

        try {
            ClientService service = new ClientService();
            Client client;
            if (type == 1) {
                String companyName = Console.readLine("Company name: ");
                String taxId = Console.readLine("Tax ID: ");
                client = service.registerCorporateClient(name, address, phone, email, remarks, companyName, taxId);
            } else {
                String citizenId = Console.readLine("Citizen ID: ");
                String dob = Console.readLine("Date of birth (dd-MM-yyyy): ");
                client = service.registerIndividualClient(name, address, phone, email, remarks, citizenId, dob);
            }
            System.out.println("Client registered: " + client);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void listAllClients() {
        System.out.println("=== All Clients ===");
        try {
            ClientService service = new ClientService();
            List<Client> clients = service.listAllClients();
            if (clients.isEmpty()) {
                System.out.println("No clients registered.");
            } else {
                clients.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
