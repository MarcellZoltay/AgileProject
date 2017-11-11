import java.util.ArrayList;

public class Calendar {

    // ez az osztály kezeli az időzítést,
    // vagyis én úgy képzeltem el, hogy ide regisztáljuk
    // az időzítést igénylő dolgokat

    // mint egy Timernél, amikor elérkezik a megfelelő időpont, végrehajtja amit kell

    private static ArrayList<Event> events = new ArrayList<>();	// csak hogy valahol el legyenek tárolva
    private static ArrayList<Notification> notifs = new ArrayList<>(); //egyelőre csak egy lista...

    public static void registerNotification(Notification n) {

    }

}
