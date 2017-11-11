import java.time.LocalTime;

public class Notification {

    private Event ownerEvent;

    private LocalTime notificationTime;

    private String notificationMode;	//hang, rezgés, akármi

    public void setEvent(Event e) {
        //eltároljuk, hogy melyik eseményhez tartozik
        ownerEvent = e;
    }

    public Event getOwnerEvent() {
        return ownerEvent;
    }

}
