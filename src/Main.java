import java.util.Date;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("Hello World!");

        java.util.Calendar start = java.util.Calendar.getInstance();
        java.util.Calendar finish = java.util.Calendar.getInstance();

        start.set(2017, 11, 15, 10, 15);
        finish.set(2017, 11, 15, 12, 00);
        Event elsoOra = new Event(start.getTime(), finish.getTime(), "Elso ora", 2);

        start.set(2017, 11, 15, 12, 15);
        finish.set(2017, 11, 15, 14, 00);
        Event agilisOra = new Event(start.getTime(), finish.getTime(), "Agilis ora", 2);

        start.set(2017, 11, 15, 20, 00);
        finish.set(2017, 11, 15, 23, 00);
        Event sorozes = new Event(start.getTime(), finish.getTime(), "Sorozes", 2);

        Event e1 = new Event( new Date(), null, "Talalkozo Kataval", 2);

    }
}
