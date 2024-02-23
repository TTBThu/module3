public class Main {
    public static void main(String[] args) {
        CyberCafe cyberCafe = new CyberCafe(10); // 10 computers

        // Turn on computer 1
        cyberCafe.turnOnComputer(1);

        // Display list of computers
        cyberCafe.displayComputers();

        // Add service
        cyberCafe.addService("Nước ngọt", 5000);

        // Turn off computer 1 after 2 hours
        cyberCafe.turnOffComputer(1, 2);
    }
}
