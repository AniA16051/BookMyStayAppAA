import java.util.Map;
class BookMyStay {
    public static void main(String[] args) {
        System.out.println("Add-On Service Selection");

        // 1. Initialize Manager
        AddOnServiceManager manager = new AddOnServiceManager();

        // 2. Define Services
        AddOnService breakfast = new AddOnService("Breakfast", 500.0);
        AddOnService spa = new AddOnService("Spa", 1000.0);

        // 3. Attach services to a specific Reservation ID (e.g., "Single-1")
        String resId = "Single-1";
        manager.addService(resId, breakfast);
        manager.addService(resId, spa);

        // 4. Output Results
        System.out.println("Reservation ID: " + resId);
        System.out.println("Total Add-On Cost: " + manager.calculateTotalServiceCost(resId));
    }


}