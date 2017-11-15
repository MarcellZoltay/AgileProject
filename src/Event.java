import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

/**
 * Egy event adatait tároló osztály: név, kezdés, vége
 * Ezenkívül legenerálja az eventhez tartozó notificationöket, amik gyakorisága, kezdete, stb. beállítható
 */
public class Event {

    // ****************** ötletek ********************

    //lehetne a location is egy class, amiben eltároljuk az egyes helyszínekhez,
    // hogy milyen távol vannak, mennyi idő alatt szoktunk odaérni,
    // általában milyen a forgalom...
    // eltárolhatunk ilyeneket, mint "otthon", "munkahely", ...

    // ***********************************************

    // *** értesítések adatainak alapértékei ***

    public static final int defaultNotificationCount = 1;   //defaultban hány darab értesítés legyen
    public static final int defaultNotificationFrequency = new TimeToMs(30).minutes(); // milyen gyakran legyen értesítés, milliszekundumban, default 30 perc
    public static final int defaultNotificationStart = new TimeToMs(30).minutes();  // mennyivel az esemény előtt kezdődjön az értesítés, default 30 perc
    public static final int defaultEstimatedTime = new TimeToMs(30).minutes();
    public static final int basePriority = 1;

    // *** értesítések adatai ***

    private static int notificationCount;      // ezek azok az értékek, amiket állítunk, amiket a felhasználó "finomíthat"
    private static int notificationFrequency;
    private static int notificationStart;
    private int estimatedTimeNecessary;
    private int priority;

    // *** esemény adatai ***

    private Location location;
    private Date startTime;     //kötelező
    private Date endTime;
    private String text;        //kötelező

    /**
     * Eseményhez tartozó értesítések
     */
    private ArrayList<Notification> notifications = new ArrayList<>();

    public Event(Date startTime, Date endTime, String text, int priority) {
        this.startTime = startTime;

        if (endTime == null)
            this.endTime = new Date(startTime.getTime() + new TimeToMs(1).hours()); // defaultban 1 órás események
        else
            this.endTime = endTime;

        this.text = text;
        this.priority = priority;

        setDefaultValues();

        generateNotifications();
    }

    private void generateNotifications() {
        // képleteket használva
        //   létrehozunk értesítéseket, időzítjük, ...

        //milyen hosszú úttal számolunk
        double tripTime = estimatedTimeNecessary * (basePriority + (priority - 1) * 0.5);

        // első értesítés az indulás előtt mennyivel legyen
        double preparationTime = notificationStart * (basePriority + (priority - 1) * 0.5);

        // hány darab értesítés legyen
        int howManyNotifs = priority;

        // milyen gyakran legyen értesítés
        double timeBetweenNotifs = notificationStart / (priority + 1);

        // ciklus: indulunk startTime - estimatedTime - preparationTime-tól
        //      hányszor: howManyNotifs
        //      lépés: howOften
        //      minden lépésnél létrehozunk egy új Notificationt, időzítjük a pillanatnyi adatok szerint

        double t = startTime.getTime() - tripTime - preparationTime;

        for (int i=0; i < howManyNotifs; i++) {
            Notification n = new Notification(new Date((long)(t)));
            n.setEvent(this);
            notifications.add(n);
            Calendar.registerNotification(n);

            t += timeBetweenNotifs;
        }

    }

    //egyelőre...
    private void setDefaultValues() {
        notificationCount = defaultNotificationCount;
        notificationFrequency = defaultNotificationFrequency;
        notificationStart = defaultNotificationStart;
        estimatedTimeNecessary = defaultEstimatedTime;
        priority = basePriority;
    }

    public void feedbackData() {
        //TODO: itt finomítjuk az adatokat a visszajelzés alapján
    }

    /**
     * Beállítja az esemény helyszínét a megadott helyre
     * @param location Az esemény leendő helyszíne
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Beállított útidő lekérése
     * Ez előre meg van adva, egy fix másik helyhez képest.
     * Kicsit nehézkes így, viszont így nem kellett módosítani az eddigi kódon
     * @return Az útidő percekben
     */
    public int getTravelTime() {
        return (int)(this.estimatedTimeNecessary / 60 / 1000);
    }

    /**
     * A súlyozó logikával együtt vett, előre beállított útidő lekérése
     * Az útidő előre meg van adva, egy fix másik helyhez képest.
     * Kicsit nehézkes így, viszont így nem kellett módosítani az eddigi kódon
     * @return A súlyozott útidő percekben
     */
    public int getTravelTimeWithPriority() {
        double tripTime = estimatedTimeNecessary * (basePriority + (priority - 1) * 0.5);
        return (int)(tripTime / 60 / 1000);
    }

    /**
     * Egy fix helyszínhez vett utazási idő beállítása percekben
     * Az eddigi logikát nem bántja, kicsit nehézkes
     * @param travelMinutes Útidő percben
     */
    public void setTravelTime(int travelMinutes) {
        this.estimatedTimeNecessary = new TimeToMs(travelMinutes).minutes();
    }

    // *** getterek ***

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public String getText() {
        return text;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return this.text + " at " + startTime.toString();
    }

}
