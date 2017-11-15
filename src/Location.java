//https://stackoverflow.com/questions/1253499/simple-calculations-for-working-with-lat-lon-km-distance
//
//    Latitude: 1 deg = 110.574 km
//    Longitude: 1 deg = 111.320*cos(latitude) km

/**
 * Egy helyszínt tárol el névvel, és szélességi-hosszúsági koordinátákkal
 * Valamint tud távolságot számolni két helyszín között
 */
public class Location {

    // *** adatok: név, szélességi és hosszúsági koordináta ***

    private String name;
    private double latitude;
    private double longitude;

    public Location(String name, double lat, double lon) {
        this.name = name;
        latitude = lat;
        longitude = lon;
    }

    // *** getterek ***

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Távolság számolása a stackoverflow féle képlettel, link fent
     * @param l A másik helyszín, amihez képest nézni kell a távolságot
     * @return A két helyszín távolsága km-ben
     */
    public double distanceTo(Location l) {
        double latkm = Math.abs(this.latitude - l.latitude) * 110.574;
        double lonkm = Math.abs(this.longitude - l.longitude) * 111.320 * Math.cos(Math.toRadians(this.latitude));
        return Math.sqrt(latkm * latkm + lonkm * lonkm);
    }
}
