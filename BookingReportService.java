import java.util.List;

public class BookingReportService {

    public void generateReport(BookingHistory history) {
        System.out.println("Booking History Report");
        List<Reservation> bookings = history.getConfirmedReservations();

        for (Reservation res : bookings) {
            System.out.println("Guest: " + res.getGuestName() +
                    ", Room Type: " + res.getRoomType());
        }
    }
}