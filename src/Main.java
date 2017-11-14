import java.util.Date;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("Hello World!");

        java.util.Calendar start = java.util.Calendar.getInstance();
        java.util.Calendar finish = java.util.Calendar.getInstance();

        start.set(2017, start.NOVEMBER, 15, 10, 15);
        finish.set(2017, finish.NOVEMBER, 15, 12, 0);
        Event elsoOra = new Event(start.getTime(), finish.getTime(), "Elso ora", 2);

        start.set(2017, start.NOVEMBER, 15, 12, 15);
        finish.set(2017, finish.NOVEMBER, 15, 14, 0);
        Event agilisOra = new Event(start.getTime(), finish.getTime(), "Agilis ora", 2);

        start.set(2017, start.NOVEMBER, 15, 20, 0);
        finish.set(2017, finish.NOVEMBER, 15, 23, 0);
        Event sorozes = new Event(start.getTime(), finish.getTime(), "Sorozes", 2);

        Event e1 = new Event( new Date(), null, "Talalkozo Kataval", 2);

    }
}
