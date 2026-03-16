import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class RoomAllocationService {

    private Set<String> allocatedRoomIds;

    private Map<String, Set<String>> assignedRoomsByType;

    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();

        // Initialize the map for each room type
        assignedRoomsByType.put("Single", new HashSet<>());
        assignedRoomsByType.put("Double", new HashSet<>());
        assignedRoomsByType.put("Suite", new HashSet<>());
    }

    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String type = reservation.getRoomType();
        Map<String, Integer> currentInv = inventory.getRoomAvailability();

        String inventoryKey = type + " Room";

        if (currentInv.getOrDefault(inventoryKey, 0) > 0) {
            String roomId = generateRoomId(type);
            allocatedRoomIds.add(roomId);
            assignedRoomsByType.get(type).add(roomId);

            inventory.updateAvailability(inventoryKey, currentInv.get(inventoryKey) - 1);

            System.out.println("Booking confirmed for Guest: " + reservation.getGuestName() +
                    ", Room ID: " + roomId);
        } else {
            System.out.println("Booking failed for Guest: " + reservation.getGuestName() +
                    ". No " + type + " rooms available.");
        }
    }

    private String generateRoomId(String roomType) {
        int nextId = assignedRoomsByType.get(roomType).size() + 1;
        return roomType + "-" + nextId;
    }
}