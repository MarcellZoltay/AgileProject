import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Időzítést kezelő osztály.
 * Rendelkezik eventekkel, és a különböző dátumhoz tartozó notificationökkel.
 * Hozzáad eventet, notificationt.
 * Le tudja kérdezni, hogy adott dátumra van-e notification.
 */
public class Calendar {

    // ez az osztály kezeli az időzítést,
    // vagyis én úgy képzeltem el, hogy ide regisztráljuk
    // az időzítést igénylő dolgokat

    // mint egy Timernél, amikor elérkezik a megfelelő időpont, végrehajtja amit kell

    /**
     * Eventek listája
     */
    private ArrayList<Event> events = new ArrayList<>();	// csak hogy valahol el legyenek tárolva

    // Az értesítéseket egy map-ben tároljuk, ahol a kulcs az értesítés időpontja,
    //  a hozzá tartozó érték egy lista, ha esetleg több értesítést is kell megjeleníteni azonos időpontban.
    /**
     * Adott időponthoz tartozó értesítések listája
     */
    private HashMap<Date, ArrayList<Notification> > notifications = new HashMap<>();

    /// SINGLETON ///
    private static Calendar instance = new Calendar();
    public static Calendar getInstance(){ return instance; }

    private Calendar(){}

    /**
     * Notification beregisztrálása a megfelelő dátumhoz
     * @param n A regisztrálandó notification
     */
    public void registerNotification(Notification n) {

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

    /**
     * Event hozzáadása
     * @param e A hozzáadandó event
     */
    public void addEvent(Event e) {
        events.add(e);
    }

    //tick a neve, hogy világos legyen, a timerhez hasonló működés van itt
    // úgy képzeltem el, beadjuk neki, hogy mennyi az idő, és kiíratjuk, ha van ekkor értesítés
    /**
     * Adott dátumú notificationöket elsüti.
     * @param date Melyik dátumon levő notificationöket süsse el.
     */
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
