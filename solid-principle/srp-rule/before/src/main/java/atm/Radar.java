package atm;

import atm.coordinates.CoordinateOutputFormatter;

import java.util.List;

public class Radar {
    private int originLat;
    private int originLon;

    public Radar(int originLat, int originLon) {
        this.originLat = originLat;
        this.originLon = originLon;
    }

    public String getAircraftInRange(int range, List<AircraftTarget> allAircraft, CoordinateOutputFormatter formatter) {
        var aircraftInRange = allAircraft
                .stream()
                .filter(a -> {
                    var distance = (int) Math.sqrt(
                            (originLat - a.lat()) * (originLat - a.lat()) +
                                    (originLon - a.lon()) * (originLon - a.lon()));
                    return distance <= range;
                })
                .toList();

//        return buildAircraftInRange(latFirst, aircraftInRange);
        return formatter.parse(allAircraft);
    }

    private String buildAircraftInRange(boolean latFirst, List<AircraftTarget> aircraftInRange) {
        var sb = new StringBuilder();
        if (latFirst) {
            aircraftInRange.forEach(a -> sb.append(parse(a.lon(), a.lat())));
        }
        else {
            aircraftInRange.forEach(a -> sb.append(parse(a.lat(), a.lon())));
        }
        return sb.toString();
    }

    private String parse(int first, int second) {
        return String.format("[%o %o]", first, second);
    }
}
