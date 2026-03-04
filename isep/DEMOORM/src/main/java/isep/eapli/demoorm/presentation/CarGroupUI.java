package isep.eapli.demoorm.presentation;

import isep.eapli.demoorm.application.CarGroupService;
import isep.eapli.demoorm.domain.CarGroup;
import isep.eapli.demoorm.util.Console;

public class CarGroupUI {
    public void registerCarGroup() {
        System.out.println("=== Register New Car Group ===");
        String name = Console.readLine("Group name: ");
        String description = Console.readLine("Description (optional): ");
        try {
            CarGroupService service = new CarGroupService();
            CarGroup cg = service.registerNewCarGroup(name, description);
            System.out.println("✅ Group created: " + cg);
            service.close();
        } catch (Exception e) {
            System.out.println("❌ Error registering: " + e.getMessage());
        }
    }
}

