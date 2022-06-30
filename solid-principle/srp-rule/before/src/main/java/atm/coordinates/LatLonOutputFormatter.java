package atm.coordinates;

import atm.AircraftTarget;

import java.util.List;

public class LatLonOutputFormatter extends CoordinateOutputFormatter{

    @Override
    public String parse(List<AircraftTarget> targets) {
        StringBuilder sb = new StringBuilder();
        targets.forEach(a -> sb.append(buildLocation(a.lat(), a.lon())));
        return sb.toString();
    }
}
