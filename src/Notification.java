import java.time.LocalTime;
import java.util.Date;

/**
 * Egy értesítés adatai: mikor, miről, hogyan értesít, és melyik eventhez tartozik
 * Ha elsütik, kiírja az adatait
 */
public class Notification {

    /**
     * A notification tulajdonosa
     */
    private Event ownerEvent;

    /**
     * Az értesítés ideje
     */
    private Date notificationTime;

    /**
     * Az értesítés módja
     */
    private String notificationMode;	//hang, rezgés, akármi

    /**
     * Értesítés szövege
     */
    private String text;

    public Notification( Date time ) {
        notificationTime = time;
    }

    /**
     * Megadja, melyik eseményhez tartozik a notification
     * @return Esemény, amelyhez tartozik a notification
     */
    public Event getOwnerEvent() {
        return ownerEvent;
    }

    /**
     * Beállítja, melyik eseményhez tartozik a notification
     * @param e Esemény, amihez a notification tartozik
     */
    public void setEvent(Event e) {
        ownerEvent = e;
    }

    /**
     * Visszaadja az értesítés idejét
     * @return Az értesítés ideje
     */
    public Date getNotificationTime() {return notificationTime;}

    /**
     * Az értesítés "végrehajtása" - egyelőre kiírok vmit a konzolra
     */
    public void execute() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Notification at " + notificationTime.toString() + ", for " + ownerEvent.toString();
    }
}
