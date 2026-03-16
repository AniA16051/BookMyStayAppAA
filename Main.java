import java.util.Map;
class BookMyStay {
    public static void main(String[] args) {
        System.out.println("Room Search\n");

        RoomInventory inventory = new RoomInventory();
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        RoomSearchService searchService = new RoomSearchService();

        searchService.searchAvailableRooms(inventory, single, doubleRoom, suite);
    }

}