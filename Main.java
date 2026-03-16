import java.util.Map;
class BookMyStay {
    public static void main(String[] args) {
        System.out.println("Booking Request Queue");

        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Create booking requests
        Reservation r1 = new Reservation("Ani", "Single");
        Reservation r2 = new Reservation("AVi", "Double");
        Reservation r3 = new Reservation("Anirudh", "Suite");

        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        while (bookingQueue.hasPendingRequests()) {
            Reservation current = bookingQueue.getNextRequest();
            System.out.println("Processing booking for Guest: " + current.getGuestName() +
                    ", Room Type: " + current.getRoomType());
        }
    }

}