import java.util.Date;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("Hello World!");

        Location petofi = new Location("Petőfi híd budai hídfő", 47.477103, 19.059922);
        Location corvin = new Location("Corvin negyed", 47.485722, 19.069985);
        Location iq = new Location("BME IQ", 47.472850, 19.059123);

        java.util.Calendar start = java.util.Calendar.getInstance();
        java.util.Calendar finish = java.util.Calendar.getInstance();

        start.set(2017, java.util.Calendar.NOVEMBER, 15, 10, 15);
        finish.set(2017, java.util.Calendar.NOVEMBER, 15, 12, 0);
        Event elsoOra = new Event(start.getTime(), finish.getTime(), "Elso ora", 2);
        elsoOra.setLocation(petofi);
        elsoOra.setTravelTime(TravelHelper.getTravelMinutes(corvin, petofi, TravelHelper.PublicTransportSpeed));

        start.set(2017, java.util.Calendar.NOVEMBER, 15, 12, 15);
        finish.set(2017, java.util.Calendar.NOVEMBER, 15, 14, 0);
        Event agilisOra = new Event(start.getTime(), finish.getTime(), "Agilis ora", 2);
        agilisOra.setLocation(iq);
        agilisOra.setTravelTime(TravelHelper.getTravelMinutes(petofi, iq, TravelHelper.WalkSpeed));

        start.set(2017, java.util.Calendar.NOVEMBER, 15, 20, 0);
        finish.set(2017, java.util.Calendar.NOVEMBER, 15, 23, 0);
        Event sorozes = new Event(start.getTime(), finish.getTime(), "Sorozes", 4);
        sorozes.setLocation(corvin);
        sorozes.setTravelTime(TravelHelper.getTravelMinutes(iq, corvin, TravelHelper.PublicTransportSpeed));

        //Event e1 = new Event( new Date(), null, "Talalkozo Kataval", 2);

        // a továbbiakban "start"-ot növeljük, 7:00-tól megyünk 20:00-ig
        start.set(2017, java.util.Calendar.NOVEMBER, 15, 7, 0);
        finish.set(2017, java.util.Calendar.NOVEMBER, 15, 20, 0);

        while (true) {

            Date dt = start.getTime();
            if (dt.after(finish.getTime())) { break; }

            Calendar c = Calendar.getInstance();
            c.tick(dt); //kiírja, ha van valami értesítés erre az időpontra
            start.add(java.util.Calendar.MINUTE, 1);

        }

    }
}
