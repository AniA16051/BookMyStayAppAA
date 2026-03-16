import java.util.Map;
class BookMyStay {
    public static void main(String[] args) {
        System.out.println("Room Allocation Processing");

        // 1. Setup Inventory and Allocation Service
        RoomInventory inventory = new RoomInventory();
        RoomAllocationService allocationService = new RoomAllocationService();

        // 2. Setup Booking Queue (FIFO)
        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        bookingQueue.addRequest(new Reservation("Ani", "Single"));
        bookingQueue.addRequest(new Reservation("AVi", "Single"));
        bookingQueue.addRequest(new Reservation("Anirudh", "Suite"));

        // 3. Process the Queue
        while (bookingQueue.hasPendingRequests()) {
            Reservation request = bookingQueue.getNextRequest();
            allocationService.allocateRoom(request, inventory);
        }
    }

}