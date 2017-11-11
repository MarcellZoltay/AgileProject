import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Calendar {

    // ez az osztály kezeli az időzítést,
    // vagyis én úgy képzeltem el, hogy ide regisztráljuk
    // az időzítést igénylő dolgokat

    // mint egy Timernél, amikor elérkezik a megfelelő időpont, végrehajtja amit kell

    private static ArrayList<Event> events = new ArrayList<>();	// csak hogy valahol el legyenek tárolva

    // Az értesítéseket egy map-ben tároljuk, ahol a kulcs az értesítés időpontja,
    //  a hozzá tartozó érték egy lista, ha esetleg több értesítést is kell megjeleníteni azonos időpontban.
    private static HashMap<Date, ArrayList<Notification> > notifications = new HashMap<>();

    public static void registerNotification(Notification n) {

        Date date = n.getNotificationTime();
        ArrayList<Notification> list = notifications.get(date);
        if (list == null) {
            ArrayList<Notification> newlist = new ArrayList<>();
            newlist.add(n);
            notifications.put(date, newlist);
        }
        else {
            list.add(n);
        }

    }

    //tick a neve, hogy világos legyen, a timerhez hasonló működés van itt
    // úgy képzeltem el, beadjuk neki, hogy mennyi az idő, és kiíratjuk, ha van ekkor értesítés
    public void tick(Date date) {

        ArrayList<Notification> list = notifications.get(date);
        if (list == null) return;
        else {
            for (Notification n : list) {
                n.execute();
            }
        }

    }

}
