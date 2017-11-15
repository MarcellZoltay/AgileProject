/**
 * Helyszínek közötti időbeli távolságokat számol
 * Távolsággal megadva, vagy két helyszínnel megadva
 * Vannak előre megadott sebességkonstansok (gyaloglás, autó, ...)
 */
public class TravelHelper {

    /**
     * Egy távolságot mennyi percig tart megtenni adott sebességgel
     * @param distance Távolság
     * @param speed Sebesség
     * @return Mennyi perc az útidő
     */
    public static int getTravelMinutes(double distance, int speed) {
        return (int)(getTravelHours(distance, speed) * 60);
    }

    /**
     * Két helyszín között mennyi perc az út adott sebességgel
     * @param l1 Helyszín 1
     * @param l2 Helyszín 2
     * @param speed Sebesség
     * @return Szükséges idő percekben a helyszínek között
     */
    public static int getTravelMinutes(Location l1, Location l2, int speed) {
        double distance =l1.distanceTo(l2);
        return getTravelMinutes(distance, speed);
    }

    /**
     * Egy távolságot mennyi óráig tart megtenni adott sebességgel
     * @param distance Távolság
     * @param speed Sebesség
     * @return Mennyi óra az útidő
     */
    public static double getTravelHours(double distance, int speed) {
        return distance / speed;
    }

    /**
     * Két helyszín között mennyi óra az út adott sebességgel
     * @param l1 Helyszín 1
     * @param l2 Helyszín 2
     * @param speed Sebesség
     * @return Szükséges idő órában a helyszínek között
     */
    public static double getTravelHours(Location l1, Location l2, int speed) {
        double distance = l1.distanceTo(l2);
        return getTravelHours(distance, speed);
    }

    // *** konstansok sebsségekhez ***

    public static final int WalkSpeed = 5;
    public static final int PublicTransportSpeed = 17;
    public static final int CarSpeed = 35;
    public static final int CarSpeedRushHours = 25;
}
