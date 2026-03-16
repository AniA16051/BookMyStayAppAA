import java.util.Map;
class BookMyStay {

    public static void main(String[] args) {
        System.out.println("Booking History and Reporting\n");
        BookingHistory history = new BookingHistory();
        BookingReportService reportService = new BookingReportService();
        history.addReservation(new Reservation("Ani", "Single"));
        history.addReservation(new Reservation("AVi", "Double"));
        history.addReservation(new Reservation("Anirudh", "Suite"));

        reportService.generateReport(history);
    }

}