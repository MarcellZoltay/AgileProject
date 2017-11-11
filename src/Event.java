import java.time.LocalTime;
import java.util.ArrayList;

public class Event {

    //lehetne a location is egy class, amiben eltároljuk az egyes helyszínekhez,
    // hogy milyen távol vannak, mennyi idő alatt szoktunk odaérni,
    // általában milyen a forgalom...
    // eltárolhatunk ilyeneket, mint "otthon", "munkahely", ...

    private String location;
    private LocalTime startTime;
    private LocalTime endTime;
    private int estimatedTimeNecessary;
    private String type;
    private int priority;
    private ArrayList<Notification> notifications = new ArrayList<>();

    public void setNotification() {

        Notification n = setDefaultNotification();
        // vagy mi adunk beállításokat, vagy a setDefaultNotification-t hívjuk

        // ...

        n.setEvent(this);
        notifications.add(n);
        Calendar.registerNotification(n);
    }

    private Notification setDefaultNotification() {
        // ez az a metódus, ahol valamilyen algoritmus szerint "találjuk ki",
        // hogy mikor legyen, és milyen értesítés, hány darab, stb.
        Notification n = new Notification();

        //...

        return n;
    }
}
