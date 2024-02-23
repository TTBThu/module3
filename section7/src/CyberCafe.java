import java.util.ArrayList;
import java.util.List;

public class CyberCafe {
    private List<Computer> computers;
    private List<Service> services;

    public CyberCafe(int numComputers) {
        computers = new ArrayList<>();
        for (int i = 1; i <= numComputers; i++) {
            computers.add(new Computer(i));
        }
        services = new ArrayList<>();
    }

    public void turnOnComputer(int computerId) {
        Computer computer = findComputerById(computerId);
        if (computer != null && !computer.isOn() && !computer.isUsing()) {
            computer.turnOn();
            System.out.println("Computer " + computerId + " has been turned on.");
        } else {
            System.out.println("Cannot turn on computer " + computerId + ". It is either already on or being used.");
        }
    }

    public void turnOffComputer(int computerId, int hoursUsed) {
        Computer computer = findComputerById(computerId);
        if (computer != null && computer.isOn() && computer.isUsing()) {
            computer.turnOff();
            int totalPrice = hoursUsed * 15000;
            for (Service service : services) {
                totalPrice += service.getPrice();
            }
            System.out.println("Computer " + computerId + " has been turned off.");
            System.out.println("Total price: " + totalPrice + " VND");
        } else {
            System.out.println("Cannot turn off computer " + computerId + ". It is either already off or not being used.");
        }
    }

    public void displayComputers() {
        System.out.println("List of computers:");
        for (Computer computer : computers) {
            System.out.println("Computer " + computer.getId() + ": " + (computer.isOn() ? "ON" : "OFF"));
        }
    }

    public void addService(String name, int price) {
        services.add(new Service(name, price));
        System.out.println("Service '" + name + "' added with price " + price + " VND.");
    }

    private Computer findComputerById(int id) {
        for (Computer computer : computers) {
            if (computer.getId() == id) {
                return computer;
            }
        }
        return null;
    }
}
