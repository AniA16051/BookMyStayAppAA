import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CancellationService {

    private Stack<String> releasedRoomIds;
    private Map<String, String> reservationRoomTypeMap;

    public CancellationService() {
        releasedRoomIds = new Stack<>();
        reservationRoomTypeMap = new HashMap<>();
    }

    public void registerBooking(String GuestName, String roomType) {
        reservationRoomTypeMap.put(GuestName, roomType);
    }

    public void cancelBooking(String GuestName, RoomInventory inventory) {
        if (!reservationRoomTypeMap.containsKey(GuestName)) {
            System.out.println("Cancellation failed: No booking found for Reservation ID: " + GuestName);
            return;
        }

        String roomType = reservationRoomTypeMap.get(GuestName);
        String shortType = roomType.replace(" Room", "");

        // Push to rollback stack
        releasedRoomIds.push(GuestName);

        // Restore inventory
        Map<String, Integer> availability = inventory.getRoomAvailability();
        inventory.updateAvailability(roomType, availability.get(roomType) + 1);

        // Remove from map
        reservationRoomTypeMap.remove(GuestName);

        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + shortType);
    }

    public void showRollbackHistory(RoomInventory inventory) {
        System.out.println("\nRollback History (Most Recent First):");
        Stack<String> temp = (Stack<String>) releasedRoomIds.clone();
        while (!temp.isEmpty()) {
            String roomId = temp.pop();
        }

        // Show updated availability for Single Room
        System.out.println("\nUpdated Single Room Availability: "
                + inventory.getRoomAvailability().get("Single Room"));
    }
}