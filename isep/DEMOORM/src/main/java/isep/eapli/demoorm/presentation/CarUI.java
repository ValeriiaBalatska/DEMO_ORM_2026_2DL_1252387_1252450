package isep.eapli.demoorm.presentation;

import isep.eapli.demoorm.application.CarService;
import isep.eapli.demoorm.application.CarGroupService;
import isep.eapli.demoorm.domain.Car;
import isep.eapli.demoorm.domain.CarGroup;
import isep.eapli.demoorm.util.Console;
import java.util.List;
import java.util.Optional;

public class CarUI {

    public void registerCar() {
        System.out.println("=== Register New Car ===");

        CarGroupService carGroupService = new CarGroupService();
        List<CarGroup> groups = carGroupService.listAllCarGroups();
        if (groups.isEmpty()) {
            System.out.println("No car groups available. Please register a car group first.");
            return;
        }

        System.out.println("Available Car Groups:");
        groups.forEach(System.out::println);

        long groupId = Console.readInteger("Enter Car Group ID: ");
        Optional<CarGroup> carGroupOpt = carGroupService.findCarGroupById(groupId);
        if (carGroupOpt.isEmpty()) {
            System.out.println("Car group not found.");
            return;
        }

        String licensePlate = Console.readLine("License plate: ");
        int manufactureYear = Console.readInteger("Year of manufacture: ");
        int acquisitionYear = Console.readInteger("Year of acquisition: ");
        String color = Console.readLine("Color: ");
        int engineDisplacement = Console.readInteger("Engine displacement (cc): ");

        try {
            CarService carService = new CarService();
            Car car = carService.registerNewCar(licensePlate, manufactureYear, acquisitionYear,
                    color, engineDisplacement, carGroupOpt.get());
            System.out.println("Car registered: " + car);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void listAllCars() {
        System.out.println("=== All Cars ===");
        try {
            CarService carService = new CarService();
            List<Car> cars = carService.listAllCars();
            if (cars.isEmpty()) {
                System.out.println("No cars registered.");
            } else {
                cars.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void searchCarByLicensePlate() {
        System.out.println("=== Search Car by License Plate ===");
        String licensePlate = Console.readLine("Enter license plate: ");
        try {
            CarService carService = new CarService();
            carService.findCarByLicensePlate(licensePlate)
                    .ifPresentOrElse(
                            car -> System.out.println("Found: " + car),
                            () -> System.out.println("No car found with license plate " + licensePlate)
                    );
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void searchCarByCarGroup() {
        System.out.println("=== Search Cars by Car Group ===");

        CarGroupService carGroupService = new CarGroupService();
        List<CarGroup> groups = carGroupService.listAllCarGroups();
        groups.forEach(System.out::println);

        long groupId = Console.readInteger("Enter Car Group ID: ");
        Optional<CarGroup> carGroupOpt = carGroupService.findCarGroupById(groupId);
        if (carGroupOpt.isEmpty()) {
            System.out.println("Car group not found.");
            return;
        }

        try {
            CarService carService = new CarService();
            List<Car> cars = carService.findCarsByCarGroup(carGroupOpt.get());
            if (cars.isEmpty()) {
                System.out.println("No cars found in this group.");
            } else {
                cars.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
