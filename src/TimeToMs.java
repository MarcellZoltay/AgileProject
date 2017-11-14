/**
 * Miliszekundumokká alakítja a megadott időt,
 * kód szempontjából olvasható formában, pl.
 * 1 * 60 * 60 * 1000 helyett írhatom, hogy
 * new TimeToMs(1).hours()
 */
public class TimeToMs {

    /**
     * A kérdéses idő, még nem tudjuk milyen egységben
     */
    private int time;

    /**
     * Valamilyen időmennyiséget kell megadni, még nem tudjuk milyen időegységgel
     * (majd a minutes és az hours mondja meg)
     * @param time Valamilyen időmennyiség
     */
    public TimeToMs(int time) {
        this.time = time;
    }

    /**
     * Az időmennyiséget percben kell érteni
     * @return A percben értelmezett idő miliszekundumokban
     */
    public int minutes() {
        return this.time * 60 * 1000;
    }

    /**
     * Az időmennyiséget órában kell érteni
     * @return Az órában értelmezett idő miliszekundumokban
     */
    public int hours() {
        return this.time * 60 * 60 * 1000;
    }
}
