import java.time.LocalTime;
import java.util.Date;

public class Notification {

    private Event ownerEvent;

    private Date notificationTime;

    private String notificationMode;	//hang, rezgés, akármi

    private String text;

    public void setEvent(Event e) {
        //eltároljuk, hogy melyik eseményhez tartozik
        ownerEvent = e;
    }

    public Event getOwnerEvent() {
        return ownerEvent;
    }
    public Date getNotificationTime() {return notificationTime;}

    //az értesítés "végrehajtása" - egyelőre kiírok vmit a konzolra
    public void execute() {
        System.out.println("notification");
    }
}
